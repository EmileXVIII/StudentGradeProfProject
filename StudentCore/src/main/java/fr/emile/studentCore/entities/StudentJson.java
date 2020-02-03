package fr.emile.studentCore.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentJson {
    private Long id;
    private Long grade;
    private String firstname;
    private String lastname;
    private String birthdate;
}
