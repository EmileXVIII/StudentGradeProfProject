package fr.emile.gradeCore.repositories;

import fr.emile.gradeCore.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRep extends JpaRepository<Grade, Long> {

}
