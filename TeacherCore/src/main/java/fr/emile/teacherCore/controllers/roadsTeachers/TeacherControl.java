package fr.emile.teacherCore.controllers.roadsTeachers;

import fr.emile.teacherCore.entities.Teacher;
import fr.emile.teacherCore.entities.TeacherJson;
import fr.emile.teacherCore.exeptions.NothingToDoException;
import fr.emile.teacherCore.exeptions.ResourceNotFoundException;
import fr.emile.teacherCore.repositories.TeacherRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/teachers")
public class TeacherControl {

    @Autowired
    TeacherRep teachersRep;

    // Get All Notes
    @RequestMapping(
            method = {RequestMethod.GET}
    )
    public List<Teacher> getAllUser() {
        return teachersRep.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getUserById(@PathVariable(value = "id") Long teacherId) {
        return teachersRep.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("teacher", "id", teacherId));
    }

    // Create a new Note
    @RequestMapping(
            method = {RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Teacher createUser(@Valid @RequestBody Teacher teacher) {
        return teachersRep.save(teacher);
    }


    // Delete a Note
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable(value = "id") Long teacherId) {
        Teacher teacher = teachersRep.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("teacher", "id", teacherId));

        teachersRep.delete(teacher);

        return ResponseEntity.ok().build();
    }
    @PatchMapping("/{id}")
    public Teacher updateTeacher(@RequestBody TeacherJson newTeacher, @PathVariable(value = "id") Long teacherId) {
        Teacher teacher = teachersRep.findById(teacherId)
                .map((t) -> {
                    System.out.println(t.toString());
                    boolean check = false;
                    String newFirstname = (String) newTeacher.getFirstname();
                    if (newFirstname!= null) {t.setFirstname(newFirstname);check=true;}
                    String newLastname = (String) newTeacher.getLastname();
                    if (newLastname!= null) {t.setLastname(newLastname);check=true;}
                    String newBirthdate = (String) newTeacher.getBirthdate();
                    if (newBirthdate!= null) {t.setBirthdate(newBirthdate);check=true;}
                    if(!check) throw new NothingToDoException("Nothing to update");
                    return t;
                })
                .orElseThrow(() -> new NothingToDoException("Nothing to update"));

        return teachersRep.save(teacher);
    }

}
