export class Car {
  id :number;
  name: String;
  status: number;
  created: String;
  licensePlate: String;
  carSetting: CarSetting;
}


export class CarSetting {
id: number;
speed: number;
lights: number;
leftSignal: number;
rightSignal: number;
}