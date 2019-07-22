package com.johnfu.dojoplay.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.johnfu.dojoplay.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
