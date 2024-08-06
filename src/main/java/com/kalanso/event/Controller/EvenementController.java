package com.kalanso.event.Controller;


import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Repository.Evenement_repo;
import com.kalanso.event.Service.Evenement_service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="*")
@Controller
@RestController
@RequestMapping("/gestEvent/event")
@AllArgsConstructor
public class EvenementController {

    private Evenement_service evenementService;
    @Autowired
    private Evenement_repo evenement_repo;

    @PostMapping("/addEvent/{id}")
    private String ajout (@RequestBody Evenement evenement, @PathVariable Integer id){
        return evenementService.Ajout(evenement, id);
    }


    @GetMapping("/afficher")
    private List<Evenement> Afficher() {
        return evenementService.Afficher();
    }

    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable Integer id) {
        return evenementService.Delete(id);
    }

  //  @PutMapping("/update/{id}")
  //  public Evenement update(@PathVariable Evenement evenement) {
    //    return evenementService.update(evenement);
    //}
  @GetMapping("/with-lieux")
  public List<Evenement> getEventsWithLieux() {
      return evenement_repo.findAllWithLieux();
  }
}
