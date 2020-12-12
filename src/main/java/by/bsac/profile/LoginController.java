package by.bsac.profile;

import by.bsac.profile.dao.PersonDAO;
import by.bsac.profile.dao.SimplePersonDAOImpl;
import by.bsac.profile.model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private PersonDAO personDAO = SimplePersonDAOImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String authAction = request.getParameter("authAction");
        if (authAction.equals("login")) {
            login(request, response);
        } else if (authAction.equals("logout")) {
            logout(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/BSAC/error-login.jsp");
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/BSAC/login.jsp");
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String authTypeParam = request.getParameter("authType");
        Authenticator authenticator = new SimpleAuthenticatorImpl();
        Person person;
        String password = request.getParameter("psw");
        String authValue = request.getParameter("loginValue");
        if (authTypeParam.equals("email")) {
            person = authenticator.authenticateByUserEmail(authValue, password);
        } else {
            person = authenticator.authenticateByUserName(authValue, password);
        }
        if (person != null) {
            HttpSession session = request.getSession();
            person.setLoginDate(ProfileTools.generatedLoginDate());
            getPersonDAO().save(person);
            session.setAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_NAME, person.getName());
            if (ProfileTools.isAdmin(person)) {
                session.setAttribute(ProfileTools.PERSON_IS_ADMIN, true);
                session.setAttribute(ProfileTools.ALL_PERSONS_ATTRIBUTE_NAME, getPersonDAO().getAll());
            }
            response.sendRedirect(request.getContextPath() + "/BSAC/home.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/BSAC/error-login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/BSAC/login.jsp");
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
}
