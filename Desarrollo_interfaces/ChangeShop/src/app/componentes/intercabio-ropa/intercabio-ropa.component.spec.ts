import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { IntercabioRopaComponent } from './intercabio-ropa.component';

describe('IntercabioRopaComponent', () => {
  let component: IntercabioRopaComponent;
  let fixture: ComponentFixture<IntercabioRopaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [IntercabioRopaComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(IntercabioRopaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
