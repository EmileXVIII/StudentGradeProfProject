package fr.emile.compositeStudentGrade.controllers;

import fr.emile.compositeStudentGrade.entities.GradeStudentsDTO;
import fr.emile.compositeStudentGrade.services.GradeStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GradeStudentsController {
    @Autowired
    GradeStudentsService gradeStudentsService;

    @RequestMapping("/gradeStudents/{gradeId}")
    public ResponseEntity<GradeStudentsDTO> getGradeStudents(@PathVariable Long gradeId){
        GradeStudentsDTO result = gradeStudentsService.getGradeById(gradeId);
        if (result==null) return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
