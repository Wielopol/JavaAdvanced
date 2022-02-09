package pl.sda.java.adv.school;

import pl.sda.java.adv.school.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainDataClassesOverview {

    public static void main(String[] args) {
        Student student1 = new Student();

        student1.setFirstName("Michal");
        student1.setLastName("Zielinski");

        Student student2 = new Student();

        student2.setFirstName("Bozydar");
        student2.setLastName("Filar");

        Student student3 = new Student();

        student3.setFirstName("Bogdan");
        student3.setLastName("Filar");

        Student student4 = new Student();

        student4.setFirstName("Amadeusz");
        student4.setLastName("Tyrala");

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

        System.out.println("\nLet's sort the list");

        //we need to create the ArrayList because result of List.of(...) is NOT mutable!
        List<Student> studentsArrayList = new ArrayList<>(studentsList);

        Collections.sort(studentsArrayList);

        studentsArrayList.forEach(System.out::println);
    }
}
