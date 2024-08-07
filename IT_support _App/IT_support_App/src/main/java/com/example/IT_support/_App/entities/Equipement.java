package com.example.IT_support._App.entities;

import com.example.IT_support._App.enums.EquipementStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipement {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String type;
        @Enumerated(EnumType.STRING)
        private EquipementStatus staus;
@ManyToOne
private Equipement equipement;
@OneToMany
        private List<Panne> panns;
}
