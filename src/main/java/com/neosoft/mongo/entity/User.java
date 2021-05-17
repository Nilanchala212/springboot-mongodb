package com.neosoft.mongo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User {
	@Id
	private int userId;
	private String firstName;
	private String surName;
	private int age;
	private String email;
	private String desg;
	private List<Product> products;
	private Address address;


}
