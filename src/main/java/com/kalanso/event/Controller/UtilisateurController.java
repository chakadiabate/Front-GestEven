package com.kalanso.event.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalanso.event.Model.*;
import com.kalanso.event.Service.ContexHolder;
import com.kalanso.event.Service.Utilisateur_service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("gestEvent/user")
@AllArgsConstructor
public class UtilisateurController {

    private Utilisateur_service utilisateurService;
    private ContexHolder contexHolder;
    private ObjectMapper objectMapper;

    @PostMapping("/CreerAdmin")
    public Admin CreerAdmin(@RequestBody Admin admin){
        return utilisateurService.createAdmin(admin);
    }

    @PostMapping("/CreerGest")
    public Gestionnaire CreerGest(@RequestBody Gestionnaire gestionnaire){
        return utilisateurService.CreerGestionnaire(gestionnaire);
    }


    @PostMapping(value = "/CreerClient", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Client> creerClient(@RequestPart("client") String clientJson,
                                              @RequestPart("image") MultipartFile image)

    {
        try {
// Log input data
            System.out.println("Client JSON: " + clientJson);
            System.out.println("Image Original Filename: " + image.getOriginalFilename());
// Convertir la chaîne JSON en objet Evenement
            Client client = objectMapper.readValue(clientJson, Client.class);
// Log the converted object
            System.out.println("Client Object: " + client);
            Client newclient = utilisateurService.creerClient(client, image);
// Log the created event
            System.out.println("Nouvel Evenement: " + newclient);
            return ResponseEntity.status(HttpStatus.CREATED).body(newclient);
        } catch (IOException e) {
// Log the error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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
