package pl.sda.java.adv.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sda.java.adv.school.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StudentServiceTest {
    private StudentService studentService;

    @BeforeEach
    void setUp() throws IOException {
        final CsvStudentsLoader csvStudentsLoader = new CsvStudentsLoader();
        final List<Student> students;

        try (final InputStream inputStream = StudentServiceTest.class.getResourceAsStream("/students.csv")) {
            students = csvStudentsLoader.loadData(inputStream);
        }

        studentService = new StudentService(students);
    }

    @Test
    void testGetStudentIdToStudentMap() {
        //WHEN
        final Map<String, Student> map = studentService.getStudentIdToStudentMap();

        //THEN
        Student student1 = map.get("00001001");
        assertThat(student1).isNotNull();
        assertThat(student1.getLastName()).isEqualTo("Kowalski");
    }

    @Test
    void testGetCityToStudentsMap() {
        //WHEN
        final Map<String,List<Student>> map = studentService.getCityToStudentsMap();

        //THEN
        assertThat(map.get("Krzeszowice"))
                .hasSize(2)
                .extracting(Student::getId)
                .containsExactlyInAnyOrder("00001003","00001007");
    }
}