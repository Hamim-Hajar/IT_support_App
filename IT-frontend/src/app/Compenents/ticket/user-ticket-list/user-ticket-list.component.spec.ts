import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTicketListComponent } from './user-ticket-list.component';

describe('UserTicketListComponent', () => {
  let component: UserTicketListComponent;
  let fixture: ComponentFixture<UserTicketListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserTicketListComponent]
    });
    fixture = TestBed.createComponent(UserTicketListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
