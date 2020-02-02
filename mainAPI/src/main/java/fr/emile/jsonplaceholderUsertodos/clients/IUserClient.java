package fr.emile.jsonplaceholderUsertodos.clients;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import fr.emile.jsonplaceholderUsertodos.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "UserClient")
public interface IUserClient {
    @RequestLine("GET /{id}")
    User getOneById(@Param("id") Long id);
    @RequestLine("GET /")
    List<User> getAll();
    @RequestLine("POST /")
    @Headers("Content-Type: application/json")
    User create(User user);
    @RequestLine("DELETE /{id}")
    void drop(@Param("id") Long id);
    @RequestLine("PATCH /{id}")
    @Headers("Content-Type: application/json")
    User update(User user, @Param("id") Long id);
}
