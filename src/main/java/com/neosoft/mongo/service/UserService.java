package com.neosoft.mongo.service;

import java.util.List;
import java.util.Optional;

import com.neosoft.mongo.entity.User;

public interface UserService {

	public String saveUser(User user);

	public List<User> fetchAllUserByCityName(String city);
	
	public String removeUser(int id);

	public Optional<User> fetchUserById(int userId);
	
	public String updateUser(User user, int userid);

}
