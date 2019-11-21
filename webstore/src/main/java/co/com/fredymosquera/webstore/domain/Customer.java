package co.com.fredymosquera.webstore.domain;

public class Customer {

	private String customerId;
	private String name;
	private String addres;
	private String noOfOrders;
	
	public Customer() {
		
	}
	public Customer(String customerId, String name, String addres, String noOfOrders) {
		this.customerId = customerId;
		this.name = name;
		this.addres = addres;
		this.noOfOrders = noOfOrders;
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

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getNoOfOrders() {
		return noOfOrders;
	}

	public void setNoOfOrders(String noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	
	
	
	
}
