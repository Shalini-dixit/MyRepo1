package com.assignment.car.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.car.portal.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
