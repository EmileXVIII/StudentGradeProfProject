package fr.emile.compositeStudentGrade.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grade {
    private Long id;
    private String title;
    private String teacherId;
    private Long year;
}
