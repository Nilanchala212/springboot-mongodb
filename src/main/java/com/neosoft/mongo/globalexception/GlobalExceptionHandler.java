package com.neosoft.mongo.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.neosoft.mongo.exception.CityNotBeNull;
import com.neosoft.mongo.exception.InvalidId;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<?> invalididHandling(InvalidId invalidId, WebRequest request) {

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CityNotBeNull.class)
	public ResponseEntity<?> invalidCityNameHandling(InvalidId invalidId, WebRequest request) {

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
