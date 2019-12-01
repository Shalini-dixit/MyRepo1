import '../polyfills';

import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material';
import { BrowserModule } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from '../material-module';
import { AppComponent } from './app.component';
import { ApiService } from './car-list/api.service';
import { RideCarComponent } from './ride-car/ride-car.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { MatIconModule} from '@angular/material';
import { MatMomentDateModule } from "@angular/material-moment-adapter";
import {MatSelectModule} from '@angular/material/select';
import { RouterModule } from '@angular/router';
import appRoutes from './routerConfig';
import { CarListComponent } from './car-list/car-list.component';

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MaterialModule,
    MatExpansionModule,
    MatIconModule,
    MatMomentDateModule,
    MatSelectModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ],
  entryComponents: [AppComponent],
  declarations: [AppComponent, RideCarComponent, CarListComponent],
  bootstrap: [AppComponent],
  providers: [ApiService]
})

export class AppModule { }

platformBrowserDynamic().bootstrapModule(AppModule);