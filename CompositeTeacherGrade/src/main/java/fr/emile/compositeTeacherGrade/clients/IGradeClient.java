package fr.emile.compositeTeacherGrade.clients;

import feign.Param;
import feign.RequestLine;
import fr.emile.compositeTeacherGrade.entities.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "GradeClient")
public interface IGradeClient {
    @RequestLine("GET") //execute l'appel
    List<Grade> getAll();
}
