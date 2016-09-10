/**
 * 
 */
package com.philips.refapp.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class EntityInterceptor.
 *
 * @author Sushanta Dutta
 */
public class EntityInterceptor extends EmptyInterceptor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6790722096213967908L;
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#beforeTransactionCompletion(org.hibernate.Transaction)
	 */
	@Override
	public void beforeTransactionCompletion(Transaction tx) {
		
		super.beforeTransactionCompletion(tx);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#afterTransactionBegin(org.hibernate.Transaction)
	 */
	@Override
	public void afterTransactionBegin(Transaction tx) {
		
		super.afterTransactionBegin(tx);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#afterTransactionCompletion(org.hibernate.Transaction)
	 */
	@Override
	public void afterTransactionCompletion(Transaction tx) {
		
		super.afterTransactionCompletion(tx);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#findDirty(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public int[] findDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		
		return super.findDirty(entity, id, currentState, previousState, propertyNames,
				types);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#onDelete(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		super.onDelete(entity, id, state, propertyNames, types);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#onLoad(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		return super.onLoad(entity, id, state, propertyNames, types);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#postFlush(java.util.Iterator)
	 */
	@Override
	public void postFlush(Iterator entities) {
		
		super.postFlush(entities);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#onSave(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#onFlushDirty(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		
		return super.onFlushDirty(entity, id, currentState, previousState,
				propertyNames, types);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#preFlush(java.util.Iterator)
	 */
	@Override
	public void preFlush(Iterator entities) {
		
		super.preFlush(entities);
	}
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#onCollectionUpdate(java.lang.Object, java.io.Serializable)
	 */
	@Override
	public void onCollectionUpdate(Object collection, Serializable key)
			throws CallbackException {
		
		super.onCollectionUpdate(collection, key);
	}

}
