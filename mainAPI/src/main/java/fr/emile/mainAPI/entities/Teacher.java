package fr.emile.mainAPI.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher {
    private Long id;
    private String firstname;
    private String lastname;
    private String birthdate;
}
