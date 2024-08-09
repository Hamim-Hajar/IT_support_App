package com.example.IT_support._App.repositoreis;

import com.example.IT_support._App.entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}
