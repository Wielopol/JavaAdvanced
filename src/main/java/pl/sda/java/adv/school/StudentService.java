package pl.sda.java.adv.school;

import pl.sda.java.adv.school.model.Person;
import pl.sda.java.adv.school.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public Map<String,Student> getStudentIdToStudentMap() {
//        final Map<String,Student> studentIdToStudentMap = new HashMap<>();
//        for (Student student : students) {
//            studentIdToStudentMap.put(student.getId(), student);
//        }
//
//        return Collections.unmodifiableMap(studentIdToStudentMap);

        return students.stream()
                .collect(Collectors.toUnmodifiableMap(
                        Student::getId, // student -> student.getId()
                        student -> student // Function.identity()
                ));
    }

    public Map<String,List<Student>> getCityToStudentsMap() {
//        final Map<String,List<Student>> cityToStudentsMap = new HashMap<>();
//        for (Student student : students) {
//            final String city = student.getAddress().getCity();
//            List<Student> studentsFromCity = cityToStudentsMap.computeIfAbsent(city, c -> new LinkedList<>());
//            studentsFromCity.add(student);
//        }
//
//        return cityToStudentsMap;

        return students.stream()
                .collect(Collectors.groupingBy(student -> student.getAddress().getCity()));
    }
}
