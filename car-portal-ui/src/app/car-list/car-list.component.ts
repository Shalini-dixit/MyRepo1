import { Component, OnInit } from '@angular/core';
import { ApiService } from './api.service';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  constructor(private apiService: ApiService, private router : Router) { }


  displayedColumns: string[] =[ 'name', 'status', 'created', 'licensePlate'];

  dataSource = new MatTableDataSource();
  ngOnInit() {
    this.apiService.getCars().subscribe(
      data => {
        console.log(data);
        this.dataSource.data = data;
      }
    );
   
  }

  show(value: Number) {
      console.log(value);
      this.apiService.carId = value;
      this.router.navigateByUrl('/car');
  }
 

}
