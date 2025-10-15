import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PantallaComponent } from './pantalla.component';

describe('PantallaComponent', () => {
  let component: PantallaComponent;
  let fixture: ComponentFixture<PantallaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [PantallaComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PantallaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
