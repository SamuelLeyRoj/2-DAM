import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { FormularioCamposComponent } from './formulario-campos.component';

describe('FormularioCamposComponent', () => {
  let component: FormularioCamposComponent;
  let fixture: ComponentFixture<FormularioCamposComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [FormularioCamposComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(FormularioCamposComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
