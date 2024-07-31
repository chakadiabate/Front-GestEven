package com.kalanso.event.Controller;

import com.kalanso.event.Model.MethodePaiement;
import com.kalanso.event.Service.MethoPaiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestEvent/paie")
@AllArgsConstructor
public class MethodePaiementController {

    private MethoPaiService methoPaiService;

    @PostMapping("/AjouterMethodePaiement")
    public MethodePaiement Ajouter(MethodePaiement methodePaiement){
        return methoPaiService.Ajouter(methodePaiement);
    }

    @GetMapping("/AfficherMethodePaiement")
    public List<MethodePaiement> AfficherMethode(){
        return methoPaiService.AfficherMethode();
    }

    @PutMapping("/ModifierMethodePaiement")
    public MethodePaiement ModifierMethode(Long id, MethodePaiement methodePaiement){
        return methoPaiService.ModifierMethode(id, methodePaiement);
    }

    @DeleteMapping("/SupprimerMethodePaiement")
    public String SupMethodePaiement(Long id){
        return methoPaiService.SupMethodePaiement(id);
    }

}
