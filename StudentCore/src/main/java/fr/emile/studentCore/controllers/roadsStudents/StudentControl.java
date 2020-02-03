package fr.emile.studentCore.controllers.roadsStudents;

import fr.emile.studentCore.entities.Student;
import fr.emile.studentCore.entities.StudentJson;
import fr.emile.studentCore.exeptions.NothingToDoException;
import fr.emile.studentCore.exeptions.ResourceNotFoundException;
import fr.emile.studentCore.repositories.StudentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentControl {

    @Autowired
    StudentRep studentsRep;

    // Get All Notes
    @RequestMapping(
            method = {RequestMethod.GET}
    )
    public List<Student> getAllUser() {
        return studentsRep.findAll();
    }

    @GetMapping("/{id}")
    public Student getUserById(@PathVariable(value = "id") Long studentId) {
        return studentsRep.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("student", "id", studentId));
    }

    // Create a new Note
    @RequestMapping(
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Student createUser(@Valid @RequestBody Student student) {
        return studentsRep.save(student);
    }


    // Delete a Note
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId) {
        Student student = studentsRep.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("student", "id", studentId));

        studentsRep.delete(student);

        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}")
    public Student updateStudent(@RequestBody StudentJson newStudent, @PathVariable(value = "id") Long studentId) {
        Student student = studentsRep.findById(studentId)
                .map((t) -> {
                    System.out.println(t.toString());
                    boolean check = false;
                    Long newGrade = (Long) newStudent.getGrade();
                    if (newGrade!= null) {t.setGrade(newGrade);check=true;}
                    String newFirstname = (String) newStudent.getFirstname();
                    if (newFirstname!= null) {t.setFirstname(newFirstname);check=true;}
                    String newLastname = (String) newStudent.getLastname();
                    if (newLastname!= null) {t.setLastname(newLastname);check=true;}
                    String newBirthdate = (String) newStudent.getBirthdate();
                    if (newBirthdate!= null) {t.setBirthdate(newBirthdate);check=true;}
                    if(!check) throw new NothingToDoException("Nothing to update");
                    return t;
                })
                .orElseThrow(() -> new NothingToDoException("Nothing to update"));

        return studentsRep.save(student);
    }

}
