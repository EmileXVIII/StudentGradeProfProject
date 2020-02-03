package fr.emile.compositeStudentGrade.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentGradesDTO {

    private Student student;
    private List<Grade> grades;

    public StudentGradesDTO(Student student, List<Grade> userGrades) {
        this.student = student;
        this.grades = userGrades;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
