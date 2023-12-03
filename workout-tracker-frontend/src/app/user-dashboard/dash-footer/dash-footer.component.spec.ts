import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashFooterComponent } from './dash-footer.component';

describe('DashFooterComponent', () => {
  let component: DashFooterComponent;
  let fixture: ComponentFixture<DashFooterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DashFooterComponent]
    });
    fixture = TestBed.createComponent(DashFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
