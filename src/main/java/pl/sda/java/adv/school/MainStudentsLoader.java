package pl.sda.java.adv.school;

import pl.sda.java.adv.school.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainStudentsLoader {
    public static void main(String[] args) {
        CsvStudentsLoader csvStudentsLoader = new CsvStudentsLoader();
        List<Student> students;

        try (InputStream inputStream = Files.newInputStream(Path.of("students.csv"))) {
            students = csvStudentsLoader.loadData(inputStream);
        } catch (IOException e) {
            students = Collections.emptyList();
            e.printStackTrace();
        }

        students.forEach(System.out::println);

        List<Student> studentsToSort = new LinkedList<>(students);

        Collections.sort(studentsToSort,((o1, o2) -> {
            int yearResult = o1.getBirthDate().getYear() - o2.getBirthDate().getYear();
            if (yearResult == 0) {
                int monthResult = o1.getBirthDate().getMonthValue() - o2.getBirthDate().getMonthValue();
                if (monthResult == 0) {
                    int dayResult = o1.getBirthDate().getDayOfMonth() - o2.getBirthDate().getDayOfMonth();
                    if (dayResult > 0) {
                        return -1;
                    } else if(dayResult < 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    if (monthResult > 0) {
                        return -1;
                    } else if(monthResult < 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            } else {
                if (yearResult > 0) {
                    return -1;
                } else if(yearResult < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }));
        System.out.println();

        studentsToSort.forEach(System.out::println);
    }
}
