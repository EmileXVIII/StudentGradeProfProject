package fr.emile.mainAPI.clients;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "UserTodosClient")
public interface IGradeStudentsClient {
    @RequestLine("GET /{id}") //execute l'appel
    Object getGradeStudents(@Param("id") Long id);
}
