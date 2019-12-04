package co.com.fredymosquera.webstore.domain;

import java.io.Serializable;

public class Addres implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4119057524118549217L;

	
	private String doorNo;
	private String streetName;
	private String areaName;
	private String state;
	private String country;
	private String zipCode;
	
	public Addres() {
		
	}
	public Addres(String doorNo, String streetName, String areaName, String state, String country, String zipCode) {
		super();
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.areaName = areaName;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Addres [doorNo=" + doorNo + ", streetName=" + streetName + ", areaName=" + areaName + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode + "]";
	}

	
	
	
	
	
}
