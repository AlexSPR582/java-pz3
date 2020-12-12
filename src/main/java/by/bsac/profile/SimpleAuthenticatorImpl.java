package by.bsac.profile;

import by.bsac.profile.dao.PersonDAO;
import by.bsac.profile.dao.SimplePersonDAOImpl;
import by.bsac.profile.model.Person;

public class SimpleAuthenticatorImpl implements Authenticator {
    private PersonDAO personDAO = SimplePersonDAOImpl.getInstance();

    @Override
    public Person authenticateByUserName(String username, String password) {
        Person person = getPersonDAO().findByName(username);
        if (isValidPassword(person, password)) {
            return person;
        }
        return null;
    }

    @Override
    public Person authenticateByUserEmail(String email, String password) {
        Person person = getPersonDAO().findByEmail(email);
        if (isValidPassword(person, password)) {
            return person;
        }
        return null;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    private boolean isValidPassword(Person person, String password) {
        return person != null && person.getPassword().equals(password);
    }
}
