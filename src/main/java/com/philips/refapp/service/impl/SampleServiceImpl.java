/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: SampleServiceImpl.java
 */
package com.philips.refapp.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.philips.refapp.domain.SampleEntity;
import com.philips.refapp.repository.CRUDRepository;
import com.philips.refapp.service.BaseService;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleServiceImpl.
 *
 * @author Sushanta Dutta
 */
@Service(value="sampleService")
@Transactional
public class SampleServiceImpl implements BaseService{
	
	/** The crud repository. */
	@Autowired
	@Qualifier(value="sampleEntityRepo")
	private CRUDRepository<SampleEntity, Long> crudRepository;

	/* (non-Javadoc)
	 * @see com.philips.refapp.service.BaseService#doSomething(com.philips.refapp.domain.SampleEntity)
	 */
	@Override
	public SampleEntity doSomething(SampleEntity entity) {
		return crudRepository.create(entity);
	}

}
