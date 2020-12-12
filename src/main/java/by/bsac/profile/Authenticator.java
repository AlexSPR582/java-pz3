package by.bsac.profile;

import by.bsac.profile.model.Person;

public interface Authenticator {
    Person authenticateByUserName(String username, String password);
    Person authenticateByUserEmail(String email, String password);
}
