/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: GlobalException.java
 */
package com.philips.refapp.exception;

import org.springframework.http.HttpStatus;

/**
 * The Class GlobalException.
 *
 * @author Sushanta Dutta
 */
public class GlobalException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 402901696366014022L;
	
	/** The http status. */
	private HttpStatus httpStatus;

	/**
	 * Instantiates a new global exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param httpStatus the http status
	 */
	public GlobalException(String message, Throwable cause,
			HttpStatus httpStatus) {
		super(message, cause);
		this.httpStatus = httpStatus;
	}

	/**
	 * Gets the http status.
	 *
	 * @return the http status
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
