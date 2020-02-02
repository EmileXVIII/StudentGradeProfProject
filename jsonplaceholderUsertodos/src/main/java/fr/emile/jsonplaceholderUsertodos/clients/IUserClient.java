package fr.emile.jsonplaceholderUsertodos.clients;

import feign.Param;
import feign.RequestLine;
import fr.emile.jsonplaceholderUsertodos.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "UserClient")
public interface IUserClient {
    @RequestLine("GET /{id}")
    User getOneById(@Param("id") Long id);
}
