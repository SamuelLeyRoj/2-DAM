import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ContactosComponent } from './contactos.component';

describe('ContactosComponent', () => {
  let component: ContactosComponent;
  let fixture: ComponentFixture<ContactosComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [ContactosComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ContactosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
