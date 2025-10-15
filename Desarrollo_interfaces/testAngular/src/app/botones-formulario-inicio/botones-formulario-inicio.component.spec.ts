import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { BotonesFormularioInicioComponent } from './botones-formulario-inicio.component';

describe('BotonesFormularioInicioComponent', () => {
  let component: BotonesFormularioInicioComponent;
  let fixture: ComponentFixture<BotonesFormularioInicioComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [BotonesFormularioInicioComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(BotonesFormularioInicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
