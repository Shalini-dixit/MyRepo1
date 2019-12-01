import { Component, ViewChild } from '@angular/core';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { MatSort, MatTableDataSource, MatPaginator } from '@angular/material';
import { ApiService } from './car-list/api.service';
import { Car } from './Car';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  styleUrls: ['./app.component.css'],
  templateUrl: './app.component.html',
})

export class AppComponent {
  constructor(private router: Router) { }
  
  ngOnInit() {
   this.router.navigateByUrl('carlist');
  }

 
 
}