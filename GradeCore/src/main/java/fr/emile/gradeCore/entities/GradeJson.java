package fr.emile.gradeCore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GradeJson {
    private Long id;
    private String title;
    private String headTeacher;
    private Long year;
}
