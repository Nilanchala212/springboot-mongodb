package com.neosoft.mongo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.mongo.entity.Address;
import com.neosoft.mongo.entity.User;
import com.neosoft.mongo.repo.UserRepository;
import com.neosoft.mongo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public String saveUser(User user) {
		Address address = new Address();
		repository.save(user);

		return "user saved successfully....!";
	}

	@Override
	public List<User> fetchAllUserByCityName(String city) {
		return repository.findByCity(city);
	}

	@Override
	public String removeUser(int id) {
		repository.deleteById(id);
		return "user removed successfully";
	}

	@Override
	public Optional<User> fetchUserById(int userId) {
		return repository.findById(userId);
	}

	@Override
	public String updateUser(User user, int userId) {
		User user1 = repository.findById(userId).get();
		user1.setEmail(user.getEmail());
		user1.setFirstName(user.getFirstName());
		user1.setSurName(user.getSurName());
		user1.setDesg(user.getDesg());
		user1.setAge(user.getAge());
		repository.save(user1);
		return "user updated successfully...!";
	}

}
