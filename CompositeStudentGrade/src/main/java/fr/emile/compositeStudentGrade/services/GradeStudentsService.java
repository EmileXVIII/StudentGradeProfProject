package fr.emile.compositeStudentGrade.services;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import fr.emile.compositeStudentGrade.clients.IGradeClient;
import fr.emile.compositeStudentGrade.clients.IStudentClient;
import fr.emile.compositeStudentGrade.entities.Grade;
import fr.emile.compositeStudentGrade.entities.Student;
import fr.emile.compositeStudentGrade.entities.GradeStudentsDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@Slf4j
public class GradeStudentsService {
    private IGradeClient iGradeClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IGradeClient.class, "http://localhost:8082/grades")
            ;
    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8080/students")
            ;

    public GradeStudentsDTO getGradeById(Long gradeId){

        log.info("Call to the grade client - getOneById : " + gradeId);
        Grade grade;
        try {
            grade= iGradeClient.getOneById(gradeId);
        } catch (Exception e) {
            return null;
        }
        log.warn(grade.toString());

        log.info("Call to the students client - getAll");
        List<Student> userGrades = iStudentClient.getAll().stream()
                .filter(s -> s.getGrade().equals(gradeId)).collect(Collectors.toList());
        return new GradeStudentsDTO(grade, userGrades);
    }
}
