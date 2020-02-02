package fr.emile.jsonplaceholderUsertodos.clients;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import fr.emile.jsonplaceholderUsertodos.entities.ToDo;
import fr.emile.jsonplaceholderUsertodos.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "TodoClient")
public interface ITodoClient {
    @RequestLine("GET /") //execute l'appel
    List<ToDo> getAll();
    @RequestLine("GET /{id}")
    ToDo getOneById(@Param("id") Long id);
    @RequestLine("POST /")
    @Headers("Content-Type: application/json")
    ToDo create(ToDo todo);
    @RequestLine("DELETE /{id}")
    void drop(@Param("id") Long id);
    @RequestLine("PATCH /{id}")
    @Headers("Content-Type: application/json")
    ToDo update(ToDo todo, @Param("id") Long id);
}
