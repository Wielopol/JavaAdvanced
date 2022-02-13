package pl.sda.java.adv.school;

import pl.sda.java.adv.school.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                    } else {
                        return 1;
                    }
                }
            } else {
                if (yearResult > 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }));
        System.out.println();

        studentsToSort.forEach(System.out::println);

        studentsToSort = studentsToSort.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int yearResult = o1.getBirthDate().getYear() - o2.getBirthDate().getYear();
                if (yearResult == 0) {
                    int monthResult = o1.getBirthDate().getMonthValue() - o2.getBirthDate().getMonthValue();
                    if (monthResult == 0) {
                        int dayResult = o1.getBirthDate().getDayOfMonth() - o2.getBirthDate().getDayOfMonth();
                        if (dayResult > 0) {
                            return 1;
                        } else if(dayResult < 0) {
                            return -1;
                        } else {
                            return 0;
                        }
                    } else {
                        if (monthResult > 0) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                } else {
                    if (yearResult > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        }).collect(Collectors.toList());

        System.out.println();

        studentsToSort.forEach(System.out::println);

        studentsToSort = studentsToSort.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int cityResult = o1.getAddress().getCity().compareTo(o2.getAddress().getCity());
                if (cityResult == 0) {
                    return o1.getLastName().compareTo(o2.getLastName());
                }
                return cityResult;
            }
        }).collect(Collectors.toList());

        System.out.println();

        studentsToSort.forEach(System.out::println);

        studentsToSort = studentsToSort.stream()
                .filter(w -> w.getSchoolYear() == 8)
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        int lastNameResult = o1.getLastName().compareTo(o2.getLastName());
                        if (lastNameResult == 0) {
                            return o1.getFirstName().compareTo(o2.getFirstName());
                        }
                        return lastNameResult;
                    }
                }).collect(Collectors.toList());

        System.out.println();

        studentsToSort.forEach(System.out::println);


    }
}
