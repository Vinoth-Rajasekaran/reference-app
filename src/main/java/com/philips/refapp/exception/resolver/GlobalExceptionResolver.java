/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: GlobalExceptionResolver.java
 */
package com.philips.refapp.exception.resolver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.philips.refapp.exception.GlobalException;

// TODO: Auto-generated Javadoc
/**
 * The Class GlobalExceptionResolver.
 *
 * @author Sushanta Dutta
 */
@ControllerAdvice(annotations = RestController.class, basePackages = { "com.philips.refapp.web" })
public class GlobalExceptionResolver {

	/**
	 * Exception.
	 *
	 * @param exception the exception
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> exception(Exception exception, WebRequest request) {
		return new ResponseEntity<String>(new String(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Exception 1.
	 *
	 * @param exception the exception
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = GlobalException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> exception1(Exception exception, WebRequest request) {
		return new ResponseEntity<String>(new String(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
