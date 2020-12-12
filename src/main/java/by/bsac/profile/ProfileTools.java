package by.bsac.profile;

import by.bsac.profile.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProfileTools {
    public static String SESSION_LOGGEDIN_ATTRIBUTE_NAME = "user";
    public static String PERSON_IS_ADMIN = "isAdmin";
    public static String ALL_PERSONS_ATTRIBUTE_NAME = "users";

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null &&
                session.getAttribute(SESSION_LOGGEDIN_ATTRIBUTE_NAME) != null;
    }

    public static boolean isAdmin(Person person) {
        boolean isAdmin = false;
        if (person != null) {
            switch (person.getRole()) {
                case ADMIN:
                    isAdmin = true;
                    break;
                default:
                    isAdmin = false;
            }
        }
        return isAdmin;
    }

    public static Date generatedLoginDate() {
        return new Date();
    }
}
