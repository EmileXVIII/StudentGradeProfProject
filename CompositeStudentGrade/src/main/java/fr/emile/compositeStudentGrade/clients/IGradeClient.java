package fr.emile.compositeStudentGrade.clients;

import feign.Param;
import feign.RequestLine;
import fr.emile.compositeStudentGrade.entities.Grade;
import fr.emile.compositeStudentGrade.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "GradeClient")
public interface IGradeClient {
    @RequestLine("GET /{id}") //execute l'appel
    Grade getOneById(@Param("id") Long id);
}
