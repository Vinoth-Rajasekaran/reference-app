/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: AppStart.java
 */

/**
 * @author Sushanta Dutta
 */
package com.philips.refapp.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

/**
 * Configuration of the business, persistence and security layers.
 */
@Configuration
@Import(value = { DataSourceConfig.class, InfrastructureConfig.class,
		RepositoryConfig.class, ServiceConfig.class,UtilityClassScanning.class })
public class AppStart {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(AppStart.class);

	/** The env. */
	@Autowired
	private Environment env;

	/**
	 * Application custom initialization code.
	 * <p/>
	 * Spring profiles can be configured with a system property
	 * -Dspring.profiles.active=dev
	 * <p/>
	 */
	@PostConstruct
	public void initApp() {
		LOG.debug("Looking for Spring profiles...");
		if (env.getActiveProfiles().length == 0) {
			LOG.info("No Spring profile configured, running with default configuration.");
		} else {
			for (String profile : env.getActiveProfiles()) {
				LOG.info("Detected Spring profile: {}", profile);
			}
		}
	}
}
