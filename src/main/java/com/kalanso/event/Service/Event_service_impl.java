package com.kalanso.event.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.*;
import com.kalanso.event.Repository.*;
import com.kalanso.event.Service.Notification.*;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
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


    public Evenement ajouterEvenement(Evenement evenement, MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) {
            evenement.setImage(image.getBytes());
        }
        return evenement_repo.save(evenement);
    }





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

    //@Override
    public List<Evenement> Afficher() {
        return evenement_repo.findAll();
    }

    //@Override
    public String Delete(Integer id) {
        evenement_repo.deleteById(id);
        return "Event deleted with succes";
    }

    //@Override
    public Evenement update(Integer id, Evenement evenement) {
        return evenement_repo.findById(id)
                .map(p->{
                    p.setNom(evenement.getNom());
                    p.setDescription(evenement.getDescription());
                    p.setCategory(evenement.getCategory());
                    p.setDate(evenement.getDate());
                    p.setHeure(evenement.getHeure());
                    p.setDatedebut(evenement.getDatedebut());
                    p.setDatefin(evenement.getDatefin());
                    p.setLieu(evenement.getLieu());
                    p.setTypeevent(evenement.getTypeevent());
                    //p.setDerouler(evenement.getDerouler());
                    //p.setNombrePlace(evenement.getNombrePlace());
                    return evenement_repo.save(p);
                }).orElseThrow(()-> new RuntimeException("The event couldn't be deleted "));
    }

    @Override
    public Evenement EventProOrg(Integer id) {
        return evenement_repo.findEventOrg(id);
    }
    @Override
    public Evenement getNextEvent() {
        return evenement_repo.findNextEvent();
    }
    @Override
    public Evenement getEvenementById(Integer id) {
        return evenement_repo.findById(id).orElse(null);
    }

    public List<Evenement> getTop3Evenements() {
        return evenement_repo.findTop3EvenementsByReservations();
    }



}
