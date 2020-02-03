package fr.emile.compositeTeacherGrade.clients;

import feign.Param;
import feign.RequestLine;
import fr.emile.compositeTeacherGrade.entities.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name = "TeacherClient")
public interface ITeacherClient {
    @RequestLine("GET /{id}")
    Teacher getOneById(@Param("id") Long id);
}
