/**
 * 
 */
package com.philips.refapp.config.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

/**
 * @author Sushanta Dutta
 *
 */
public class EntityInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6790722096213967908L;
	
	@Override
	public void beforeTransactionCompletion(Transaction tx) {
		
		super.beforeTransactionCompletion(tx);
	}
	
	@Override
	public void afterTransactionBegin(Transaction tx) {
		
		super.afterTransactionBegin(tx);
	}
	
	@Override
	public void afterTransactionCompletion(Transaction tx) {
		
		super.afterTransactionCompletion(tx);
	}
	
	@Override
	public int[] findDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		
		return super.findDirty(entity, id, currentState, previousState, propertyNames,
				types);
	}
	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		super.onDelete(entity, id, state, propertyNames, types);
	}
	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		return super.onLoad(entity, id, state, propertyNames, types);
	}
	@Override
	public void postFlush(Iterator entities) {
		
		super.postFlush(entities);
	}
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		return super.onSave(entity, id, state, propertyNames, types);
	}
	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		
		return super.onFlushDirty(entity, id, currentState, previousState,
				propertyNames, types);
	}
	@Override
	public void preFlush(Iterator entities) {
		
		super.preFlush(entities);
	}
	@Override
	public void onCollectionUpdate(Object collection, Serializable key)
			throws CallbackException {
		
		super.onCollectionUpdate(collection, key);
	}

}
