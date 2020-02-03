package fr.emile.teacherCore.repositories;

import fr.emile.teacherCore.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRep extends JpaRepository<Teacher, Long> {

}
