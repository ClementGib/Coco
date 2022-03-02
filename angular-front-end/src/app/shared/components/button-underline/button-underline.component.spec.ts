import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonUnderlineComponent } from './button-underline.component';

describe('ButtonUnderlineComponent', () => {
  let component: ButtonUnderlineComponent;
  let fixture: ComponentFixture<ButtonUnderlineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ButtonUnderlineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ButtonUnderlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
