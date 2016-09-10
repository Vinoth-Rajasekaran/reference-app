/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: Utils.java
 */

package com.philips.refapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.philips.refapp.exception.resolver.GlobalExceptionResolver;
import com.philips.refapp.util.CacheExceptionMsg;

/**
 * The Class UtilityClassScanning.
 *
 * @author Sushanta Dutta
 */
@Configuration
@ComponentScan(basePackageClasses={GlobalExceptionResolver.class,CacheExceptionMsg.class})
public class UtilityClassScanning {

}
