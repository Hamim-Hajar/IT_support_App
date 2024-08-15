import {Component, OnInit} from '@angular/core';
import {Ticket} from "../../../models/ticket";
import {TicketService} from "../../../services/ticket.service";
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-user-ticket-list',
  templateUrl: './user-ticket-list.component.html',
  styleUrls: ['./user-ticket-list.component.scss']
})
export class UserTicketListComponent implements OnInit {
  tickets: Ticket[] = [];

  constructor(private ticketService: TicketService) {}

  ngOnInit(): void {
    this.loadTickets();
  }

  loadTickets(): void {
    this.ticketService.getAllTickets().subscribe(
      (tickets: Ticket[]) => {
        this.tickets = tickets;
      },
      (error) => {
        console.error('Error fetching tickets:', error);
      }
    );
  }

}
