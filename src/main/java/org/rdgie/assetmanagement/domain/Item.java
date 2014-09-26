package org.rdgie.assetmanagement.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "item_tag")
	private String itemTag;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "item", cascade = CascadeType.ALL)
	private Set<Identifier> identifiers;

	// This property will be removed after mapping the above set property
	@Transient
	private Identifier identifier;

	public enum Status {
		AVAILABLE, GIVEN, DAMAGED;

		@Override
		public String toString() {
			switch (this) {
			case AVAILABLE:
				return "Available";
			case GIVEN:
				return "Given";
			case DAMAGED:
				return "Damaged";
			default:
				throw new IllegalArgumentException();
			}
		}
	}

	@Column(name = "status")
	protected String status;

	public enum Condition {
		VERY_GOOD, GOOD, POOR;

		@Override
		public String toString() {
			switch (this) {
			case VERY_GOOD:
				return "Very Good";
			case GOOD:
				return "Good";
			case POOR:
				return "Poor";
			default:
				throw new IllegalArgumentException();
			}
		}
	}

	@Column(name = "item_condition")
	protected String itemCondition;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemTag() {
		return itemTag;
	}

	public void setItemTag(String itemTag) {
		this.itemTag = itemTag;
	}

	public Set<Identifier> getIdentifiers() {
		if (this.identifiers == null)
			this.identifiers = new HashSet<Identifier>();
		return identifiers;
	}

	public void setIdentifiers(Set<Identifier> identifiers) {
		this.identifiers = identifiers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

}
