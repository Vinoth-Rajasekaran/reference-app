/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: InfrastructureConfig.java
 */

/**
 * @author Sushanta Dutta
 */
package com.philips.refapp.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.philips.refapp.interceptor.EntityInterceptor;

/**
 * The Class InfrastructureConfig.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource({ "classpath:com/philips/refapp/config/infrastructure_dev.properties" })
@Profile(value = { "dev" })
public class InfrastructureConfig_DEV {

	/** The env. */
	@Autowired
	Environment env;

	/**
	 * Data source.
	 *
	 * @return the jndi object factory bean
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	@Bean
	public DataSource dataSource() throws IllegalArgumentException {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource(env.getProperty("dev.jdbc.datasource"));
		return dataSource;
	}

	/**
	 * Transaction manager.
	 *
	 * @return the jpa transaction manager
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
		return jpaTransactionManager;
	}

	/**
	 * Transaction template.
	 *
	 * @return the transaction template
	 */
	@Bean
	public TransactionTemplate transactionTemplate() {
		TransactionTemplate transactionTemplate = new TransactionTemplate();
		transactionTemplate.setTransactionManager(transactionManager());
		return transactionTemplate;
	}

	/**
	 * Entity manager factory.
	 *
	 * @return the entity manager factory
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("persistenceUnit");
		em.setPackagesToScan("com.philips.refapp.domain");
		em.setJpaVendorAdapter(jpaVendorAdaper());
		em.setJpaPropertyMap(additionalProperties());
		em.afterPropertiesSet();
		return em.getObject();
	}

	/**
	 * Jpa vendor adaper.
	 *
	 * @return the jpa vendor adapter
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdaper() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		vendorAdapter.setShowSql(Boolean.TRUE);
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		return vendorAdapter;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * Additional properties.
	 *
	 * @return the map
	 */
	private Map<String, Object> additionalProperties() {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto",
				env.getProperty("dev.hibernate.hbm2ddl.auto"));
		properties.put("hibernate.validator.apply_to_ddl",
				env.getProperty("dev.hibernate.validator.apply_to_ddl"));
		properties.put("hibernate.validator.autoregister_listeners", env
				.getProperty("dev.hibernate.validator.autoregister_listeners"));
		properties.put("hibernate.dialect", env.getProperty("dev.hibernate.dialect"));
		properties.put("hibernate.generate_statistics",
				env.getProperty("dev.hibernate.generate_statistics"));
		properties.put("hibernate.ejb.interceptor", new EntityInterceptor());
		properties.put("hibernate.default_schema",
				env.getProperty("dev.hibernate.default_schema"));

		// Second level cache configuration and so on.
		return properties;
	}

}