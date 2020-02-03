package fr.emile.compositeTeacherGrade.clients;

import feign.Param;
import feign.RequestLine;
import fr.emile.compositeTeacherGrade.entities.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "GradeClient")
public interface IGradeClient {
    @RequestLine("GET /{id}") //execute l'appel
    Grade getOneById(@Param("id") Long id);
}
