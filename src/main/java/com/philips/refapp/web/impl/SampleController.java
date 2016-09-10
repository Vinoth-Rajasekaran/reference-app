/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: SampleController.java
 */

package com.philips.refapp.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.philips.refapp.domain.SampleEntity;
import com.philips.refapp.service.BaseService;
import com.philips.refapp.web.AbstractController;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleController.
 *
 * @author Sushanta Dutta
 */

@RestController
public class SampleController extends AbstractController {

	/** The sample service. */
	@Autowired
	@Qualifier(value = "sampleService")
	private BaseService sampleService;

	/**
	 * View json.
	 *
	 * @return the response entity
	 */
	@RequestMapping("/viewjson")
	public ResponseEntity<SampleEntity> viewJson() {
		SampleEntity sampleEntity = new SampleEntity();
		return new ResponseEntity<SampleEntity>(
				sampleService.doSomething(sampleEntity), HttpStatus.ACCEPTED);
	}

}
