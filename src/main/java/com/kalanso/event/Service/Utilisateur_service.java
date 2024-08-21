package com.kalanso.event.Service;

import com.kalanso.event.Model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface Utilisateur_service {

    Client creerClient(Client client, MultipartFile image) throws IOException;
    Gestionnaire CreerGestionnaire(Gestionnaire gestionnaire);
    Admin createAdmin(Admin admin);
    Organisateur creerOrganisateur(Organisateur organisateur);
    List<Utilisateur> displayAll();
    Utilisateur display(Integer id);
    Utilisateur update(Integer id,Utilisateur utilisateur);
    String delete(Integer id);
    List<Utilisateur> listeParNom(String nom);

    Utilisateur findByEmail(String username);
    Utilisateur updateUtilisateur(Utilisateur utilisateur);
}
