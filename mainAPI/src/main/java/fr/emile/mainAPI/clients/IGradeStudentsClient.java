package fr.emile.mainAPI.clients;

import feign.Param;
import feign.RequestLine;
import fr.emile.mainAPI.entities.GradeStudentsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "UserTodosClient")
public interface IGradeStudentsClient {
    @RequestLine("GET /{id}") //execute l'appel
    GradeStudentsDTO getGradeStudents(@Param("id") Long id);
}
