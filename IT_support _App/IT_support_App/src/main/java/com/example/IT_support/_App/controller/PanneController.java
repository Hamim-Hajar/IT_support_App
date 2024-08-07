package com.example.IT_support._App.controller;

import com.example.IT_support._App.entities.Panne;
import com.example.IT_support._App.enums.PanneStatus;
import com.example.IT_support._App.services.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pannes")
public class PanneController {
    @Autowired
    private PanneService panneService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Panne> reportPanne(@RequestBody Panne panne, @RequestParam Long equipmentId) {
        return ResponseEntity.ok(panneService.reportPanne(panne, equipmentId));
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Panne> updatePanneStatus(@PathVariable Long id, @RequestBody PanneStatus etatReparation) {
        return ResponseEntity.ok(panneService.updatePanneStatus(id, etatReparation));
    }

    @GetMapping("/equipment/{equipmentId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Panne>> getPannesByEquipment(@PathVariable Long equipmentId) {
        return ResponseEntity.ok(panneService.getPannesByEquipment(equipmentId));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Panne>> getAllPannes() {
        return ResponseEntity.ok(panneService.getAllPannes());
    }

    @GetMapping("/history/{equipmentId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Panne>> getPanneHistory(@PathVariable Long equipmentId) {
        return ResponseEntity.ok(panneService.getPanneHistory(equipmentId));
    }
}
