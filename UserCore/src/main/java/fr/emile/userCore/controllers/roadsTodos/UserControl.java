package fr.emile.userCore.controllers.roadsTodos;

import fr.emile.userCore.entities.User;
import fr.emile.userCore.entities.UserJson;
import fr.emile.userCore.exeptions.NothingToDoException;
import fr.emile.userCore.exeptions.ResourceNotFoundException;
import fr.emile.userCore.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserControl {

    @Autowired
    UserRep usersRep;

    // Get All Notes
    @RequestMapping(
            method = {RequestMethod.GET}
    )
    public List<User> getAllUser() {
        return usersRep.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long todoId) {
        return usersRep.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("todo", "id", todoId));
    }

    // Create a new Note
    @RequestMapping(
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public User createUser(@Valid @RequestBody User user) {
        return usersRep.save(user);
    }


    // Delete a Note
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long todoId) {
        User todo = usersRep.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("todo", "id", todoId));

        usersRep.delete(todo);

        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}")
    public User updateUser(@RequestBody UserJson newUser, @PathVariable(value = "id") Long userId) {
        User user = usersRep.findById(userId)
                .map((t) -> {
                    System.out.println(t.toString());
                    boolean check = false;
                    String newName = (String) newUser.getName();
                    if (newName!= null) {t.setName(newName);check=true;}
                    String newUsername = (String) newUser.getUsername();
                    if (newUsername!= null) {t.setUsername(newUsername);check=true;}
                    String newEmail = (String) newUser.getEmail();
                    if (newEmail!= null) {t.setEmail(newEmail);check=true;}
                    String newPhone = (String) newUser.getPhone();
                    if (newPhone!= null) {t.setPhone(newPhone);check=true;}
                    String newWebsite = (String) newUser.getWebsite();
                    if (newWebsite!= null) {t.setWebsite(newWebsite);check=true;}
                    if(!check) throw new NothingToDoException("Nothing to update");
                    return t;
                })
                .orElseThrow(() -> new NothingToDoException("Nothing to update"));

        return usersRep.save(user);
    }

}
