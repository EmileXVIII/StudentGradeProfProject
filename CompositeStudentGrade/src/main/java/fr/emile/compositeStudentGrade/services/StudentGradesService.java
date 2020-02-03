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
import fr.emile.compositeStudentGrade.entities.StudentGradesDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@Slf4j
public class StudentGradesService {
    private IGradeClient iGradeClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IGradeClient.class, "http://localhost:8080/grades")
            ;
    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8081/students")
            ;

    public StudentGradesDTO getStudentById(Long studentId){

        log.info("Call to the student client - getOneById : " + studentId);
        Student student = iStudentClient.getOneById(studentId);

        log.info("Call to the grades client - getAll");
        List<Grade> userGrades = iGradeClient.getAll().stream()
                .filter(s -> s.getId().equals(studentId)).collect(Collectors.toList());
        return new StudentGradesDTO(student, userGrades);
    }
}
