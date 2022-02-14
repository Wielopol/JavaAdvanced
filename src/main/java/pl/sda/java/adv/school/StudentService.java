package pl.sda.java.adv.school;

import pl.sda.java.adv.school.model.Student;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public Map<String,Student> getStudentIdToStudentMap() {
        final Map<String,Student> studentIdToStudentMap = new HashMap<>();
        for (Student student : students) {
            studentIdToStudentMap.put(student.getId(), student);
        }

        return Collections.unmodifiableMap(studentIdToStudentMap);
    }
}
