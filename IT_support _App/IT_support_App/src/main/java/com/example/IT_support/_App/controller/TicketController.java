package com.example.IT_support._App.controller;

import com.example.IT_support._App.entities.Ticket;
import com.example.IT_support._App.entities.User;
import com.example.IT_support._App.enums.TiketStatus;
import com.example.IT_support._App.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(ticketService.createTicket(ticket, user.getId()));
    }

    @PutMapping("admin/{id}/assign")
   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Ticket> assignTicket(@PathVariable Long id, @RequestParam Long technicienId) {
        return ResponseEntity.ok(ticketService.assignTicket(id, technicienId));
    }

    @GetMapping("/technicien/{technicienId}")
   // @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_TECHNICIEN')")
    public ResponseEntity<List<Ticket>> getTicketsByTechnicien(@PathVariable Long technicienId) {
        return ResponseEntity.ok(ticketService.getTicketsByTechnicien(technicienId));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<Ticket>> getTicketsByUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(ticketService.getTicketsByUser(user.getId()));
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_TECHNICIEN')")
    public ResponseEntity<Ticket> updateTicketStatus(@PathVariable Long id, @RequestBody TiketStatus status) {
        return ResponseEntity.ok(ticketService.updateTicketStatus(id, status));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }
}
