import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CartasRopaComponent } from './cartas-ropa.component';

describe('CartasRopaComponent', () => {
  let component: CartasRopaComponent;
  let fixture: ComponentFixture<CartasRopaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [CartasRopaComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(CartasRopaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
