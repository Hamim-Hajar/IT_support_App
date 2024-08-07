package com.example.IT_support._App.controller;

import com.example.IT_support._App.entities.Equipement;
import com.example.IT_support._App.services.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {
    @Autowired
    private EquipementService equipmentService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Equipement> addEquipment(@RequestBody Equipement equipment) {
        return ResponseEntity.ok(equipmentService.addEquipment(equipment));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Equipement> updateEquipment(@PathVariable Long id, @RequestBody Equipement equipment) {
        return ResponseEntity.ok(equipmentService.updateEquipment(id, equipment));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Equipement>> getAllEquipments() {
        return ResponseEntity.ok(equipmentService.getAllEquipments());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Equipement> getEquipmentById(@PathVariable Long id) {
        return ResponseEntity.ok(equipmentService.getEquipmentById(id));
    }
}