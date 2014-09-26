package org.rdgie.assetmanagement.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author pankaj
 *
 */

@Entity
@Table(name = "entry")
public class Entry {

	@Id
	@Column(name = "entry_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int entryId;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public enum EntryType {
		GIVE, RETURN, HANDOVER;

		@Override
		public String toString() {
			switch (this) {
			case GIVE:
				return "Give";
			case RETURN:
				return "Return";
			case HANDOVER:
				return "Handover";
			default:
				throw new IllegalArgumentException();
			}
		}
	}

	@Column(name = "entry_type")
	protected String entryType;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Item> items;

	@Transient
	private Item item;

	@Column(name = "date")
	private Date date; // Current Date

	@Column(name = "givenDate")
	private Date givenDate;

	@Column(name = "returnDate")
	private Date returnDate;

	@Column(name = "comments")
	private String comments;

	public Entry() {
	}

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getGivenDate() {
		return givenDate;
	}

	public void setGivenDate(Date givenDate) {
		this.givenDate = givenDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Entry [entryId=" + entryId + ", employee=" + employee
				+ ", date=" + date + ", givenDate=" + givenDate
				+ ", returnDate=" + returnDate + ", entryType=" + entryType
				+ ", comments=" + comments + "]";
	}

}