package pl.sda.java.adv.school;

import pl.sda.java.adv.school.model.Address;
import pl.sda.java.adv.school.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CsvStudentsLoader {

    public List<Student> loadStudents(InputStream inputStream) throws IOException {
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        final List<Student> students = new LinkedList<>();

        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            System.out.println("Parsing line " + line);
//            Student student = parseLine(line);
//            if (student != null) {
//                students.add(student);
//            }
            parseLine(line).ifPresent(students::add);
        }

        return Collections.unmodifiableList(students);
    }

    private Optional<Student> parseLine(String line) {
        Student student = new Student();
        String[] cells = line.replaceAll("\"","").split(",");
        if (cells.length != 10) {
            return Optional.empty();
        }
        try {
            student.setId(cells[0]);
            student.setLastName(cells[1]);
            student.setFirstName(cells[2]);
            student.setStartYear(Short.parseShort(cells[3]));
            student.setSchoolYear(Byte.parseByte(cells[4]));
            student.setClassCode(cells[5].charAt(0));
            student.setBirthDate(LocalDate.of(Integer.parseInt(cells[6]),
                    Integer.parseInt(cells[7]),Integer.parseInt(cells[8])));
            Address address = new Address();
            address.setCity(cells[9]);
            student.setAddress(address);

            return Optional.of(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
