import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TicketService} from "../../../services/ticket.service";
import {Ticket} from "../../../models/ticket";
import {ActivatedRoute} from "@angular/router";
import {User} from "../../../models/user";
import {Ticketstatus} from "../../../ennums/ticketstatus";

@Component({
  selector: 'app-support-ticket-form',
  templateUrl: './support-ticket-form.component.html',
  styleUrls: ['./support-ticket-form.component.scss']
})

export class SupportTicketFormComponent implements OnInit {
  ticketForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private ticketService: TicketService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm() {
    this.ticketForm = this.fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      priority: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.ticketForm.valid) {
      const newTicket: Ticket = this.ticketForm.value;
      this.ticketService.createTicket(newTicket).subscribe(
        (createdTicket) => {
          console.log('Ticket created:', createdTicket);
          this.ticketForm.reset();
        },
        (error) => {
          console.error('Error creating ticket:', error);
        }
      );
    }
  }
}
