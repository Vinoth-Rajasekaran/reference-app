/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: DataSourceConfig.java
 */

/**
 * @author Sushanta Dutta
 */
package com.philips.refapp.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

/**
 * Depending active spring profile, lookup RDBMS DataSource from JNDI or from an embbeded H2 database.
 */
@Configuration
@PropertySource({ "classpath:com/philips/refapp/config/datasource.properties" })
public class DataSourceConfig {

    /** The env. */
    @Autowired
    private Environment env;

    /**
     * Data source.
     *
     * @return the jndi object factory bean
     * @throws IllegalArgumentException the illegal argument exception
     */
    @Bean
    @Profile("dev")
    public JndiObjectFactoryBean dataSource() throws IllegalArgumentException {
        JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
        dataSource.setExpectedType(DataSource.class);
        dataSource.setJndiName(env.getProperty("jdbc.jndiDataSource"));
        return dataSource;
    }

    /**
     * Test data source.
     *
     * @return the data source
     */
    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }
}
