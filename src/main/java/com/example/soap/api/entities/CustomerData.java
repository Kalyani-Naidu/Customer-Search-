package com.example.soap.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerData {
	
	@Id
	@Column
	private String cif;
	
	@Column
	private String customerName;
	
	@Column
	private String civilId;
	
	@Column
	private String nationality;
	
	@Column
	private String email;

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCivilId() {
		return civilId;
	}

	public void setCivilId(String civilId) {
		this.civilId = civilId;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerData(String cif, String customerName, String civilId, String nationality, String email) {
		super();
		this.cif = cif;
		this.customerName = customerName;
		this.civilId = civilId;
		this.nationality = nationality;
		this.email = email;
	}

	public CustomerData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerData [cif=" + cif + ", customerName=" + customerName + ", civilId=" + civilId
				+ ", nationality=" + nationality + ", email=" + email + "]";
	}

	
}
