package com.kalanso.event.Controller;

import com.kalanso.event.Model.Equipement;
import com.kalanso.event.Service.EquiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestEvent/Equipement")
@AllArgsConstructor
public class EquipementController {
    private EquiService equiService;

    @PostMapping("/AjouterEqui")
    public Equipement AjouterEqui(Equipement equipement){
        return equiService.AjouterEqui(equipement);
    }

    @GetMapping("/AfficherEqui")
    public List<Equipement> AfficherEqui(){
        return equiService.AfficherEqui();
    }

    @PutMapping("/ModifierEqui")
    public Equipement ModifierEqui(Integer id, Equipement equipement){
        return equiService.ModifierEqui(id, equipement);
    }

    @DeleteMapping("/SupEqui")
    public String SupEqui(Integer id){
        return equiService.SupEqui(id);
    }
}
