package fr.emile.compositeStudentGrade.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GradeStudentsDTO {

    private Grade grade;
    private List<Student> students;

    public GradeStudentsDTO(Grade grade, List<Student> gradeStudents) {
        this.students = gradeStudents;
        this.grade = grade;
    }
}
