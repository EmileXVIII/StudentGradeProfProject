package fr.emile.compositeTeacherGrade.controllers;

import fr.emile.compositeTeacherGrade.entities.GradeTeachersDTO;
import fr.emile.compositeTeacherGrade.services.GradeTeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GradeTeachersController {
    @Autowired
    GradeTeachersService gradeTeachersService;

    @RequestMapping("/gradeTeachers/{gradeId}")
    public ResponseEntity<GradeTeachersDTO> getGradeTeachers(@PathVariable Long gradeId){
        GradeTeachersDTO result = gradeTeachersService.getGradeById(gradeId);
        if (result==null) return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
