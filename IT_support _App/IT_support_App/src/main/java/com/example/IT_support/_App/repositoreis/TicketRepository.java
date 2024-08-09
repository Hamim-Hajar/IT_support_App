package com.example.IT_support._App.repositoreis;

import com.example.IT_support._App.entities.Technicien;
import com.example.IT_support._App.entities.Ticket;
import com.example.IT_support._App.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByTechnicien(Technicien technicien);
    List<Ticket> findByUser(User user);

}
