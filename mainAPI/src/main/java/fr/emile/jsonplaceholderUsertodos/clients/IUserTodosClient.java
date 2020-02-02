package fr.emile.jsonplaceholderUsertodos.clients;

import feign.Param;
import feign.RequestLine;
import fr.emile.jsonplaceholderUsertodos.entities.ToDo;
import fr.emile.jsonplaceholderUsertodos.entities.User;
import fr.emile.jsonplaceholderUsertodos.entities.UserTodosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "UserTodosClient")
public interface IUserTodosClient {
    @RequestLine("GET /{id}") //execute l'appel
    UserTodosDTO getUserTodos(@Param("id") Long id);
}
