package com.example.IT_support._App.services;

import com.example.IT_support._App.entities.Equipement;
import com.example.IT_support._App.enums.EquipementStatus;
import com.example.IT_support._App.exception.ResourceNotFoundException;
import com.example.IT_support._App.repositoreis.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementService {
        @Autowired
        private EquipementRepository equipementRepository;

        public Equipement addEquipment(Equipement equipment) {
            equipment.setStaus(EquipementStatus.FUNCTIONAL);
            return equipementRepository.save(equipment);
        }

        public Equipement updateEquipment(Long id, Equipement updatedEquipment) {
            Equipement equipment = equipementRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));
            equipment.setNome(updatedEquipment.getNome());
            equipment.setType(updatedEquipment.getType());
            // Only allow status update if it's different from current status
            if (updatedEquipment.getStaus() != equipment.getStaus()) {
                equipment.setStaus(updatedEquipment.getStaus());
            }
            return equipementRepository.save(equipment);
        }

    public void deleteEquipment(Long id) {
        Equipement equipment = equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));
        equipementRepository.delete(equipment);
    }

    public List<Equipement> getAllEquipments() {
        return (List<Equipement>) equipementRepository.findAll();
    }

    public Equipement getEquipmentById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));
    }
}

