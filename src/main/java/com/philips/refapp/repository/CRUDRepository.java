/**
 * 
 */
package com.philips.refapp.repository;

import java.io.Serializable;
import java.util.List;

import com.philips.refapp.exception.GlobalException;

/**
 * The Interface CRUDRepository.
 *
 * @author Sushanta Dutta
 * @param <T> the generic type
 * @param <PK> the generic type
 */
public interface CRUDRepository<T, PK extends Serializable> {

	/**
	 * Creates the.
	 *
	 * @param t the t
	 * @return the t
	 * @throws GlobalException the global exception
	 */
	public T create(T t) throws GlobalException;

	/**
	 * Read.
	 *
	 * @param id the id
	 * @return the t
	 * @throws GlobalException the global exception
	 */
	public T read(PK id) throws GlobalException;

	/**
	 * Update.
	 *
	 * @param t the t
	 * @return the t
	 * @throws GlobalException the global exception
	 */
	public T update(T t) throws GlobalException;

	/**
	 * Delete.
	 *
	 * @param t the t
	 * @throws GlobalException the global exception
	 */
	public void delete(T t) throws GlobalException;
	
	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws GlobalException the global exception
	 */
	public List<T> findAll() throws GlobalException;
}
