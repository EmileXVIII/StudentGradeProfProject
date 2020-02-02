package fr.emile.jsonplaceholderUsertodos.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDo {
    private Long id;
    private Long userId;
    private String title;
    private boolean completed;
}
