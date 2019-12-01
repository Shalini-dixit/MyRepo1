package com.assignment.car.portal.model;

public class CarSettingsBO {
	
	
	private Long id;

	private Integer speed;
	
	private Integer lights;
	
	private Integer leftSignal;
	
	private Integer rightSignal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getLights() {
		return lights;
	}

	public void setLights(Integer lights) {
		this.lights = lights;
	}

	public Integer getLeftSignal() {
		return leftSignal;
	}

	public void setLeftSignal(Integer leftSignal) {
		this.leftSignal = leftSignal;
	}

	public Integer getRightSignal() {
		return rightSignal;
	}

	public void setRightSignal(Integer rightSignal) {
		this.rightSignal = rightSignal;
	}

	public CarSettingsBO(Integer speed, Integer lights, Integer leftSignal, Integer rightSignal) {
		super();
		this.speed = speed;
		this.lights = lights;
		this.leftSignal = leftSignal;
		this.rightSignal = rightSignal;
	}
	
	
	

}
