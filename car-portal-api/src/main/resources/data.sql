INSERT INTO 
	CAR_DETAILS (car_id,name, status, created, license_plate) 
VALUES
  	(1,'Audi', 0, CURRENT_TIMESTAMP(),'SAWE-1231'),
  	(2,'Nissan', 0, CURRENT_TIMESTAMP(),'SAWE-1232'),
  	(3,'BMW', 1, CURRENT_TIMESTAMP(),'SAWE-1233'),
  	(4,'Ford', 0, CURRENT_TIMESTAMP(),'SAWE-1234'),
  	(5,'Chevrolet', 0, CURRENT_TIMESTAMP(),'SAWE-1235'),
  	(6,'Ferrari', 0, CURRENT_TIMESTAMP(),'SAWE-1236'),
  	(7,'Fiat', 0, CURRENT_TIMESTAMP(),'SAWE-1237'),
  	(8,'Honda', 0, CURRENT_TIMESTAMP(),'SAWE-1238'),
  	(9,'Jaguar', 0, CURRENT_TIMESTAMP(),'SAWE-1239'),
  	(10,'Lamborghini', 0, CURRENT_TIMESTAMP(),'SAWE-1230');

  	
  INSERT INTO
  	CAR_SETTINGS (car_setting_id,car_id, speed, lights, left_signal, right_signal)
  	VALUES
  		(1,1,0,0,0,0),
  		(2,2,0,0,0,0),
  		(3,3,20,0,0,0);
  		
  		
  		
  INSERT INTO 
	EMPLOYEE_DETAILS (name, salary, hire_date) 
VALUES
  	('Lokesh', 9000, '2019-07-31'),
  	('John', 8000, '2018-07-31'),
  	('Rohit', 10000, '2017-07-31'),
  	('Deepak', 6000, '2019-06-30'),
  	('Anuj', 4000, '2018-06-30'),
  	('Kamal', 11000, '2017-06-30'),
  	('Sumedha', 19000, '2019-07-28'),
  	('Rashi', 28000, '2018-07-27'),
  	('Gunjan', 10000, '2017-07-26'),
  	('Krishna', 29000, '2019-08-31'),
  	('Abhinav', 18000, '2018-08-31'),
  	('Yogendra', 20000, '2017-08-31');
