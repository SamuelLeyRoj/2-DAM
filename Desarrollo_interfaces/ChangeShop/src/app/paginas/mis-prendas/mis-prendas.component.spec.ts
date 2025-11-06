import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { MisPrendasComponent } from './mis-prendas.component';

describe('MisPrendasComponent', () => {
  let component: MisPrendasComponent;
  let fixture: ComponentFixture<MisPrendasComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [MisPrendasComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(MisPrendasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
