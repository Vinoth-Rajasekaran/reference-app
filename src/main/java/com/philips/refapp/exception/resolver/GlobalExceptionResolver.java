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

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.philips.refapp.annotation.ExceptionMsg;
import com.philips.refapp.annotation.ExceptionMsgAware;
import com.philips.refapp.exception.GlobalException;

/**
 * The Class GlobalExceptionResolver.
 *
 * @author Sushanta Dutta
 */
@ControllerAdvice(annotations = RestController.class, basePackages = { "com.philips.refapp.web" })
@ExceptionMsgAware
public class GlobalExceptionResolver {

	private static final Logger LOG = LoggerFactory
			.getLogger(GlobalExceptionResolver.class);
	@ExceptionMsg
	private Map<String, String> errorCodeMsg;

	/**
	 * Exception.
	 *
	 * @param exception
	 *            the exception
	 * @param request
	 *            the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> exception(Exception exception, WebRequest request) {
		LOG.debug("Cause of Exception " + exception.getMessage());
		return new ResponseEntity<String>(errorCodeMsg.get(exception
				.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Exception 1.
	 *
	 * @param exception
	 *            the exception
	 * @param request
	 *            the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = GlobalException.class)
	public ResponseEntity<Map<String, String>> globalExceptionResolver(
			Exception exception, WebRequest request) {
		LOG.debug("Cause of Exception " + exception.getMessage());
		ResponseEntity<Map<String, String>> responseEntity = null;
		GlobalException globalException = null;
		if (exception instanceof GlobalException) {
			globalException = (GlobalException) exception;
			// 403
			if (HttpStatus.FORBIDDEN.equals(globalException.getHttpStatus())) {
				Map<String, String> body = new HashMap<String, String>();
				body.put(globalException.getHttpStatus().toString(),
						errorCodeMsg.get(globalException.getHttpStatus()));
				responseEntity = new ResponseEntity<Map<String, String>>(body,
						globalException.getHttpStatus());
			}
			// 422
			else if (HttpStatus.UNPROCESSABLE_ENTITY.equals(globalException
					.getHttpStatus())) {
				Map<String, String> body = new HashMap<String, String>();
				body.put(globalException.getHttpStatus().toString(),
						errorCodeMsg.get(Integer.toString(globalException.getHttpStatus().value())));
				responseEntity = new ResponseEntity<Map<String, String>>(body,
						globalException.getHttpStatus());
			}
		}

		return responseEntity;
	}
}
