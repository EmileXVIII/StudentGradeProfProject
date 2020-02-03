package fr.emile.mainAPI.clients;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "GradeTeachersClient")
public interface IGradeTeachersClient {
    @RequestLine("GET /{id}") //execute l'appel
    Object getGradeTeachers(@Param("id") Long id);
}
