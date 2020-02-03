package fr.emile.compositeStudentGrade.controllers;

import fr.emile.compositeStudentGrade.entities.StudentGradesDTO;
import fr.emile.compositeStudentGrade.services.StudentGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentGradesController {
    @Autowired
    StudentGradesService studentGradesService;

    @RequestMapping("/userTodos/{userId}")
    ResponseEntity<StudentGradesDTO> getUserTodos(@PathVariable Long userId){
        return new ResponseEntity<>(studentGradesService.getStudentById(userId), HttpStatus.OK);
    }
}
