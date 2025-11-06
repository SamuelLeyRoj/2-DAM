import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ConocerGenteComponent } from './conocer-gente.component';

describe('ConocerGenteComponent', () => {
  let component: ConocerGenteComponent;
  let fixture: ComponentFixture<ConocerGenteComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [ConocerGenteComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ConocerGenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
