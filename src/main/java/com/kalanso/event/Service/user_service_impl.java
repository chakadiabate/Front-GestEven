package com.kalanso.event.Service;


import com.kalanso.event.Model.*;
import com.kalanso.event.Repository.Utilisateur_repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class user_service_impl implements Utilisateur_service {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private Utilisateur_repo utilisateurRepo;

    @Override
    public Client creerClient(Client client) {
        client.setMotDePasse(passwordEncoder.encode(client.getMotDePasse()));
        return utilisateurRepo.save(client);
    }

    @Override
    public Gestionnaire CreerGestionnaire(Gestionnaire gestionnaire) {
        gestionnaire.setMotDePasse(passwordEncoder.encode(gestionnaire.getMotDePasse()));
        return utilisateurRepo.save(gestionnaire);
    }

    @Override
    public Admin createAdmin(Admin admin) {
        admin.setMotDePasse(passwordEncoder.encode(admin.getMotDePasse()));
        return utilisateurRepo.save(admin);
    }

    @Override
    public Organisateur creerOrganisateur(Organisateur organisateur) {
        organisateur.setMotDePasse(passwordEncoder.encode(organisateur.getMotDePasse()));
        return utilisateurRepo.save(organisateur);
    }

    @Override
    public List<Utilisateur> displayAll() {
        return utilisateurRepo.findAll();
    }

    @Override
    public Utilisateur display(Integer id) {
        return utilisateurRepo.findById(id).get();
    }

    //modifier profil
    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur); // Assurez-vous que votre repository étend JpaRepository
    }

    @Override
    public Utilisateur update(Integer id, Utilisateur utilisateur) {
        return utilisateurRepo.findById(id)
                .map(p->{
                    p.setNom(utilisateur.getNom());
                    p.setPrenom(utilisateur.getPrenom());
                    p.setEmail(utilisateur.getEmail());
                    p.setTelephone(utilisateur.getTelephone());
                    p.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
                    p.setRole(utilisateur.getRole());
                    return utilisateurRepo.save(p);
        }).orElseThrow(()-> new RuntimeException("Erreur lors de la mise à jour"));
    }

    @Override
    public String delete(Integer id) {
        utilisateurRepo.deleteById(id);
        return "Utilisateur éffacé avec succès";
    }

    @Override
    public List<Utilisateur> listeParNom(String nom) {
        return utilisateurRepo.findByNom(nom);
    }

    @Override
    public Utilisateur findByEmail(String email) {
        return utilisateurRepo.findByEmail(email).orElse(null);
    }
}
