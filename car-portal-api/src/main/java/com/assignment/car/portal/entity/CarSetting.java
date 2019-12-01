package com.assignment.car.portal.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import com.assignment.car.portal.model.CarSettingsBO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity to represent Employee table.
 * 
 * @author rohit
 *
 */
@Entity
@Table(name = "CAR_SETTINGS")
@ApiModel(description = "CarSetting Model contains all Settings of Car.")
public class CarSetting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_setting_id", nullable = false)
	@ApiModelProperty(notes = "The car Setting ID")
	private Long id;


	@Max(value = 999_999_999)
	@Column(name = "speed", nullable = true)
	@ApiModelProperty(notes = "The salary of car")
	private Integer speed;
	
	@Max(value = 999_999_999)
	@Column(name = "lights", nullable = true)
	@ApiModelProperty(notes = "The salary of car")
	private Integer lights;
	
	@Max(value = 999_999_999)
	@Column(name = "left_signal", nullable = true)
	@ApiModelProperty(notes = "The salary of car")
	private Integer leftSignal;
	
	@Max(value = 999_999_999)
	@Column(name = "right_signal", nullable = true)
	@ApiModelProperty(notes = "The salary of car")
	private Integer rightSignal;
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "car_id", referencedColumnName = "car_id",unique = true)
	 */
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

	

	/**
	 * Non-parameterized constructor.
	 */
	public CarSetting() {
		super();
	}

	/**
	 * Parameterized constructor with all fields
	 * 
	 * @param id
	 * @param name
	 * @param salary
	 * @param hireDate
	 */
	public CarSetting(/*Long id,*/ @Max(999999999) Integer speed, @Max(999999999) Integer lights,
			@Max(999999999) Integer leftSignal, @Max(999999999) Integer rightSignal, Car car ) {
		super();
		/*this.id = id;*/
		this.speed = speed;
		this.lights = lights;
		this.leftSignal = leftSignal;
		this.rightSignal=rightSignal;
		this.car = car;
	}
	
	public CarSetting(CarSettingsBO car) {
		super();
		this.id = car.getId();
		this.speed = car.getSpeed();
		this.lights = car.getLights();
		this.leftSignal = car.getLeftSignal();
		this.rightSignal=car.getRightSignal();
		
	}

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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((leftSignal == null) ? 0 : leftSignal.hashCode());
		result = prime * result + ((lights == null) ? 0 : lights.hashCode());
		result = prime * result + ((rightSignal == null) ? 0 : rightSignal.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarSetting other = (CarSetting) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (leftSignal == null) {
			if (other.leftSignal != null)
				return false;
		} else if (!leftSignal.equals(other.leftSignal))
			return false;
		if (lights == null) {
			if (other.lights != null)
				return false;
		} else if (!lights.equals(other.lights))
			return false;
		if (rightSignal == null) {
			if (other.rightSignal != null)
				return false;
		} else if (!rightSignal.equals(other.rightSignal))
			return false;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		return true;
	}

	/*
	 * @Override public String toString() { return "CarSetting [id=" + id +
	 * ", status=" + speed + ", lights=" + lights + ", leftSignal=" + leftSignal +
	 * ", rightSignal=" + rightSignal + "]"; }
	 */

	

	

	
}