package com.kalanso.event.Controller;

import com.kalanso.event.Model.*;
import com.kalanso.event.Service.ContexHolder;
import com.kalanso.event.Service.Utilisateur_service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("gestEvent/user")
@AllArgsConstructor
public class UtilisateurController {

    private Utilisateur_service utilisateurService;
    private ContexHolder contexHolder;

    @PostMapping("/CreerAdmin")
    public Admin CreerAdmin(@RequestBody Admin admin){
        return utilisateurService.createAdmin(admin);
    }

    @PostMapping("/CreerGest")
    public Gestionnaire CreerGest(@RequestBody Gestionnaire gestionnaire){
        return utilisateurService.CreerGestionnaire(gestionnaire);
    }

    @PostMapping("/CreerClient")
    public Client creerClient(@RequestBody Client client){
        return utilisateurService.creerClient(client);
    }

    @PostMapping("/CreerOrga")
    public Organisateur creerClient(@RequestBody Organisateur organisateur){
        return utilisateurService.creerOrganisateur(organisateur);
    }

    @GetMapping("/Users")
    List<Utilisateur> displayUsers(){
        return utilisateurService.displayAll();
    }

    @GetMapping("/User/{id}")
    Utilisateur displayUser(@PathVariable Integer id){
        return utilisateurService.display(id);
    }

    @GetMapping("/TriParNom")
    List<Utilisateur> TrierByname(String nom){
        return utilisateurService.listeParNom(nom);
    }


    @PutMapping("/UpdateUser/{id}")
    public Utilisateur UpdateUser(@PathVariable Integer id, @RequestBody Utilisateur utilisateur){
        return utilisateurService.update(id, utilisateur);
    }

    @DeleteMapping("/deleteUser/{id}")
    public  String supprimerAdmin( @PathVariable Integer id){
        return utilisateurService.delete(id);
    }

    @GetMapping("/currentSession")
    public Utilisateur getCurrentUser() {
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && ((org.springframework.security.core.Authentication) authentication).getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            return utilisateurService.findByEmail(user.getPassword()); // Assurez-vous que cette méthode existe dans votre service
        }
        return null; // ou une réponse appropriée en cas d'absence d'utilisateur connecté*/
        return contexHolder.utilisateur();
    }


    @PutMapping("/updateProfile")
    public ResponseEntity<Utilisateur> updateProfile(@RequestBody Utilisateur updatedUser) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            Utilisateur currentUser = utilisateurService.findByEmail(user.getUsername());

            if (currentUser != null) {
                currentUser.setNom(updatedUser.getNom());
                currentUser.setPrenom(updatedUser.getPrenom());
                currentUser.setEmail(updatedUser.getEmail());
                currentUser.setTelephone(updatedUser.getTelephone());
                // Ajoutez d'autres champs à mettre à jour si nécessaire

                Utilisateur savedUser = utilisateurService.updateUtilisateur(currentUser); // Assurez-vous que cette méthode existe
                return ResponseEntity.ok(savedUser);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // ou une autre réponse appropriée
    }


}
