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
 * @author Sushanta Dutta
 *
 */
public class GlobalException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 402901696366014022L;
	private HttpStatus httpStatus;

	/**
	 * @param message
	 * @param cause
	 */
	public GlobalException(String message, Throwable cause,
			HttpStatus httpStatus) {
		super(message, cause);
		this.httpStatus = httpStatus;
	}

	/**
	 * 
	 * @return
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
