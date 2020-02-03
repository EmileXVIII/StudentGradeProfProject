package fr.emile.compositeTeacherGrade.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeacherGradesDTO {

    private Teacher teacher;
    private List<Grade> grades;


    public TeacherGradesDTO(Teacher teacher, List<Grade> teacherGrades) {
        this.teacher = teacher;
        this.grades = teacherGrades;
    }
}
