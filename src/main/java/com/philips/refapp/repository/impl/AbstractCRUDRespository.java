/*
 * (C) Koninklijke Philips Electronics N.V. 2014
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 * 
 * File name: AbstractBaseDao.java
 */
package com.philips.refapp.repository.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import com.philips.refapp.domain.AbstractEntity;
import com.philips.refapp.repository.CRUDRepository;

/**
 * @author Sushanta Dutta
 *
 */
public abstract class AbstractCRUDRespository<T extends AbstractEntity, PK extends Serializable>
		implements CRUDRepository<T, PK> {

	private EntityManager entityManager;
	private Class<T> entityClass;

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public T create(T t) {
		this.entityManager.persist(t);
		return t;
	}

	@Override
	public T read(PK id) {
		return this.entityManager.find(entityClass, id);
	}

	@Override
	public T update(T t) {
		return this.entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

}
