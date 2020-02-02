package fr.emile.todoCore.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoJson{
    private Long id;
    private Long userId;
    private String title;
}
