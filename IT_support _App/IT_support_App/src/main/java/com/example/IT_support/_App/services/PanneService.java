package com.example.IT_support._App.services;

import com.example.IT_support._App.entities.Equipement;
import com.example.IT_support._App.entities.Panne;
import com.example.IT_support._App.enums.EquipementStatus;
import com.example.IT_support._App.enums.PanneStatus;
import com.example.IT_support._App.exception.ResourceNotFoundException;
import com.example.IT_support._App.repositoreis.EquipementRepository;
import com.example.IT_support._App.repositoreis.PanneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class PanneService {
    @Autowired
    private PanneRepository panneRepository;

    @Autowired
    private EquipementRepository equipmentRepository;

    public Panne reportPanne(Panne panne, Long id) {
        Equipement equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));
        panne.setEquipment(equipment);
        panne.setEtatReparation(PanneStatus.REPORTED);
        equipment.setStaus(EquipementStatus.BREAKDOWN);
        equipmentRepository.save(equipment);
        return panneRepository.save(panne);
    }

    public Panne updatePanneStatus(Long id, PanneStatus status) {
        Panne panne = panneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Panne not found"));
        panne.setEtatReparation(status);

        Equipement equipment = panne.getEquipment();
        switch (status) {
            case IN_DIAGNOSIS:
            case IN_REPAIR:
                equipment.setStaus(EquipementStatus.UNDERREPAIR);
                break;
            case RESOLVED:
                equipment.setStaus(EquipementStatus.FUNCTIONAL);
                break;
        }
        equipmentRepository.save(equipment);

        return panneRepository.save(panne);
    }

    public List<Panne> getPannesByEquipment(Long equipmentId) {
        Equipement equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));
        return panneRepository.findByEquipmentOrderByDatePanneDesc(equipment);
    }

    public List<Panne> getAllPannes() {
        return panneRepository.findAll();
    }

    public List<Panne> getPanneHistory(Long equipmentId) {
        Equipement equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));
        return panneRepository.findByEquipmentOrderByDatePanneDesc(equipment);
    }

}
