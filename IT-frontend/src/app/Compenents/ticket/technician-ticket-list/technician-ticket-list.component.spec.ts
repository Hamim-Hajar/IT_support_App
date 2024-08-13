import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TechnicianTicketListComponent } from './technician-ticket-list.component';

describe('TechnicianTicketListComponent', () => {
  let component: TechnicianTicketListComponent;
  let fixture: ComponentFixture<TechnicianTicketListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TechnicianTicketListComponent]
    });
    fixture = TestBed.createComponent(TechnicianTicketListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
