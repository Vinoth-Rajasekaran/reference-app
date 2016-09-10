/**
 * 
 */
package com.philips.refapp.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEntity.
 *
 * @author Sushanta Dutta
 */
@MappedSuperclass
public abstract class AbstractEntity {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** The created date. */
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdDate;
	
	/** The last updated date. */
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date lastUpdatedDate;

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the last updated date.
	 *
	 * @return the last updated date
	 */
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * Sets the last updated date.
	 *
	 * @param lastUpdatedDate the new last updated date
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	/**
	 * Returns the identifier of the entity.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.id == null || obj == null
				|| !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		AbstractEntity that = (AbstractEntity) obj;

		return this.id.equals(that.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
}
