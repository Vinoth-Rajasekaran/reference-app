/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: RepositoryConfig.java
 */

/**
 * @author Sushanta Dutta
 */
package com.philips.refapp.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Enable and scan Spring Data repositories. 
 * 
 */
@Configuration
@EnableJpaRepositories("com.philips.refapp.repository")
@ComponentScan(basePackages={"com.philips.refapp.repository"})
public class RepositoryConfig {
	private static final Logger LOG = LoggerFactory.getLogger(RepositoryConfig.class);
}
