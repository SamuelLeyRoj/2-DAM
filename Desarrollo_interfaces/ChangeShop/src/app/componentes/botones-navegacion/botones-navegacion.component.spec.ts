import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { BotonesNavegacionComponent } from './botones-navegacion.component';

describe('BotonesNavegacionComponent', () => {
  let component: BotonesNavegacionComponent;
  let fixture: ComponentFixture<BotonesNavegacionComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [BotonesNavegacionComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(BotonesNavegacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
