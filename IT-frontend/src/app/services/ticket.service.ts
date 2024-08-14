import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ticket} from "../models/ticket";
import {Observable} from "rxjs";
import {Ticketstatus} from "../ennums/ticketstatus";

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private apiUrl = 'http://localhost:8080/api/tickets'; // URL de l'API pour les tickets

  constructor(private http: HttpClient) { }

  createTicket(ticket: Ticket): Observable<Ticket> {
    return this.http.post<Ticket>(`${this.apiUrl}/create`, ticket);
  }

  assignTicket(ticketId: number, technicienId: number): Observable<Ticket> {
    return this.http.put<Ticket>(`${this.apiUrl}/assign/${ticketId}/${technicienId}`, {});
  }

  updateTicketStatus(id: number, status: Ticketstatus): Observable<Ticket> {
    return this.http.put<Ticket>(`${this.apiUrl}/status/${id}`, { status });
  }

  getAllTickets(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(this.apiUrl);
  }

  getTicketsByTechnicien(technicienId: number): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(`${this.apiUrl}/technicien/${technicienId}`);
  }

  getTicketsByUser(userId: number): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(`${this.apiUrl}/user/${userId}`);
  }
}
