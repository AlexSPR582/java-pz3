package by.bsac.profile.dao;

import by.bsac.profile.model.Person;

import java.util.Set;

public interface PersonDAO {
    Long add(Person person);
    Long save(Person person);
    boolean delete(Person person);
    Person findByName(String name);
    boolean update(Person person);
    Person findByEmail(String email);
    Set<Person> getAll();
}
