package com.corssover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.corssover.domain.Application;
import com.corssover.rest.errors.RestApiException;
import com.corssover.service.LoggingService;

@RestController
@RequestMapping("/register")
public class RegisterationController extends BaseController {

	@Autowired
	LoggingService loggingService;

	@RequestMapping(method = RequestMethod.POST,   produces = "application/json" 
			, consumes ="application/json")
	public ResponseEntity<?> register(@RequestBody Application application) throws RestApiException {

		application = loggingService.register(application);

		return new ResponseEntity<Application>(application, HttpStatus.OK);

	}

}
