/**
 * 
 */
package com.assignment.car.portal.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.car.portal.bean.CarRequestBean;
import com.assignment.car.portal.contoller.CarFeatures;
import com.assignment.car.portal.entity.Car;
import com.assignment.car.portal.entity.CarSetting;
import com.assignment.car.portal.exception.RecordNotFoundException;
import com.assignment.car.portal.model.CarBO;
import com.assignment.car.portal.model.CarSettingsBO;
import com.assignment.car.portal.repository.CarRepository;
import com.assignment.car.portal.repository.CarSettingRepository;

/**
 * @author Shalini Dixit
 *
 */
@Service
public class CarService {

	@Autowired
	CarRepository repository;

	@Autowired
	CarSettingRepository settingRepository;

	/**
	 * This method fetch all employees from DB
	 * 
	 * @return
	 */
	public List<Car> getAllCars() {
		List<Car> carList = repository.findAll();

		if (carList.size() > 0) {
			return carList;
		} else {
			return new ArrayList<Car>();
		}
	}

	/**
	 * This method details of a employee for given employee id
	 * 
	 * @TODO Currently this method is not being consumed as we are having less
	 *       details about employee that is available in list data already , once we
	 *       have more data we can use this to get details.
	 * 
	 * @param id
	 * @return
	 * @throws RecordNotFoundException
	 */
	public Car getCarById(Long id) throws RecordNotFoundException {
		Optional<Car> car = repository.findById(id);

		if (car.isPresent()) {
			return car.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public Car createCar(CarRequestBean carRequestBean) {
		CarSettingsBO carSettingsBO = new CarSettingsBO(null, null, null, null);
		CarBO carBo = new CarBO(carRequestBean.getName(), 0, LocalDateTime.now(), carRequestBean.getLicensePlate(),
				carSettingsBO);
		Car newCar = new Car(carBo);

		return repository.save(newCar);

	}

	public Car updateCarFeatures(Long id, CarFeatures carFeatures, Integer featureStatus)
			throws RecordNotFoundException {

		CarSetting carSetting = null;

		Car car = getCarById(id);

		if (car != null) {

			carSetting = car.getCarSetting();

			if (carFeatures == CarFeatures.LEFT_TURN) {
				if (carSetting != null) {
					carSetting.setLeftSignal(featureStatus);
				} else {
					carSetting = new CarSetting(null, null, featureStatus, null, car);
				}

				car.setCarSetting(carSetting);

			} else if (carFeatures == CarFeatures.RIGHT_TURN) {
				if (carSetting != null) {
					carSetting.setRightSignal(featureStatus);
				} else {
					carSetting = new CarSetting(null, null, null, featureStatus, car);
				}

				car.setCarSetting(carSetting);

			} else if (carFeatures == CarFeatures.LIGHTS) {
				if (carSetting != null) {
					carSetting.setLights(featureStatus);
				} else {
					carSetting = new CarSetting(null, featureStatus, null, null, car);
				}

				car.setCarSetting(carSetting);

			} else if (carFeatures == CarFeatures.STATUS) {
				System.out.println(CarFeatures.STATUS.toString());
				if (car != null) {
					car.setStatus(featureStatus);
				}

			} else if (carFeatures == CarFeatures.SPEED) {
				if (carSetting != null) {
					carSetting.setSpeed(featureStatus);
				} else {
					carSetting = new CarSetting(featureStatus, null, null, null, car);
				}

				car.setCarSetting(carSetting);

			}

			car = repository.saveAndFlush(car);
		}
		return car;
	}

	
	  public Car updateCar(Long id, CarBO carBo) throws RecordNotFoundException {
		  System.out.println(carBo);
		  CarSetting carSetting = null;

			Car car = getCarById(id);

			if (car != null) {
				car.setStatus(carBo.getStatus());
			

				carSetting = car.getCarSetting();

				
					if (carSetting != null) {
						carSetting.setLeftSignal(carBo.getCarSetting().getLeftSignal());
						carSetting.setRightSignal(carBo.getCarSetting().getRightSignal());
						carSetting.setLights(carBo.getCarSetting().getLights());
						carSetting.setSpeed(carBo.getCarSetting().getSpeed());
					} else {
						carSetting = new CarSetting();
						carSetting.setCar(car);
						CarSettingsBO carSettingsBO = carBo.getCarSetting();
						if( carSettingsBO != null) {
							if(carSettingsBO.getSpeed() != null)
								carSetting.setSpeed(carSettingsBO.getSpeed());
							if(carSettingsBO.getLights()!= null)
								carSetting.setLights(carSettingsBO.getLights());
							if(carSettingsBO.getLeftSignal() != null)
								carSetting.setLeftSignal(carSettingsBO.getLeftSignal());
							if(carSettingsBO.getRightSignal() != null)
								carSetting.setRightSignal(carSettingsBO.getRightSignal());
						}

				} 
					
				car.setCarSetting(carSetting);
				car = repository.saveAndFlush(car);
			}
			return car;
	  }
	 
	public Object updateLicencePlate(Long id, String licence_plate) throws RecordNotFoundException {
		Car car = getCarById(id);
		if (car != null) {
			car.setLicensePlate(licence_plate);
			car = repository.saveAndFlush(car);
		}
		return car;
	}
}
