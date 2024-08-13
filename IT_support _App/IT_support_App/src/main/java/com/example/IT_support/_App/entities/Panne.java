package com.example.IT_support._App.entities;

import com.example.IT_support._App.enums.PanneStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    @JoinColumn(name = "equipment_id")
    @JsonIgnore
    private Equipement equipment;

    @OneToMany(mappedBy = "panne", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

}

