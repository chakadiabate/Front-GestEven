package com.kalanso.event.Service;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.*;
import com.kalanso.event.Repository.*;
import com.kalanso.event.Service.Notification.*;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Event_service_impl implements Evenement_service {

    private Lieu_repo lieu_repo;
    private Evenement_repo evenement_repo;
    private Notif_service_Evenement_impl notifServiceEvenementImpl;
    private Utilisateur_repo utilisateur_repo;
    private RoleUserRepo roleUserRepo;
    private Derouler_repo derouler_repo;
    @Override
    public String Ajout(Evenement evenement) {
        evenement_repo.save(evenement);
        RoleUser roleUser = roleUserRepo.findByRole("ADMIN");
        List<Utilisateur> Utilisateurs = utilisateur_repo.findByRole(roleUser);
        Derouler derouler = new Derouler();
        derouler.setEvenement(evenement);
        derouler.setLieu(lieu_repo.findByNom(evenement.getLieu()));
        derouler_repo.save(derouler);

        Utilisateurs.forEach(p->{
            Notification notification = new Notification();
            notification.setEvenement(evenement);
            notification.setSujet("Ajout d'évènement");
            notification.setDest_email(p.getEmail());

            try {
                notifServiceEvenementImpl.SendMail(notification);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            } catch (WriterException e) {
                throw new RuntimeException(e);
            }
        });
        return "Evenement ajouter avec success";
    }
//Recuperer un evenement par son id
    @Override
    public Optional<Evenement> Event(Integer id) {
        return evenement_repo.findById(id);
    }

    @Override
    public List<Evenement> Afficher(Evenement evenement) {
        return evenement_repo.findAll();
    }

    @Override
    public String Delete(Evenement evenement) {
        return "";
    }

    @Override
    public Evenement update(Evenement evenement) {
        return null;
    }
}
