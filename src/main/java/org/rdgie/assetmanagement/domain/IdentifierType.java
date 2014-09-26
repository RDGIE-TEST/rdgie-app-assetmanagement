package org.rdgie.assetmanagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author pankaj
 *
 */
@Entity
@Table(name = "identifier_type")
public class IdentifierType {

	@Id
	@Column(name = "identifier_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifierTypeId;
	@Column(name = "name")
	private String name;

	public int getIdentifierTypeId() {
		return identifierTypeId;
	}

	public void setIdentifierTypeId(int identifierTypeId) {
		this.identifierTypeId = identifierTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
