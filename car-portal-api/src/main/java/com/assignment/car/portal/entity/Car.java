package com.assignment.car.portal.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.assignment.car.portal.model.CarBO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Entity to represent Employee table.
 * 
 * @author rohit
 *
 */
@Entity
@Table(name = "CAR_DETAILS")
@ApiModel(description = "Car Model contains all attributes about Car.")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id", nullable = false)
	@ApiModelProperty(notes = "The database generated car ID")
	private Long id;

	@Column(name = "name", nullable = false)
	@ApiModelProperty(notes = "The name of car")
	private String name;

	@Max(value = 999_999_999)
	@Column(name = "status", nullable = false)
	@ApiModelProperty(notes = "The salary of car")
	private Integer status;

	@NotNull
	@Column(name = "created", nullable = false)
	@ApiModelProperty(notes = "The hireDate of car")
	private LocalDateTime created;

	@NotNull
	@Column(name = "license_plate", nullable = false)
	@ApiModelProperty(notes = "The license_plate of car")
	private String licensePlate;

	// @OneToOne(mappedBy = "car")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "car")
	private CarSetting carSetting;

	/**
	 * Non-parameterized constructor.
	 */
	public Car() {
		super();
	}

	
	public Car(/* Long id, */ String name, @Max(999999999) Integer status, @NotNull LocalDateTime created,
			@NotNull String licensePlate) {
		super();
		/* this.id = id; */
		this.name = name;
		this.status = status;
		this.created = created;
		this.licensePlate = licensePlate;
	}
	
	public Car(CarBO car) {
		super();
		/* this.id = id; */
		this.name = car.getName();
		this.status = car.getStatus();
		this.created = car.getCreated();
		this.licensePlate = car.getLicensePlate();
		this.carSetting = new CarSetting(car.getCarSetting());
	}

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

	public CarSetting getCarSetting() {
		return carSetting;
	}

	public void setCarSetting(CarSetting carSetting) {
		this.carSetting = carSetting;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Car other = (Car) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false;
		} else if (!licensePlate.equals(other.licensePlate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", status=" + status + ", created=" + created + ", licensePlate="
				+ licensePlate + "]";
	}

}