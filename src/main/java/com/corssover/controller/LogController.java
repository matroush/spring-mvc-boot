package com.corssover.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.corssover.domain.Log;
import com.corssover.rest.dto.LogResponse;
import com.corssover.rest.errors.RestApiException;
import com.corssover.service.LoggingService;

@RestController
@RequestMapping("/log")
public class LogController extends BaseController {

	private final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	
	@Autowired
	LoggingService loggingService;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> log(@RequestBody Log logRequest) throws Exception {

		logger.info("Log request "+logRequest);
		
		LogResponse savedLog = loggingService.log(logRequest);

		return new ResponseEntity<LogResponse>(savedLog, HttpStatus.OK);

	}

}
