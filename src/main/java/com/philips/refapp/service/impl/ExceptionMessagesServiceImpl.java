/**
 * 
 */
package com.philips.refapp.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.philips.refapp.domain.Exception_Messages;
import com.philips.refapp.repository.CRUDRepository;
import com.philips.refapp.service.BaseService;

/**
 * @author Sushanta Dutta
 *
 */
@Service("exceptionMessagesServiceImpl")
@Transactional
public class ExceptionMessagesServiceImpl implements
		BaseService<Exception_Messages> {
			
	@Autowired
	@Qualifier("exceptionMessagesDaoImpl")
	private CRUDRepository<Exception_Messages, Long> crudRepository;

	@Override
	public Exception_Messages doSomething(Exception_Messages entity) {
		return crudRepository.create(entity);
	}

}
