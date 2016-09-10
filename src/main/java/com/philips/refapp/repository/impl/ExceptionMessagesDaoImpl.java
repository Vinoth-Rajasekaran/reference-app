/**
 * 
 */
package com.philips.refapp.repository.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.philips.refapp.domain.Exception_Messages;

/**
 * @author Sushanta Dutta
 *
 */
@Repository("exceptionMessagesDaoImpl")
public class ExceptionMessagesDaoImpl extends
		AbstractCRUDRespository<Exception_Messages, Long> {
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Inits the.
	 */
	@PostConstruct
	private void init() {
		super.setEntityManager(entityManager);
	}

}
