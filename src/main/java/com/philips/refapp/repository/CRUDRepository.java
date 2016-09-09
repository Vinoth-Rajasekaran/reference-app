/**
 * 
 */
package com.philips.refapp.repository;

import java.io.Serializable;

import com.philips.refapp.exception.GlobalException;

/**
 * @author Sushanta Dutta
 *
 */
public interface CRUDRepository<T, PK extends Serializable> {

	/**
	 * 
	 * @param t
	 * @return
	 */
	public T create(T t) throws GlobalException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public T read(PK id) throws GlobalException;

	/**
	 * 
	 * @param t
	 * @return
	 */
	public T update(T t) throws GlobalException;

	/**
	 * 
	 * @param t
	 */
	public void delete(T t) throws GlobalException;
}
