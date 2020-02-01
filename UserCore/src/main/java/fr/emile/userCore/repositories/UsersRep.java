package fr.emile.userCore.repositories;

import fr.emile.userCore.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRep extends JpaRepository<Users, Long> {

}
