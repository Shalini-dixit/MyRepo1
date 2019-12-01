import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RideCarComponent } from './ride-car.component';

describe('RideCarComponent', () => {
  let component: RideCarComponent;
  let fixture: ComponentFixture<RideCarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RideCarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RideCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
