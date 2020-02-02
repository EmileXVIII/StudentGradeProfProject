package fr.emile.jsonplaceholderUsertodos.controllers;

import fr.emile.jsonplaceholderUsertodos.clients.IUserTodosClient;
import fr.emile.jsonplaceholderUsertodos.entities.ToDo;
import fr.emile.jsonplaceholderUsertodos.entities.User;
import fr.emile.jsonplaceholderUsertodos.entities.UserTodosDTO;
import fr.emile.jsonplaceholderUsertodos.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/userTodos/{userId}")
    ResponseEntity<UserTodosDTO> getUserTodos(@PathVariable Long userId){
        return new ResponseEntity<>(mainService.getiUserTodosClient().getUserTodos(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<User> getUser(@PathVariable Long id){
        return new ResponseEntity<>(mainService.getiUserClient().getOneById(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(mainService.getiUserClient().getAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/users",
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(mainService.getiUserClient().create(user), HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public void dropUser(@PathVariable Long id){
        mainService.getiUserClient().drop(id);
    }

    @RequestMapping(
            value = "/users/{id}",
            method = {RequestMethod.PATCH },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(mainService.getiUserClient().update(user,id), HttpStatus.OK);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<ToDo> getToDo(@PathVariable Long id ){
        return new ResponseEntity<>(mainService.getiTodoClient().getOneById(id), HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> getToDos(){
        return new ResponseEntity<>(mainService.getiTodoClient().getAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/todos",
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo){
        return new ResponseEntity<>(mainService.getiTodoClient().create(toDo), HttpStatus.OK);
    }
    @DeleteMapping("/todos/{id}")
    public void dropToDos(@PathVariable Long id){
        mainService.getiTodoClient().drop(id);
    }

    @RequestMapping(
            value = "/todos/{id}",
            method = {RequestMethod.PATCH },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<ToDo> updateToDo(@RequestBody ToDo toDo,@PathVariable Long id){
        return new ResponseEntity<>(mainService.getiTodoClient().update(toDo,id), HttpStatus.OK);
    }
}
