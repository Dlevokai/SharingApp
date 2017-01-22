package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.domain.Player;
 
public interface PlayerRepository extends CrudRepository<Player, Integer>{
}
