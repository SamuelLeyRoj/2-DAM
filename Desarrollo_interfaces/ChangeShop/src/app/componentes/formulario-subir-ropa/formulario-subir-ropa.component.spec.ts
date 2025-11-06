import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { FormularioSubirRopaComponent } from './formulario-subir-ropa.component';

describe('FormularioSubirRopaComponent', () => {
  let component: FormularioSubirRopaComponent;
  let fixture: ComponentFixture<FormularioSubirRopaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [FormularioSubirRopaComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(FormularioSubirRopaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
