package fr.emile.compositeStudentGrade.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private Long id;
    private Long grade;
    private String firstname;
    private String lastname;
    private String birthdate;
}
