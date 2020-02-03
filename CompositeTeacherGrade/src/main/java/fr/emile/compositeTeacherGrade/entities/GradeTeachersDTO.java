package fr.emile.compositeTeacherGrade.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GradeTeachersDTO {

    private Grade grade;
    private List<Teacher> teachers;

    public GradeTeachersDTO(Grade grade, List<Teacher> gradeTeachers) {
        this.teachers = gradeTeachers;
        this.grade = grade;
    }
}
