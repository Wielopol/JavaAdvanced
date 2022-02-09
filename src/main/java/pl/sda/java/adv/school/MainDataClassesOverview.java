package pl.sda.java.adv.school;

import pl.sda.java.adv.school.model.Student;

import java.util.Arrays;
import java.util.List;

public class MainDataClassesOverview {

    public static void main(String[] args) {
        Student student1 = new Student();

        student1.setFirstName("Michał");
        student1.setLastName("Zielinski");

        Student student2 = new Student();

        student2.setFirstName("Bogdan");
        student2.setLastName("Czarny");

        Student student3 = new Student();

        student3.setFirstName("Bożydar");
        student3.setLastName("Filar");

        Student student4 = new Student();

        student4.setFirstName("Amadeusz");
        student4.setLastName("Tyrała");

        System.out.println("\nLet's have an array we can iterate over");

        Student[] studentsArray = new Student[]{student1,student2,student3,student4};

        for (Student student : studentsArray) {
            System.out.println(student);
        }

        System.out.println("\nLet's do the same with list");

        List<Student> studentsList = List.of(student1,student2,student3,student4);

        for (Student student : studentsList) {
            System.out.println(student);
        }

        System.out.println("\nLet's do the same with list the old school way (not recommended)");

        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println(studentsList.get(i));
        }

        System.out.println("\nLet's do the same with list using forEach");

        studentsList.forEach(System.out::println);

        System.out.println("\nLet's use stream on array");

        Arrays.stream(studentsArray).forEach(System.out::println);
    }
}
