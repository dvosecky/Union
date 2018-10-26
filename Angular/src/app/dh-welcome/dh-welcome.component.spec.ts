import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DhWelcomeComponent } from './dh-welcome.component';

describe('DhWelcomeComponent', () => {
  let component: DhWelcomeComponent;
  let fixture: ComponentFixture<DhWelcomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DhWelcomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DhWelcomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
