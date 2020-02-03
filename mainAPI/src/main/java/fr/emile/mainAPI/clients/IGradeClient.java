package fr.emile.mainAPI.clients;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import fr.emile.mainAPI.entities.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@FeignClient(name = "UserClient")
public interface IGradeClient {
    @RequestLine("GET /{id}")
    Grade getOneById(@Param("id") Long id);
    @RequestLine("GET /")
    List<Grade> getAll();
    @RequestLine("POST /")
    @Headers("Content-Type: application/json")
    Grade create(Grade grade);
    @RequestLine("DELETE /{id}")
    void drop(@Param("id") Long id);
    @RequestLine("PATCH /{id}")
    @Headers("Content-Type: application/json")
    Grade update(Grade grade, @Param("id") Long id);
}
