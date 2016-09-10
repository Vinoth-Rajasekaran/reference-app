/**
 * 
 */
package com.philips.refapp.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.philips.refapp.annotation.ExceptionMsg;
import com.philips.refapp.annotation.ExceptionMsgAware;

/**
 * @author Sushanta Dutta
 *
 */
@Component
@PropertySource({ "classpath:com/philips/refapp/config/codemsg.properties" })
public final class CacheExceptionMsg {

	@Autowired
	private Environment environment;

	@Autowired
	private WebApplicationContext wac;

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
					if (nonProxyObjectToConfigure.getClass().isAnnotationPresent(ExceptionMsgAware.class)) {
						for (Field field : nonProxyObjectToConfigure.getClass().getDeclaredFields()) {
							for(Annotation annotation:field.getDeclaredAnnotations()){
								if(annotation instanceof ExceptionMsg){
									if(field.getType().isAssignableFrom(Map.class)){
										Map<String, String> map = new HashMap<String, String>();
										map.put("400", environment.getProperty("400"));
										map.put("404", environment.getProperty("404"));
										map.put("422", environment.getProperty("422"));
										map.put("415", environment.getProperty("415"));
										ReflectionUtils.setField(field, nonProxyObjectToConfigure, map);
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
