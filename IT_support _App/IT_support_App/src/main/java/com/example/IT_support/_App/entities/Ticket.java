package com.example.IT_support._App.entities;

import com.example.IT_support._App.enums.TiketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import jakarta.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate dateCreation;
    @Enumerated(EnumType.STRING)
    private TiketStatus status;
    @ManyToOne
    private User user;
    @ManyToOne
    private Technicien technicien;
    @ManyToOne
    private Panne panne;


}
