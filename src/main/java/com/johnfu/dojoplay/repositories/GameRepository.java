package com.johnfu.dojoplay.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.johnfu.dojoplay.models.Game;
import com.johnfu.dojoplay.models.User;
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	List<Game> findAll();
}
