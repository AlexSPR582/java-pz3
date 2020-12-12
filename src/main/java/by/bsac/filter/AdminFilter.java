package by.bsac.filter;

import by.bsac.profile.ProfileTools;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if (uri.startsWith("/study_pz3_war/BSAC/allUsers")) {
            HttpSession session = request.getSession();
            if (session.getAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_NAME) == null) {
                request.getServletContext().
                        getRequestDispatcher("/BSAC/login.jsp").
                        forward(request, resp);
            }
            else if (session.getAttribute(ProfileTools.PERSON_IS_ADMIN) == null) {
                request.getServletContext().
                        getRequestDispatcher("/BSAC/home.jsp").
                        forward(request, resp);
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
