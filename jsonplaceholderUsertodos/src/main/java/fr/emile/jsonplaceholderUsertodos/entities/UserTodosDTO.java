package fr.emile.jsonplaceholderUsertodos.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserTodosDTO {

    private User user;
    private List<ToDo> toDos;

    public UserTodosDTO(User user, List<ToDo> userToDos) {
        this.user=user;
        this.toDos=userToDos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }
}
