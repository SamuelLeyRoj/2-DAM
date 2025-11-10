import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { RopaInformacionComponent } from './ropa-informacion.component';

describe('RopaInformacionComponent', () => {
  let component: RopaInformacionComponent;
  let fixture: ComponentFixture<RopaInformacionComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [RopaInformacionComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(RopaInformacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
