package fr.emile.userCore.controllers.roadsUsers;

import fr.emile.userCore.entities.Users;
import fr.emile.userCore.exeptions.NothingToDoException;
import fr.emile.userCore.exeptions.ResourceNotFoundException;
import fr.emile.userCore.repositories.UsersRep;
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
    UsersRep usersRep;

    // Get All Notes
    @RequestMapping(
            method = {RequestMethod.GET}
    )
    public List<Users> getAllNotes() {
        return usersRep.findAll();
    }

    @GetMapping("/{id}")
    public Users getNoteById(@PathVariable(value = "id") Long todoId) {
        return usersRep.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Animal", "id", todoId));
    }

    // Create a new Note
    @RequestMapping(
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Users createNote(@Valid @RequestBody Users todo) {
        return usersRep.save(todo);
    }


    // Delete a Note
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(value = "id") Long todoId) {
        Users todo = usersRep.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Animal", "id", todoId));

        usersRep.delete(todo);

        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateTodo(@Valid @RequestBody Users newTodo, @PathVariable(value = "id") Long todoId) {
        Users todo = usersRep.findById(todoId)
                .map((t) -> {
                    String newTitle = newTodo.getTitle();
                    if (newTitle!= null) {t.setTitle(newTitle); return t;}
                    else throw new NothingToDoException("Nothing to update");
                })
                .orElseThrow(() -> new NothingToDoException("Nothing to update"));

        usersRep.save(todo);

        return ResponseEntity.ok().build();
    }

}
