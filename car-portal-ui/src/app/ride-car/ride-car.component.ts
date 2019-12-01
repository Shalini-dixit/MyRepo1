import { Component, OnInit } from '@angular/core';
import { CarService } from './car.service';
import { Car, CarSetting } from '../Car';
import { MatIconRegistry } from "@angular/material/icon";
import { DomSanitizer } from "@angular/platform-browser";
import { ApiService } from '../car-list/api.service';

@Component({
  selector: 'app-ride-car',
  templateUrl: './ride-car.component.html',
  styleUrls: ['./ride-car.component.css']
})
export class RideCarComponent implements OnInit {

  constructor(private apiService: CarService, private _service: ApiService) {
  }
  car: Car;
  carBo: Car
  step = 0;
  carsetting: CarSetting;
  status = 0;
  speed = 0;
  selectedSpeed = 10;
  leftSignal = 0;
  rightSignal = 0;
  lights = 0;
  name: String;
  licensePlate: String;

  // expandedElement: Car;
  ngOnInit() {
    this.apiService.getCarDetail(this._service.carId).subscribe(
      data => {
        this.car = data;
        if (this.car != null) {
          this.status = (this.car.status || 0);
          this.name = this.car.name;
          this.licensePlate = this.car.licensePlate;
          if (this.car.carSetting != null) {
            this.speed = (this.car.carSetting.speed || 0);
            this.leftSignal = (this.car.carSetting.leftSignal || 0);
            this.rightSignal = (this.car.carSetting.rightSignal || 0);
            this.lights = (this.car.carSetting.lights || 0);
          } else {
            this.car.carSetting = new CarSetting();
          }
        }
      }

    );

  }


  setStep(index: number) {
    this.step = index;
  }

  nextStep() {
    this.step++;
  }

  prevStep() {
    this.step--;
  }

  turnOn() {
    this.status = 1;
    console.log(this.status);
  }
  turnOff() {
    this.reset();     //if car is stopped then its attributes like speed, lights & turns must be reset
    this.status = 0;
    
  }

  toggleLeftSignal() {
    if (this.leftSignal === 0) {
      this.rightSignal = 0; //if right signal is on then we need to off it first then we on left signal
      this.leftSignal = 1;
    } else
      this.leftSignal = 0;
    console.log(this.leftSignal);
  }
  toggleRightSignal() {
    if (this.rightSignal === 0) {
      this.leftSignal = 0  //if left signal is on then we need to off it first then we on right signal
      this.rightSignal = 1;
    } else
      this.rightSignal = 0;
    console.log(this.rightSignal);
  }
  changeLightStatus(lightStatus: number) {
    this.lights = lightStatus;
  }

  setSpeed(speed: number) {
    this.speed = speed;
  }

  save() {
    this.car.status = this.status;
    if (this.car.carSetting == null) {
      this.car.carSetting = new CarSetting();
    }
    this.car.carSetting.speed = this.speed;
    this.car.carSetting.lights = this.lights;
    this.car.carSetting.leftSignal = this.leftSignal;
    this.car.carSetting.rightSignal = this.rightSignal;

    this.apiService.saveCarDetails(this.car.id, this.car).subscribe(
      data => {
        console.log('inside save 1221 ');
        console.log(data);
      }
    );
  }
  reset() {
    this.speed = 0;
    this.leftSignal = 0;
    this.rightSignal = 0;
    this.lights = 0;
  }

}
