import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { MisPrendasInicioComponent } from './mis-prendas-inicio.component';

describe('MisPrendasInicioComponent', () => {
  let component: MisPrendasInicioComponent;
  let fixture: ComponentFixture<MisPrendasInicioComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [MisPrendasInicioComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(MisPrendasInicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
