package fr.emile.compositeTeacherGrade.services;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import fr.emile.compositeTeacherGrade.clients.IGradeClient;
import fr.emile.compositeTeacherGrade.clients.ITeacherClient;
import fr.emile.compositeTeacherGrade.entities.Grade;
import fr.emile.compositeTeacherGrade.entities.Teacher;
import fr.emile.compositeTeacherGrade.entities.TeacherGradesDTO;
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
public class GradeTeachersService {
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

    public TeacherGradesDTO getGradesByTeacherId(Long teacherId){

        log.info("Call to the teacher client - getOneById : " + teacherId);
        Teacher teacher;
        try {
            teacher= iTeacherClient.getOneById(teacherId);
        } catch (Exception e) {
            return null;
        }

        log.info("Call to the teachers client - getAll");
        List<Grade> teacherGrades = iGradeClient.getAll().stream()
                .filter(s -> s.getId().equals(teacherId)).collect(Collectors.toList());
        return new TeacherGradesDTO(teacher, teacherGrades);
    }
}
