import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { BotonGrandeAccionComponent } from './boton-grande-accion.component';

describe('BotonGrandeAccionComponent', () => {
  let component: BotonGrandeAccionComponent;
  let fixture: ComponentFixture<BotonGrandeAccionComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [BotonGrandeAccionComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(BotonGrandeAccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
