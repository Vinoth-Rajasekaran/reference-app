/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: SpringConfigTest.java
 */
package com.philips.refapp.config;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * The Class SpringConfigTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ 
        @ContextConfiguration(classes = AppStart.class),
        @ContextConfiguration(classes = WebMvcConfig.class) })
@ActiveProfiles("test")
public class SpringConfigTest {

    /** The wac. */
    @Autowired
    private WebApplicationContext wac;

    /**
     * Spring configuration.
     */
    @Test
    public void springConfiguration() {
        assertNotNull(wac);
    }
}