package fr.emile.todoCore.controllers.roadsTodos;

import fr.emile.todoCore.entities.Todos;
import fr.emile.todoCore.exeptions.NothingToDoException;
import fr.emile.todoCore.exeptions.ResourceNotFoundException;
import fr.emile.todoCore.repositories.TodosRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class TodosControl {

    @Autowired
    TodosRep todosRep;

    // Get All Notes
    @RequestMapping(
            method = {RequestMethod.GET}
    )
    public List<Todos> getAllNotes() {
        return todosRep.findAll();
    }

    @GetMapping("/{id}")
    public Todos getNoteById(@PathVariable(value = "id") Long todoId) {
        return todosRep.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Animal", "id", todoId));
    }

    // Create a new Note
    @RequestMapping(
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Todos createNote(@Valid @RequestBody Todos todo) {
        return todosRep.save(todo);
    }


    // Delete a Note
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(value = "id") Long todoId) {
        Todos todo = todosRep.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Animal", "id", todoId));

        todosRep.delete(todo);

        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateTodo(@Valid @RequestBody Todos newTodo,@PathVariable(value = "id") Long todoId) {
        Todos todo = todosRep.findById(todoId)
                .map((t) -> {
                    String newTitle = newTodo.getTitle();
                    if (newTitle!= null) {t.setTitle(newTitle); return t;}
                    else throw new NothingToDoException("Nothing to update");
                })
                .orElseThrow(() -> new NothingToDoException("Nothing to update"));

        todosRep.save(todo);

        return ResponseEntity.ok().build();
    }

}
