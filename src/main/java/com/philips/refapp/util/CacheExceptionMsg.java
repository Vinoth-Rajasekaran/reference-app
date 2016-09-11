/**
 * 
 */
package com.philips.refapp.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.philips.refapp.annotation.ExceptionMsg;
import com.philips.refapp.annotation.ExceptionMsgAware;
import com.philips.refapp.domain.Exception_Messages;
import com.philips.refapp.repository.CRUDRepository;

/**
 * @author Sushanta Dutta
 *
 */
@Component
public final class CacheExceptionMsg {

	@Autowired
	private Environment environment;
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	@Qualifier("exceptionMessagesDaoImpl")
	private CRUDRepository<Exception_Messages, Long> crudRespository;

	@PostConstruct
	private void init() {
		if (wac instanceof ListableBeanFactory) {
			final String[] beanNames = ((ListableBeanFactory) wac)
					.getBeanNamesForAnnotation(ExceptionMsgAware.class);
			if (null == beanNames) {
				// do nothing
			} else {
				for (final String beanNameToCheck : beanNames) {
					if (wac.isPrototype(beanNameToCheck)) {
						throw new IllegalStateException(
								"Spring bean, "
										+ beanNameToCheck
										+ ", is intended to be configured but is not a prototype type. "
										+ "Configurations will not be applied.");
					}
				}
				Object nonProxyObjectToConfigure = null;
				for (String beanName : beanNames) {
					final Object instance = wac.getBean(beanName);
					if (null == instance) {
						return;
					}
					if (instance instanceof Advised) {
						try {
							nonProxyObjectToConfigure = ((Advised) instance)
									.getTargetSource().getTarget();
						} catch (final Exception ex) {
							return;
						}
					} else {
						nonProxyObjectToConfigure = instance;
					}
					if (nonProxyObjectToConfigure.getClass()
							.isAnnotationPresent(ExceptionMsgAware.class)) {
						for (Field field : nonProxyObjectToConfigure.getClass()
								.getDeclaredFields()) {
							for (Annotation annotation : field
									.getDeclaredAnnotations()) {
								if (annotation instanceof ExceptionMsg) {
									List<Exception_Messages> exception_Messages = crudRespository.findAll();
									if (field.getType().isAssignableFrom(
											Map.class)) {
										Map<String, String> map = new HashMap<String, String>();
										for (Exception_Messages messages : exception_Messages) {
											map.put(messages.getCode(),
													messages.getMessage());
										}
										ReflectionUtils.setField(field,
												nonProxyObjectToConfigure, map);
									}
								}
							}
						}
					}

				}
			}
		}

	}

}
