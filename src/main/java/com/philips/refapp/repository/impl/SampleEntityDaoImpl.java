/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: SampleEntityDaoImpl.java
 */
package com.philips.refapp.repository.impl;

import org.springframework.stereotype.Repository;

import com.philips.refapp.domain.SampleEntity;

/**
 * The Class SampleEntityDaoImpl.
 *
 * @author Sushanta Dutta
 */

@Repository(value="sampleEntityRepo")
public class SampleEntityDaoImpl extends AbstractCRUDRespository<SampleEntity, Long> {

}
