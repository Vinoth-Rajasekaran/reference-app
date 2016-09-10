/**
 * 
 */
package com.philips.refapp.service;


/**
 * The Interface BaseService.
 *
 * @author Sushanta Dutta
 */
public interface BaseService<T> {

	/**
	 * Do something.
	 *
	 * @param entity the entity
	 * @return the sample entity
	 */
	T doSomething(T entity);

}
