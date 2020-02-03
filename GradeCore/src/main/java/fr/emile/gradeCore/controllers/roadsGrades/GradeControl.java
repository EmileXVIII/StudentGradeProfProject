package fr.emile.gradeCore.controllers.roadsGrades;

import fr.emile.gradeCore.entities.Grade;
import fr.emile.gradeCore.entities.GradeJson;
import fr.emile.gradeCore.exeptions.NothingToDoException;
import fr.emile.gradeCore.exeptions.ResourceNotFoundException;
import fr.emile.gradeCore.repositories.GradeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/grades")
public class GradeControl {

    @Autowired
    GradeRep gradesRep;

    // Get All Notes
    @RequestMapping(
            method = {RequestMethod.GET}
    )
    public List<Grade> getAllUser() {
        return gradesRep.findAll();
    }

    @GetMapping("/{id}")
    public Grade getUserById(@PathVariable(value = "id") Long gradeId) {
        return gradesRep.findById(gradeId)
                .orElseThrow(() -> new ResourceNotFoundException("grade", "id", gradeId));
    }

    // Create a new Note
    @RequestMapping(
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Grade createUser(@Valid @RequestBody Grade grade) {
        return gradesRep.save(grade);
    }


    // Delete a Note
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGrade(@PathVariable(value = "id") Long gradeId) {
        Grade grade = gradesRep.findById(gradeId)
                .orElseThrow(() -> new ResourceNotFoundException("grade", "id", gradeId));

        gradesRep.delete(grade);

        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}")
    public Grade updateGrade(@RequestBody GradeJson newGrade, @PathVariable(value = "id") Long gradeId) {
        Grade grade = gradesRep.findById(gradeId)
                .map((t) -> {
                    System.out.println(t.toString());
                    boolean check = false;
                    String newTitle = (String) newGrade.getTitle();
                    if (newTitle!= null) {t.setTitle(newTitle);check=true;}
                    Long teacherId = (Long) newGrade.getTeacherId();
                    if (teacherId!= null) {t.setTeacherId(teacherId);check=true;}
                    Long newYear = (Long) newGrade.getYear();
                    if (newYear!= null) {t.setYear(newYear);check=true;}
                    if(!check) throw new NothingToDoException("Nothing to update");
                    return t;
                })
                .orElseThrow(() -> new NothingToDoException("Nothing to update"));

        return gradesRep.save(grade);
    }

}
