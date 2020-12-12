package by.bsac.profile.model;

import by.bsac.profile.PersonRole;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Person implements Serializable {
    private Long id;
    private String email;
    private String name;
    private String password;
    private Date loginDate;
    private PersonRole role;

    public Person(Long id, String email, String name, String password, PersonRole role, Date loginDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.loginDate = loginDate;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public PersonRole getRole() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) &&
                email.equals(person.email) &&
                name.equals(person.name) &&
                password.equals(person.password) &&
                loginDate.equals(person.loginDate) &&
                role == person.role;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0: email.hashCode());
        result = prime * result + ((id == null) ? 0: id.hashCode());
        result = prime * result + ((loginDate == null) ? 0: loginDate.hashCode());
        result = prime * result + ((name == null) ? 0: name.hashCode());
        result = prime * result + ((password == null) ? 0: password.hashCode());
        result = prime * result + ((role == null) ? 0: role.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", loginDate=" + loginDate +
                ", role=" + role +
                '}';
    }
}
