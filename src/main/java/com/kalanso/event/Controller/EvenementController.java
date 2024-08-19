package com.kalanso.event.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Repository.Evenement_repo;
import com.kalanso.event.Service.Evenement_service;
import com.kalanso.event.Service.Event_service_impl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*")
@Controller
@RestController
@RequestMapping("/gestEvent/event")
@AllArgsConstructor
public class EvenementController {

    private Evenement_service evenementService;

    //@PostMapping("/addEvent/{id}")
    //private String ajout (@RequestBody Evenement evenement, @PathVariable Integer id){
      //  return evenementService.Ajout(evenement, id);
    //}


    private Event_service_impl eventService;
    private ObjectMapper objectMapper;
    private Evenement_repo evenementRepo;

    @Autowired
    public EvenementController(Event_service_impl eventServiceImpl, ObjectMapper objectMapper, Evenement_repo evenementRepo) {
        this.eventService = eventServiceImpl;
        this.objectMapper = objectMapper;
        this.evenementRepo = evenementRepo;
    }

    @CrossOrigin(origins="http://localhost:4200/")
    @PostMapping(value = "/addEvent", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Evenement> ajouterEvenement(@RequestPart("evenement") String evenementJson,
                                                      @RequestPart("image") MultipartFile image) {
        try {
            // Log input data
            System.out.println("Evenement JSON: " + evenementJson);
            System.out.println("Image Original Filename: " + image.getOriginalFilename());

            // Convertir la chaîne JSON en objet Evenement
            Evenement evenement = objectMapper.readValue(evenementJson, Evenement.class);

            // Log the converted object
            System.out.println("Evenement Object: " + evenement);

            Evenement nouvelEvenement = eventService.ajouterEvenement(evenement, image);

            // Log the created event
            System.out.println("Nouvel Evenement: " + nouvelEvenement);

            return ResponseEntity.status(HttpStatus.CREATED).body(nouvelEvenement);
        } catch (IOException e) {
            // Log the error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }














    //@PostMapping("/addEvent")
    //private String ajout (@RequestBody Evenement evenement){
        //return evenementService.Ajout(evenement);
    //}


    @GetMapping("/afficher")
    private List<Evenement> Afficher() {
        return eventService.Afficher();
    }

    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable Integer id) {
        return eventService.Delete(id);
    }

  @PutMapping("/update/{id}")
  public Evenement update(@PathVariable Integer id, @RequestBody Evenement evenement) {
    return eventService.update(id, evenement);
    }
    @GetMapping("/EventParOrg/{id}")
    private Evenement EventOrg(@PathVariable Integer id) {
        return evenementService.EventProOrg(id);
    }

    @GetMapping("/next_event")
    public Evenement nextEvent() {
         return eventService.getNextEvent();
    }
    @GetMapping("EventById/{id}")
    public ResponseEntity<Evenement> getEvenementById(@PathVariable Integer id) {
        Evenement evenement = eventService.getEvenementById(id);
        if (evenement != null) {
            return ResponseEntity.ok(evenement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
