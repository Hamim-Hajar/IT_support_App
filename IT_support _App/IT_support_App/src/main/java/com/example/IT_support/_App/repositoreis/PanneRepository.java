package com.example.IT_support._App.repositoreis;

import com.example.IT_support._App.entities.Equipement;
import com.example.IT_support._App.entities.Panne;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PanneRepository extends JpaRepository<Panne, Long> {
    List<Panne> findByEquipment(Equipement equipment);
    List<Panne> findByEquipmentOrderByDatePanneDesc(Equipement equipment);
}
