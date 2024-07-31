package com.kalanso.event.Controller;

import com.kalanso.event.Model.CategorieEvent;
import com.kalanso.event.Service.CategorieEvent_service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/gestEvent/EventCat")
@RestController
@AllArgsConstructor
public class CategorieEvent_Controller {

    CategorieEvent_service categorieEventService;

    @PutMapping("/AjouterEventCats")
    public CategorieEvent AjouterEventCat(CategorieEvent Cat){
        return categorieEventService.AjouterCategorie(Cat);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
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

}
