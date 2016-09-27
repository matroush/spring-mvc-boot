package com.corssover.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.corssover.rest.errors.RestApiError;
import com.corssover.rest.errors.RestApiException;

public class BaseController {

	 @ExceptionHandler(RuntimeException.class)
	 @ResponseBody
	 public RestApiError handleException(RuntimeException e, HttpServletRequest request, HttpServletResponse response) {
	 
		 
		 response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		 e.printStackTrace();
		 return new RestApiError(""+HttpStatus.INTERNAL_SERVER_ERROR.value() , e.getMessage());
	 }

	 @ExceptionHandler(RestApiException.class)
	 @ResponseBody
	 public RestApiError handleException(RestApiException e, HttpServletRequest request, HttpServletResponse response) {
		 
		 
		 response.setStatus(Integer.parseInt(e.getCode()));
		 
		 return new RestApiError(e.getCode() , e.getMessage());
	 }
}
