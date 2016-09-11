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

import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(WebMvcConfig.class);
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

		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager.setFavorPathExtension(Boolean.TRUE);
		contentNegotiationManager.setFavorParameter(Boolean.TRUE);
		contentNegotiationManager.setMediaTypes(properties);
		contentNegotiationManager.setDefaultContentType(MediaType.APPLICATION_JSON);
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

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		super.addInterceptors(registry);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureMessageConverters(java.util.List)
	 */
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {

		super.configureMessageConverters(converters);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureHandlerExceptionResolvers(java.util.List)
	 */
	@Override
	public void configureHandlerExceptionResolvers(
			List<HandlerExceptionResolver> exceptionResolvers) {

		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addReturnValueHandlers(java.util.List)
	 */
	@Override
	public void addReturnValueHandlers(
			List<HandlerMethodReturnValueHandler> returnValueHandlers) {

		super.addReturnValueHandlers(returnValueHandlers);
	}
}
