package com.neosoft.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.neosoft.mongo.entity.User;

public interface UserRepository extends MongoRepository<User, Integer>{

	@Query("{'Address.city':?0}")
	List<User> findByCity(String city);

}
