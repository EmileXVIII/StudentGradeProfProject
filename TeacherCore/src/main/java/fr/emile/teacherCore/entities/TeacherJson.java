package fr.emile.teacherCore.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherJson {
    private Long id;
    private String firstname;
    private String lastname;
    private String birthdate;
}
