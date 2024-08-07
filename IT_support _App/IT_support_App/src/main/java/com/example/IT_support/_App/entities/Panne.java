package com.example.IT_support._App.entities;

import com.example.IT_support._App.enums.PanneStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Panne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Column(name = "date_panne")
    private LocalDate datePanne;
    @Enumerated(EnumType.STRING)
    private PanneStatus etatReparation;

    @ManyToOne
    private Equipement equipment;
}

