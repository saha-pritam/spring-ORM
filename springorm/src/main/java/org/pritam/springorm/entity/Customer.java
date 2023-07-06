package org.pritam.springorm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class Customer {
	@Id
	@Column(name="CustomerID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerID;
	@Column(name="CustomerName")
	private String customerName;
	@Column(name="ContactName")
	private String contactName;
	@Column(name="Address")
	private String address;
	@Column(name="City")
	private String city;
	@Column(name="PostalCode")
	private String postalCode;
	@Column(name="Country")
	private String country;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerName, String contactName, String address, String city, String postalCode,
			String country) {
		super();
		this.customerName = customerName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}
	public Customer(int customerID, String customerName, String contactName, String address, String city,
			String postalCode, String country) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", contactName=" + contactName
				+ ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + ", country=" + country
				+ "]";
	}
}
