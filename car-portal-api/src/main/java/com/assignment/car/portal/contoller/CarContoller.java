/**
 * 
 */
package com.assignment.car.portal.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.car.portal.bean.CarRequestBean;
import com.assignment.car.portal.entity.Car;
import com.assignment.car.portal.exception.RecordNotFoundException;
import com.assignment.car.portal.model.CarBO;
import com.assignment.car.portal.service.CarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Shalini Dixit
 *
 */
@RestController
@RequestMapping("/cars")
@Api(value = "Cars api use to create new car, get & set car attributes")
public class CarContoller {
	@Autowired
	CarService service;

	@GetMapping
	@ApiOperation(value = "View a list of all cars")
	public ResponseEntity<List<Car>> getAllCars() {
		List<Car> list = service.getAllCars();

		return new ResponseEntity<List<Car>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "View details of a given car")
	public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Car entity = service.getCarById(id);

		return new ResponseEntity<Car>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping(value = "/createCar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "This end-point will create a new car with name & license plate")
	public ResponseEntity<Object> createCar(@RequestBody CarRequestBean carRequestBean) {
		if (carRequestBean.validate()) {
			Car car = service.createCar(carRequestBean);
			return new ResponseEntity<Object>(car, new HttpHeaders(), HttpStatus.OK);
		} else
			return new ResponseEntity<Object>("Enter valid car name and License number", new HttpHeaders(),
					HttpStatus.OK);

	}

	@PostMapping(value = "/updateCarFeatures/{id}/{carfeatures}/{featureStatus}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update details of a given car based on provided car features")
	public ResponseEntity<Car> updateCarFeatures(@PathVariable Long id, @PathVariable Integer featureStatus,
			@PathVariable CarFeatures carfeatures) throws RecordNotFoundException {
		Car car = service.updateCarFeatures(id, carfeatures, featureStatus);
		return new ResponseEntity<Car>(car, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping(value = "/updateCar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update details of a given car based on provided car features")
	public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody CarBO carBo)
			throws RecordNotFoundException {
		Car car = service.updateCar(id, carBo);
		return new ResponseEntity<Car>(car, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping(value = "/update_license_plate/{id}/{licenceNo}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update License number of a car")
	public ResponseEntity<Car> updateLicencePlate(@PathVariable Long id, @PathVariable String licenceNo)
			throws RecordNotFoundException {
		Car car = (Car) service.updateLicencePlate(id, licenceNo);
		return new ResponseEntity<Car>(car, new HttpHeaders(), HttpStatus.OK);
	}

}
