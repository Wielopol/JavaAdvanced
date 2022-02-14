package pl.sda.java.adv.school;

import pl.sda.java.adv.school.model.Grade;
import pl.sda.java.adv.school.model.GradeWeight;
import pl.sda.java.adv.school.util.AbstractCsvLoader;

import java.util.Optional;

public class CsvGradesLoader extends AbstractCsvLoader {

    protected Optional<Grade> parseLine(String line) {
        String[] cells = line.replaceAll("\"","").split(",");
        if (cells.length != 4) {
            return Optional.empty();
        }
        try {
            Grade grade = new Grade();
            grade.setStudentId(cells[0]);
            grade.setSubjectCode(cells[1]);
            grade.setGradeWeight(GradeWeight.valueOf(cells[2]));
            grade.setValue(Double.parseDouble(cells[3]));

            return Optional.of(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
