package com.assignment.car.portal.bean;

/**
 * @author Shalini Dixit
 *
 */
public class CarRequestBean { 
	String name;
	String licensePlate;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * @param licensePlate the licensePlate to set
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	public boolean validate() {
		if (this.name == null || this.licensePlate==null ||  (this.name.trim().length() ==0) || (this.licensePlate.trim().length() ==0)) 
			return false;
		else
			return true;
		
	}

	@Override
	public String toString() {
		return "CarRequestBean [name=" + name + ", licensePlate=" + licensePlate + "]";
	}

}
