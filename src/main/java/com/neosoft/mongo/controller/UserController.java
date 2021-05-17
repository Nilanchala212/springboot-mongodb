package com.neosoft.mongo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.mongo.entity.User;
import com.neosoft.mongo.exception.CityNotBeNull;
import com.neosoft.mongo.exception.InvalidId;
import com.neosoft.mongo.repo.UserRepository;
import com.neosoft.mongo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserRepository repo;

	@Autowired
	private UserService service;

	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		String msg = service.saveUser(user);
		return msg;
	}

	@GetMapping("/fetchByCityname/{city}")
	public List<User> fetchAllUserByCityName(@PathVariable String city) {
		if (city == null || city.isEmpty()) {
			throw new CityNotBeNull("city should not be null");

		} else {

			return service.fetchAllUserByCityName(city);

		}
	}

	@DeleteMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {

		String message = service.removeUser(id);
		return message;

	}

	@GetMapping("/fetch/{id}")
	public Optional<User> fetchUserById(@PathVariable("id") int id) {
		if (id == 0) {
			throw new InvalidId("Id should not be null");
		}
		return service.fetchUserById(id);

	}

	@PutMapping("/users/{id}")
	public String updateUser(@RequestBody User user, @PathVariable("id") int userid) {
		if (userid == 0) {
			throw new InvalidId("id should not be null");
		} else {
			String message = service.updateUser(user, userid);
			return message;
		}
	}

}
