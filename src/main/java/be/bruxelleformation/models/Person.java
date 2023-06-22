package be.bruxelleformation.models;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private final String firstname;
    private final LocalDate birthDate;
    private String lastname;

    public Person(String lastname, String firstname, LocalDate birthDate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthDate = birthDate;
    }

    public Person(Person toCopy) {
        this.lastname = toCopy.lastname;
        this.firstname = toCopy.firstname;
        this.birthDate = toCopy.birthDate;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this ==
                o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return lastname.equals(person.lastname) && firstname.equals(person.firstname) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, birthDate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("lastname='" + lastname + "'")
                .add("firstname='" + firstname + "'")
                .add("birthDate=" + birthDate)
                .toString();
    }
}
