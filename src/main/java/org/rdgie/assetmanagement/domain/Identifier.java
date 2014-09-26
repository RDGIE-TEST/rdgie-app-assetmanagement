package org.rdgie.assetmanagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author pankaj
 *
 */
@Entity
@Table(name = "identifier")
public class Identifier {

	@Id
	@Column(name = "identifier_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifierId;

	@ManyToOne
	@JoinColumn(name="identifier_type_id")
	private IdentifierType identifierType;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;

	@Column(name = "identifierValue")
	private String identifierValue;

	public int getIdentifierId() {
		return identifierId;
	}

	public void setIdentifierId(int identifierId) {
		this.identifierId = identifierId;
	}

	public IdentifierType getIdentifierType() {
		return identifierType;
	}

	public void setIdentifierType(IdentifierType identifierType) {
		this.identifierType = identifierType;
	}

	public String getIdentifierValue() {
		return identifierValue;
	}

	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
