package fr.emile.todoCore.controllers.roadsTodos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.emile.todoCore.entities.Todo;
import fr.emile.todoCore.entities.TodoJson;
import fr.emile.todoCore.exeptions.NothingToDoException;
import fr.emile.todoCore.exeptions.ResourceNotFoundException;
import fr.emile.todoCore.repositories.TodoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/todos")
public class TodoControl {

    @Autowired
    TodoRep todosRep;

    // Get All Notes
    @RequestMapping(
            method = {RequestMethod.GET}
    )
    public List<Todo> getAllUser() {
        return todosRep.findAll();
    }

    @GetMapping("/{id}")
    public Todo getUserById(@PathVariable(value = "id") Long todoId) {
        return todosRep.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("todo", "id", todoId));
    }

    // Create a new Note
    @RequestMapping(
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Todo createUser(@Valid @RequestBody Todo todo) {
        return todosRep.save(todo);
    }


    // Delete a Note
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(value = "id") Long todoId) {
        Todo todo = todosRep.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("todo", "id", todoId));

        todosRep.delete(todo);

        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}")
    public Todo updateTodo(@RequestBody TodoJson newTodo, @PathVariable(value = "id") Long todoId) {
        Todo todo = todosRep.findById(todoId)
                .map((t) -> {
                    System.out.println(t.toString());
                    boolean check = false;
                    String newTitle = (String) newTodo.getTitle();
                    if (newTitle!= null) {t.setTitle(newTitle);check=true;}
                    Long newUserId = (Long) newTodo.getUserId();
                    if (newUserId!= null) {t.setUserId(newUserId);check=true;}
                    if(!check) throw new NothingToDoException("Nothing to update");
                    return t;
                })
                .orElseThrow(() -> new NothingToDoException("Nothing to update"));

        return todosRep.save(todo);
    }

}
