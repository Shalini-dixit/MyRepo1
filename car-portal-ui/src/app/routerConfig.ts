import { AppComponent } from "./app.component";
import { RideCarComponent } from "./ride-car/ride-car.component";
import { Routes } from "@angular/router";
import { CarListComponent } from "./car-list/car-list.component";

const appRoutes: Routes = [
    { path: '', 
      component:  AppComponent
    },
    {
      path: 'car',
      component: RideCarComponent
    },
    {
        path: 'carlist',
        component: CarListComponent   
    }
  ];
  
  export default appRoutes;