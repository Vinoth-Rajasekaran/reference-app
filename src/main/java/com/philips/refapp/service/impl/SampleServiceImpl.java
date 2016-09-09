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

import com.philips.refapp.repository.impl.SampleDaoImpl;

/**
 * @author Sushanta Dutta
 *
 */
@Service(value="sampleService")
@Transactional
public class SampleServiceImpl {
	
	@Autowired
	@Qualifier(value="sampleDao")
	private SampleDaoImpl daoImpl;

}
