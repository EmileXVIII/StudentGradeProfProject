package fr.emile.jsonplaceholderUsertodos.controllers;

import fr.emile.jsonplaceholderUsertodos.entities.UserTodosDTO;
import fr.emile.jsonplaceholderUsertodos.services.UserToDosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserToDoController {
    @Autowired
    UserToDosService userToDosService;

    @RequestMapping("/userTodos/{userId}")
    ResponseEntity<UserTodosDTO> getUserTodos(@PathVariable Long userId){
        return new ResponseEntity<>(userToDosService.getUserById(userId), HttpStatus.OK);
    }
}
