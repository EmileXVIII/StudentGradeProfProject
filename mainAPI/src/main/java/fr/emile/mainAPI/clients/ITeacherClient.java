package fr.emile.mainAPI.clients;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import fr.emile.mainAPI.entities.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "TeacherClient")
public interface ITeacherClient {
    @RequestLine("GET /{id}")
    Teacher getOneById(@Param("id") Long id);
    @RequestLine("GET /")
    List<Teacher> getAll();
    @RequestLine("POST /")
    @Headers("Content-Type: application/json")
    Teacher create(Teacher teacher);
    @RequestLine("DELETE /{id}")
    void drop(@Param("id") Long id);
    @RequestLine("PATCH /{id}")
    @Headers("Content-Type: application/json")
    Teacher update(Teacher teacher, @Param("id") Long id);
}
