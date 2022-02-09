package pl.sda.java.adv.school.model;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
    private String id;
    private String lastName;
    private String firstName;
    private short startYear;
    private byte schoolYear;
    private char classCode;
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

    public short getStartYear() {
        return startYear;
    }

    public void setStartYear(short startYear) {
        this.startYear = startYear;
    }

    public byte getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(byte schoolYear) {
        this.schoolYear = schoolYear;
    }

    public char getClassCode() {
        return classCode;
    }

    public void setClassCode(char classCode) {
        this.classCode = classCode;
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
        return "Student{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", startYear=" + startYear +
                ", schoolYear=" + schoolYear +
                ", classCode=" + classCode +
                ", birthDate=" + birthDate +
                ", address=" + address +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int lastNameResult = lastName.compareTo(o.lastName);
        if (lastNameResult != 0) {
            return lastNameResult;
        }
        return firstName.compareTo(o.firstName);
    }
}
