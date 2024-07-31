package com.kalanso.event.Controller;


import com.kalanso.event.Model.StatutBillet;
import com.kalanso.event.Model.StatutEnvoi;
import com.kalanso.event.Model.StatutReservation;
import com.kalanso.event.Service.SatutReservationService;
import com.kalanso.event.Service.StatutBilletService;
import com.kalanso.event.Service.StatutEnvoiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GestEven/Statut")
public class StatutController {

    StatutBilletService statutBilletService;
    StatutEnvoiService statutEnvoiService;
    SatutReservationService satutReservationService;

    @PostMapping("/AjouterStatutBillet")
    public StatutBillet Ajout(StatutBillet statutBillet){
        return statutBilletService.Ajout(statutBillet);
    }

    @GetMapping("/AfficherStatutBillet")
    public List<StatutBillet> Afficher(){
        return statutBilletService.Afficher();
    }

    @PutMapping("/ModidierStatutBillet")
    public StatutBillet MAJ(Long Id, StatutBillet statutBillet){
        return statutBilletService.MAJ(Id, statutBillet);
    }

    @DeleteMapping("/SupprimerStatutBillet")
    public String Sup(Long Id){
        return statutBilletService.Sup(Id);
    }


    @PostMapping("/AjouterStatutEnvoi")
    public StatutEnvoi Ajout(StatutEnvoi statutEnvoi){
        return statutEnvoiService.Ajout(statutEnvoi);
    }


    @GetMapping("/AfficherStatutEnvoi")
    public List<StatutEnvoi> Affiche(){
        return statutEnvoiService.Affiche();
    }

    @PutMapping("/ModifierStatutEnvoi")
    public StatutEnvoi MAJ(Long Id, StatutEnvoi statutEnvoi){
        return statutEnvoiService.MAJ(Id, statutEnvoi);
    }


    @DeleteMapping("/SupprimerStatutEnvoi")
    public String Supp(Long Id){
        return statutEnvoiService.Supp(Id);
    }

    @PostMapping("/AjouterStatutReservation")
    public StatutReservation Ajout(StatutReservation statutReservation){
        return satutReservationService.Ajout(statutReservation);
    }


    @GetMapping("/AfficherStatutReservation")
    public List<StatutReservation> AfficherListeReservation(){
        return satutReservationService.AfficherListeReservation();
    }

    @PutMapping("/ModifierStatutReservation")
    public StatutReservation MAJ(Long Id, StatutReservation statutReservation){
        return satutReservationService.MAJ(Id, statutReservation);
    }

    @DeleteMapping("/SupprimerStatutReservation")
    public String SupStatutreservation(Long Id){
        return satutReservationService.SupStatutreservation(Id);
    }
}
