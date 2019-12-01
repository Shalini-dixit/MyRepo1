
DROP TABLE IF EXISTS CAR_DETAILS;
 
CREATE TABLE CAR_DETAILS (
  car_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  status INT NOT NULL,
  created TIMESTAMP NOT NULL,
  license_plate VARCHAR(250) NOT NULL
);

ALTER TABLE CAR_DETAILS
ADD CONSTRAINT License_Unique
UNIQUE (license_plate );

DROP TABLE IF EXISTS CAR_SETTINGS;
 
CREATE TABLE CAR_SETTINGS (
  car_setting_id INT AUTO_INCREMENT  PRIMARY KEY,
  car_id INT,
  speed INT ,
  lights INT ,
  left_signal INT ,
  right_signal INT ,
  foreign key (car_id) references CAR_DETAILS(car_id)
);



DROP TABLE IF EXISTS EMPLOYEE_DETAILS;
 
CREATE TABLE EMPLOYEE_DETAILS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  salary INT NOT NULL,
  hire_date DATE NOT NULL
);