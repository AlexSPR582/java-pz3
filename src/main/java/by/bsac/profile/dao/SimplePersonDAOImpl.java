package by.bsac.profile.dao;

import by.bsac.profile.PersonRole;
import by.bsac.profile.model.Person;

import java.util.HashSet;
import java.util.Set;

public class SimplePersonDAOImpl implements PersonDAO {
    private Set<Person> persons = new HashSet<>();
    private static SimplePersonDAOImpl simplePersonDAOImpl = new SimplePersonDAOImpl();

    private SimplePersonDAOImpl() {
        persons.add(new Person(1L, "john@john.com", "john", "john123", PersonRole.ADMIN, null));
        persons.add(new Person(2L, "peter@peter.com", "peter", "peter123", PersonRole.REGISTERED, null));
        persons.add(new Person(3L, "alex@alex.com", "alex", "alex123", PersonRole.REGISTERED, null));
    }

    public static SimplePersonDAOImpl getInstance() {
        return simplePersonDAOImpl;
    }

    @Override
    public Long add(Person person) {
        persons.add(person);
        return person.getId();
    }

    @Override
    public Long save(Person person) {
        if (persons.contains(person)) {
            persons.remove(person);
        }
        persons.add(person);
        return person.getId();
    }

    @Override
    public boolean delete(Person person) {
        return persons.remove(person);
    }

    @Override
    public Person findByName(String name) {
        for (Person person: persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public boolean update(Person person) {
        if (persons.contains(person)) {
            persons.remove(person);
        }
        return persons.add(person);
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person: persons) {
            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Set<Person> getAll() {
        return getPersons();
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
