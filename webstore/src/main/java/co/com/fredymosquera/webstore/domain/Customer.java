package co.com.fredymosquera.webstore.domain;

import java.io.Serializable;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8351861559165969270L;
	private String customerId;
	private String name;
	private Addres billingAndres;
	private String phoneNumber;
	
	public Customer() {
		
	}
	

	public Customer(String customerId, String name, Addres billingAndres, String phoneNumber) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.billingAndres = billingAndres;
		this.phoneNumber = phoneNumber;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Addres getBillingAndres() {
		return billingAndres;
	}

	public void setBillingAndres(Addres billingAndres) {
		this.billingAndres = billingAndres;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
}
