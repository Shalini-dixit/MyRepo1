package com.assignment.car.portal.model;

import java.time.LocalDateTime;

public class CarBO {
	
	
	private Long id;

	
	private String name;

	
	private Integer status;

	
	private LocalDateTime   created;
	
	
	private String licensePlate;

	
	
    private CarSettingsBO carSetting;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public LocalDateTime getCreated() {
		return created;
	}



	public void setCreated(LocalDateTime created) {
		this.created = created;
	}



	public String getLicensePlate() {
		return licensePlate;
	}



	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}


	/**
	 * @return the carSetting
	 */
	public CarSettingsBO getCarSetting() {
		return carSetting;
	}



	/**
	 * @param carSetting the carSetting to set
	 */
	public void setCarSetting(CarSettingsBO carSetting) {
		this.carSetting = carSetting;
	}



	public CarBO( String name, Integer status, LocalDateTime created, String licensePlate,
			CarSettingsBO carSetting) {
		super();
		this.name = name;
		this.status = status;
		this.created = created;
		this.licensePlate = licensePlate;
		this.carSetting = carSetting;
	}
    
    	


}
