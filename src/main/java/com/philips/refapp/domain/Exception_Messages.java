/**
 * 
 */
package com.philips.refapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Sushanta Dutta
 *
 */
@Entity
public class Exception_Messages extends AbstractEntity{
	
	@Column
	private String code;
	@Column
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
