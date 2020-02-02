package fr.emile.jsonplaceholderUsertodos.clients;

import feign.RequestLine;
import fr.emile.jsonplaceholderUsertodos.entities.ToDo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "TodoClient")
public interface ITodoClient {
    @RequestLine("GET /") //execute l'appel
    List<ToDo> getAll();
}
