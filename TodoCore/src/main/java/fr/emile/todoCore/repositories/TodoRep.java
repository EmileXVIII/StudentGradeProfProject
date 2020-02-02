package fr.emile.todoCore.repositories;

import fr.emile.todoCore.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRep extends JpaRepository<Todo, Long> {

}
