package com.kalanso.event.Controller;

import com.kalanso.event.Model.Admin;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Service.Evenement_service;
import com.kalanso.event.Service.Utilisateur_service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/gestEvent/event")
@AllArgsConstructor
public class EvenementController {

    private Evenement_service evenementService;

    @PostMapping("/addEvent")
    private String ajout (@RequestBody Evenement evenement){
        return evenementService.Ajout(evenement);
    }


    @GetMapping("/{id}")
    private Optional<Evenement> ajout (@PathVariable Integer id){
        return evenementService.Event(id);
    }


//    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/afficher")
    private List<Evenement> Afficher(Evenement evenement) {
        return evenementService.Afficher(evenement);
    }

    @DeleteMapping("/delete")
    public String Delete(Evenement evenement) {
        return evenementService.Delete(evenement);
    }

    @PutMapping("/update")
    public Evenement update(Evenement evenement) {
        return evenementService.update(evenement);
    }
}
