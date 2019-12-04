package co.com.fredymosquera.webstore.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ShippingDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -116587350041617960L;
	
	private String name;
	@DateTimeFormat( pattern = "dd/MM/yyyy")
	private Date shippingDate;
	private Addres shippingAddres;
	
	public ShippingDetail() {
		
	}
	public ShippingDetail(String name, Date shippingDate, Addres shippingAddres) {
		super();
		this.name = name;
		this.shippingDate = shippingDate;
		this.shippingAddres = shippingAddres;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Addres getShippingAddres() {
		return shippingAddres;
	}
	public void setShippingAddres(Addres shippingAddres) {
		this.shippingAddres = shippingAddres;
	}
	
	
	
	
	

}
