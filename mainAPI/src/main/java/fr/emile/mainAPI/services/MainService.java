package fr.emile.mainAPI.services;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import fr.emile.mainAPI.clients.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@Slf4j
public class MainService {
    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8081/students")
            ;
    private IGradeClient iGradeClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IGradeClient.class, "http://localhost:8082/grades")
            ;
    private ITeacherClient iTeacherClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(ITeacherClient.class, "http://localhost:8083/teachers")
            ;
    private IGradeStudentsClient iGradeStudentsClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IGradeStudentsClient.class, "http://localhost:8084/gradeStudents")
            ;

    private IGradeTeachersClient iGradeTeachersClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .target(IGradeTeachersClient.class, "http://localhost:8085/teacherGrades")
            ;

    public IStudentClient getiStudentClient() {
        return iStudentClient;
    }

    public IGradeClient getiGradeClient() {
        return iGradeClient;
    }

    public ITeacherClient getiTeacherClient() {
        return iTeacherClient;
    }

    public IGradeStudentsClient getiGradeStudentsClient() {
        return iGradeStudentsClient;
    }

    public IGradeTeachersClient getiGradeTeachersClient() {
        return iGradeTeachersClient;
    }

}
