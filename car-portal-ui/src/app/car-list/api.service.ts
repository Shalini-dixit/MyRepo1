import { Injectable } from "@angular/core";
import { Observable } from 'rxjs';
import { map, } from 'rxjs/operators';

import { HttpHeaders, HttpClient } from '@angular/common/http';

const endpoint = 'http://localhost:9090/employees';
const endpoint_car = 'http://localhost:9090/cars';


const headers: HttpHeaders = new HttpHeaders({
  'Content-Type': 'application/json',
  'Accept': 'application/json'
})

@Injectable()
export class ApiService {
  carId: Number;
  constructor(private http: HttpClient) { }

  getCars(): Observable<any> {
    return this.http.get(endpoint_car, { headers }).pipe(
      map(this.extractData));
  }

  getCarDetails(id): Observable<any> {
    return this.http.get(endpoint_car + '/' + id).pipe(map(this.extractData));
  }

  private extractData(res: Response) {
    let body = res;
    return body || {};
  }
}