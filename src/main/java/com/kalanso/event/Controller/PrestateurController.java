package com.kalanso.event.Controller;

import com.kalanso.event.Model.Prestateur;
import com.kalanso.event.Service.PrestateurService;
import com.kalanso.event.Service.Utilisateur_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/gestEvent/prestateurs")

public class PrestateurController {

    @Autowired
    private PrestateurService prestateurService;
    private Utilisateur_service utilisateurService;

    @GetMapping
    public ResponseEntity<List<Prestateur>> getAllPrestateurs() {
        List<Prestateur> prestateurs = prestateurService.findAll();
        return ResponseEntity.ok(prestateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestateur> getPrestateurById(@PathVariable Long id) {
        Optional<Prestateur> prestateur = prestateurService.findById(id);
        return prestateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prestateur> createPrestateur( @RequestBody Prestateur prestateur) {
        Prestateur savedPrestateur = prestateurService.save(prestateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPrestateur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestateur> updatePrestateur(@PathVariable Long id, @RequestBody Prestateur prestateurDetails) {
        Optional<Prestateur> prestateur = prestateurService.findById(id);

        if (prestateur.isPresent()) {
            Prestateur prestateurToUpdate = prestateur.get();
            prestateurToUpdate.setNom(prestateurDetails.getNom());
            prestateurToUpdate.setEmail(prestateurDetails.getEmail());
            prestateurToUpdate.setProfile(prestateurDetails.getProfile());
            prestateurToUpdate.setTelephone(prestateurDetails.getTelephone());
            prestateurToUpdate.setDescription(prestateurDetails.getDescription());
            Prestateur updatedPrestateur = prestateurService.save(prestateurToUpdate);
            return ResponseEntity.ok(updatedPrestateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestateur(@PathVariable Long id) {
        Optional<Prestateur> prestateur = prestateurService.findById(id);

        if (prestateur.isPresent()) {
            prestateurService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
