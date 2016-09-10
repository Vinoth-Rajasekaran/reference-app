/**
 * 
 */
package com.philips.refapp.repository.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.philips.refapp.domain.SampleEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleEntityDaoImpl.
 *
 * @author Sushanta Dutta
 */

@Repository(value="sampleEntityRepo")
public class SampleEntityDaoImpl extends
		AbstractCRUDRespository<SampleEntity, Long> {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	private void init(){
		super.setEntityManager(entityManager);
	}
}
