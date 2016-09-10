/*
 * (C) Koninklijke Philips Electronics N.V. 2016
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: WebMvcConfig.java
 *  
 */
/**
 * @author Sushanta Dutta
 */
package com.philips.refapp.config;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * The Class WebMvcConfig.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.philips.refapp.web" })
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	/** The Constant CACHE_PERIOD. */
	private static final int CACHE_PERIOD = 31556926; // one year

	/** The request mapping handler adapter. */
	@Autowired
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
	}

	// @Bean
	// public ViewResolver viewResolver() {
	// // Example: the 'info' view logical name is mapped to the file
	// // '/WEB-INF/jsp/info.jsp'
	// InternalResourceViewResolver bean = new InternalResourceViewResolver();
	// bean.setViewClass(JstlView.class);
	// bean.setPrefix("/WEB-INF/jsp/");
	// bean.setSuffix(".jsp");
	// return bean;
	// }

	/**
	 * Content negotiation manager.
	 *
	 * @return the content negotiation manager factory bean
	 */
	@Bean(name = "contentNegotiationManagerFactoryBean")
	public ContentNegotiationManagerFactoryBean contentNegotiationManager() {
		Properties properties = new Properties();
		properties.setProperty("xml", "application/xml");
		properties.setProperty("json", "application/json");
		// properties.setProperty("html", "application/html");

		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager.setFavorParameter(true);
		contentNegotiationManager.setMediaTypes(properties);
		contentNegotiationManager
				.setDefaultContentType(MediaType.APPLICATION_JSON);

		return contentNegotiationManager;
	}

	/**
	 * Reloadable resource bundle message source.
	 *
	 * @return the reloadable resource bundle message source
	 */
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:com/philips/refapp/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// // Static ressources from both WEB-INF and webjars
	// registry
	// .addResourceHandler("/resources/**")
	// .addResourceLocations("/resources/")
	// .setCachePeriod(CACHE_PERIOD);
	// registry
	// .addResourceHandler("/webjars/**")
	// .addResourceLocations("classpath:/META-INF/resources/webjars/")
	// .setCachePeriod(CACHE_PERIOD);
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #addViewControllers(org.springframework.web.servlet.config.annotation.
	 * ViewControllerRegistry)
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// registry.addViewController("/about"); // the about page did not
		// required any controller
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #configureDefaultServletHandling(org.springframework.web.servlet.config.
	 * annotation.DefaultServletHandlerConfigurer)
	 */
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		// Serving static files using the Servlet container's default Servlet.
		configurer.enable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #addFormatters(org.springframework.format.FormatterRegistry)
	 */
	@Override
	public void addFormatters(FormatterRegistry formatterRegistry) {
		// add your custom formatters
	}
}
