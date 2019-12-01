import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { map, } from 'rxjs/operators';

import { HttpHeaders, HttpClient } from '@angular/common/http';

const endpoint_car = 'http://localhost:9090/cars';

const headers: HttpHeaders = new HttpHeaders({
  'Content-Type': 'application/json',
  'Accept': 'application/json'
})

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }

  getCarList(): Observable<any> {
    return this.http.get(endpoint_car, { headers }).pipe(
      map(this.extractData));
  }

  getCarDetail(id): Observable<any> {
    return this.http.get(endpoint_car + '/' + id).pipe(map(this.extractData));
  }

  saveCarDetails(id, car): Observable<any> {
    return this.http.post(endpoint_car + '/updateCar/'+ id, car).pipe(map(this.extractData));
  }

  private extractData(res: Response) {
    let body = res;
    return body || {};
  }
}
