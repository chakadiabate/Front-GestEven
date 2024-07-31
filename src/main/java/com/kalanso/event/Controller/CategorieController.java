package com.kalanso.event.Controller;

import com.kalanso.event.Model.CategorieBillet;
import com.kalanso.event.Model.CategorieEvent;
import com.kalanso.event.Service.CategorieBilletService;
import com.kalanso.event.Service.CategorieEvent_service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/gestEvent/categories")
public class CategorieController {


    CategorieEvent_service categorieEventService;
    CategorieBilletService categorieBilletService;



    @PostMapping("/AjouterEventCats")
    public CategorieEvent AjouterEventCat(CategorieEvent Cat){
        return categorieEventService.AjouterCategorie(Cat);
    }

    @GetMapping("/listeEventCat")
    public List<CategorieEvent> ListeEventcat(){
        return categorieEventService.ListeCategorie();
    }

    @DeleteMapping("/supEventCat")
    public String SupEventCat(Long id){
        return categorieEventService.supprimer(id);
    }
    @PutMapping("/modifEventCat")
    public CategorieEvent modifierEventCat(Long id, CategorieEvent Cat){
        return categorieEventService.ModifierCategorie(id, Cat);
    }

    @PostMapping("/AjouterCATBillet")
    public CategorieBillet Ajout(CategorieBillet categorieBillet){
        return categorieBilletService.Ajout(categorieBillet);
    }

    @GetMapping("/AfficherBillet")
    public List<CategorieBillet> Afficher(){
        return categorieBilletService.Afficher();
    }

    @PutMapping("/ModifierCategorieBillet")
    public CategorieBillet MAJ(Long Id, CategorieBillet categorieBillet){
        return categorieBilletService.MAJ(Id, categorieBillet);
    }

    @DeleteMapping("/SupprimerCtaegorieBillet")
    public String Sup(Long Id){
        return categorieBilletService.Sup(Id);
    }

}
