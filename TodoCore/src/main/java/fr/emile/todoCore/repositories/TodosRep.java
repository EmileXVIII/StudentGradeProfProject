package fr.emile.todoCore.repositories;

import fr.emile.todoCore.entities.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosRep extends JpaRepository<Todos, Long> {

}
