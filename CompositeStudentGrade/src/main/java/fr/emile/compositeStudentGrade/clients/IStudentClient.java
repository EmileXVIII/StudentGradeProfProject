package fr.emile.compositeStudentGrade.clients;

import feign.Param;
import feign.RequestLine;
import fr.emile.compositeStudentGrade.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "StudentClient")
public interface IStudentClient {
    @RequestLine("GET /{id}")
    Student getOneById(@Param("id") Long id);
}
