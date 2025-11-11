import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { MiRopaIntercambioYPendientesComponent } from './mi-ropa-intercambio-ypendientes.component';

describe('MiRopaIntercambioYPendientesComponent', () => {
  let component: MiRopaIntercambioYPendientesComponent;
  let fixture: ComponentFixture<MiRopaIntercambioYPendientesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [MiRopaIntercambioYPendientesComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(MiRopaIntercambioYPendientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
