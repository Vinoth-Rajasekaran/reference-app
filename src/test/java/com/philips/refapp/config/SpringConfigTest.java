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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.philips.refapp.domain.Exception_Messages;
import com.philips.refapp.exception.resolver.GlobalExceptionResolver;
import com.philips.refapp.repository.impl.AbstractCRUDRespository;
import com.philips.refapp.util.CacheExceptionMsg;

/**
 * The Class SpringConfigTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(classes = AppStart.class),
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

	@Test
	public void testExceptionMsgResolver() {
		CacheExceptionMsg cacheExceptionMsg = wac
				.getBean(CacheExceptionMsg.class);
		assertNotNull(cacheExceptionMsg);
		GlobalExceptionResolver exceptionResolver = wac.getBean(GlobalExceptionResolver.class);
		assertNotNull(exceptionResolver);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testProxy() throws NoSuchMethodException,
			IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException, NoSuchFieldException, SecurityException {
		try {
			ProxyFactory factory = new ProxyFactory();
			factory.setSuperclass(AbstractCRUDRespository.class);
			factory.setFilter(new MethodFilter() {
				@Override
				public boolean isHandled(Method method) {
					return Modifier.isAbstract(method.getModifiers());
				}
			});

			AbstractCRUDRespository<Exception_Messages, Long> abstractCRUDRespository = (AbstractCRUDRespository) factory
					.create(new Class<?>[0], new Object[0], handler);
			EntityManagerFactory entityManagerFactory = wac.getBean(EntityManagerFactory.class);
			Field entityManagerField = org.springframework.util.ReflectionUtils.findField(AbstractCRUDRespository.class, "entityManager");
			entityManagerField.setAccessible(Boolean.TRUE);
			ReflectionUtils.setField(entityManagerField, abstractCRUDRespository, entityManagerFactory.createEntityManager());
			
			abstractCRUDRespository.create(new Exception_Messages());
			
			Field classField = org.springframework.util.ReflectionUtils.findField(AbstractCRUDRespository.class, "entityClass");
			classField.setAccessible(Boolean.TRUE);
			ReflectionUtils.setField(classField, abstractCRUDRespository, Exception_Messages.class);
			List<Exception_Messages>list= abstractCRUDRespository.findAll();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	MethodHandler handler = new MethodHandler() {
		@Override
		public Object invoke(Object self, Method thisMethod, Method proceed,
				Object[] args) throws Throwable {
			System.out.println("Handling " + thisMethod
					+ " via the method handler");
			return null;
		}
	};
}