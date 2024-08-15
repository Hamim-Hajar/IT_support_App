package com.example.IT_support._App.services;

import com.example.IT_support._App.entities.Technicien;
import com.example.IT_support._App.entities.Ticket;
import com.example.IT_support._App.entities.User;
import com.example.IT_support._App.enums.TiketStatus;
import com.example.IT_support._App.exception.ResourceNotFoundException;
import com.example.IT_support._App.repositoreis.TechnicienRepository;
import com.example.IT_support._App.repositoreis.TicketRepository;
import com.example.IT_support._App.repositoreis.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TechnicienRepository technicienRepository;

    public Ticket createTicket(Ticket ticket, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        ticket.setUser(user);
        ticket.setStatus(TiketStatus.OPEN);
        return ticketRepository.save(ticket);
    }

    public Ticket assignTicket(Long ticketId, Long technicienId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
        Technicien technicien = technicienRepository.findById(technicienId)
                .orElseThrow(() -> new ResourceNotFoundException("Technicien not found"));
        ticket.setTechnicien(technicien);
        ticket.setStatus(TiketStatus.IN_PROGRESS);
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicketStatus(Long id, TiketStatus status) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    public List<Ticket> getTicketsByTechnicien(Long technicienId) {
        Technicien technicien = technicienRepository.findById(technicienId)
                .orElseThrow(() -> new ResourceNotFoundException("Technicien not found"));
        return ticketRepository.findByTechnicien(technicien);
    }


    public List<Ticket> getTicketsByUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return ticketRepository.findByUser(user);
    }
    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
        ticketRepository.delete(ticket);
    }
}
