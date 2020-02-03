package fr.emile.compositeTeacherGrade.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grade {
    private Long id;
    private String title;
    private String headTeacher;
    private Long year;
}
