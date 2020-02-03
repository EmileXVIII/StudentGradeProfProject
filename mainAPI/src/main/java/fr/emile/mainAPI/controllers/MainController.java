package fr.emile.mainAPI.controllers;

import fr.emile.mainAPI.entities.Grade;
import fr.emile.mainAPI.entities.Student;
import fr.emile.mainAPI.entities.Teacher;
import fr.emile.mainAPI.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/gradeStudents/{userId}")
    public ResponseEntity<Object> getGradeStudents(@PathVariable Long userId){
        return new ResponseEntity<>(mainService.getiGradeStudentsClient().getGradeStudents(userId), HttpStatus.OK);
    }
//grades
    @GetMapping("/grades/{id}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long id){
        return new ResponseEntity<>(mainService.getiGradeClient().getOneById(id), HttpStatus.OK);
    }

    @GetMapping("/grades")
    public ResponseEntity<List<Grade>> getGrades(){
        return new ResponseEntity<>(mainService.getiGradeClient().getAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/grades",
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Grade> createUser(@RequestBody Grade grade){
        return new ResponseEntity<>(mainService.getiGradeClient().create(grade), HttpStatus.OK);
    }
    @DeleteMapping("/grades/{id}")
    public void dropUser(@PathVariable Long id){
        mainService.getiGradeClient().drop(id);
    }

    @RequestMapping(
            value = "/grades/{id}",
            method = {RequestMethod.PATCH },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Grade> updateUser(@RequestBody Grade grade, @PathVariable Long id){
        return new ResponseEntity<>(mainService.getiGradeClient().update(grade,id), HttpStatus.OK);
    }

    //students
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id ){
        return new ResponseEntity<>(mainService.getiStudentClient().getOneById(id), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(mainService.getiStudentClient().getAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/students",
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(mainService.getiStudentClient().create(student), HttpStatus.OK);
    }
    @DeleteMapping("/students/{id}")
    public void dropStudents(@PathVariable Long id){
        mainService.getiStudentClient().drop(id);
    }

    @RequestMapping(
            value = "/students/{id}",
            method = {RequestMethod.PATCH },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id){
        return new ResponseEntity<>(mainService.getiStudentClient().update(student,id), HttpStatus.OK);
    }
    //teachers
    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id ){
        return new ResponseEntity<>(mainService.getiTeacherClient().getOneById(id), HttpStatus.OK);
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getTeachers(){
        return new ResponseEntity<>(mainService.getiTeacherClient().getAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/teachers",
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(mainService.getiTeacherClient().create(teacher), HttpStatus.OK);
    }
    @DeleteMapping("/teachers/{id}")
    public void dropTeacherss(@PathVariable Long id){
        mainService.getiTeacherClient().drop(id);
    }

    @RequestMapping(
            value = "/teachers/{id}",
            method = {RequestMethod.PATCH },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher, @PathVariable Long id){
        return new ResponseEntity<>(mainService.getiTeacherClient().update(teacher,id), HttpStatus.OK);
    }
}
