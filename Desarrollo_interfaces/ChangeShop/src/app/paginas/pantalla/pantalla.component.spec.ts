import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PantallaPage } from './pantalla.component';

describe('PantallaComponent', () => {
  let component: PantallaPage;
  let fixture: ComponentFixture<PantallaPage>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [PantallaPage],
    }).compileComponents();

    fixture = TestBed.createComponent(PantallaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
