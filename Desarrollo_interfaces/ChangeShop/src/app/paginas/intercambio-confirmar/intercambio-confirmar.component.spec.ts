import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { IntercambioConfirmarComponent } from './intercambio-confirmar.component';

describe('IntercambioConfirmarComponent', () => {
  let component: IntercambioConfirmarComponent;
  let fixture: ComponentFixture<IntercambioConfirmarComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [IntercambioConfirmarComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(IntercambioConfirmarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
