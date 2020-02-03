package fr.emile.mainAPI.clients;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import fr.emile.mainAPI.entities.Grade;
import fr.emile.mainAPI.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "StudentClient")
public interface IStudentClient {
    @RequestLine("GET /") //execute l'appel
    List<Student> getAll();
    @RequestLine("GET /{id}")
    Student getOneById(@Param("id") Long id);
    @RequestLine("POST /")
    @Headers("Content-Type: application/json")
    Student create(Student student);
    @RequestLine("DELETE /{id}")
    void drop(@Param("id") Long id);
    @RequestLine("PATCH /{id}")
    @Headers("Content-Type: application/json")
    Student update(Student student, @Param("id") Long id);
}
