package pl.sda.java.adv.school.model;

import java.time.LocalDate;
import java.util.Set;

public class Teacher implements Comparable<Teacher>{
    private String id;
    private String lastName;
    private String firstName;
    private Set<String> classTypes;
    private LocalDate birthDate;
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<String> getClassTypes() {
        return classTypes;
    }

    public void setClassTypes(Set<String> classTypes) {
        this.classTypes = classTypes;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", classTypes=" + classTypes +
                ", birthDate=" + birthDate +
                ", address=" + address +
                '}';
    }

    @Override
    public int compareTo(Teacher o) {
        int lastNameResult = lastName.compareTo(o.lastName);
        if (lastNameResult != 0) {
            return lastNameResult;
        }
        return firstName.compareTo(o.firstName);
    }
}
