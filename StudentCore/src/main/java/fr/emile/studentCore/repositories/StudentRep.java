package fr.emile.studentCore.repositories;

import fr.emile.studentCore.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends JpaRepository<Student, Long> {

}
