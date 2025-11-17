import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PrestamoConfirmarComponent } from './prestamo-confirmar.component';

describe('PrestamoConfirmarComponent', () => {
  let component: PrestamoConfirmarComponent;
  let fixture: ComponentFixture<PrestamoConfirmarComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [PrestamoConfirmarComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PrestamoConfirmarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
