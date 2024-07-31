package com.kalanso.event.Service;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Model.Notification;
import com.kalanso.event.Model.Reservation;
import com.kalanso.event.Model.StatutReservation;
import com.kalanso.event.Repository.Evenement_repo;
import com.kalanso.event.Repository.Reservation_repo;
import com.kalanso.event.Repository.StatutReservationRepo;
import com.kalanso.event.Service.Notification.Notif_service_Reservation_impl;
import com.lowagie.text.DocumentException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.css.style.derived.StringValue;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Reservation_serviceImpl implements Reservation_service {
    @Autowired
    private final Evenement_repo evenement_repo;
    @Autowired
    private Reservation_repo reservationRepo;
    @Autowired
    private Notif_service_Reservation_impl notifServiceReservationImpl;
    @Autowired
    private StatutReservationRepo statutRepo;
    @Autowired
    private ContexHolder contexHolder;

    @Override
    public Reservation Reserver(Reservation reservation) {
        StatutReservation statutReservation = statutRepo.findByStatut("ACTIVE");
        //reservation.setUtilisateur(contexHolder.utilisateur());
        reservation.setDate_res(new Date());
        reservation.setStatut(statutReservation);
        //Integer evenement_id = reservation.getEvenement().getId();

        reservationRepo.save(reservation);

       /* System.out.println(reservation.getEvenement());
        evenement_repo.findById(reservation.getEvenement().getId()).map(ev->{
            Integer typeevent_id = ev.getTypeevent().getId();
            System.out.println(typeevent_id);
            Notification notification = new Notification();
            notification.setDest_email(contexHolder.utilisateur().getEmail());
            notification.setSujet("Reservation de ticket");
            notification.setEvenement(ev);
            try {
                notifServiceReservationImpl.sendMailWelcome(notification);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (DocumentException e) {
                throw new RuntimeException(e);
            } catch (WriterException e) {
                throw new RuntimeException(e);
            }
            if(typeevent_id == 1) {
                System.out.println(typeevent_id);
                notification.setEvenement(ev);
                try {
                    notifServiceReservationImpl.SendMailTicket(notification);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (DocumentException e) {
                    throw new RuntimeException(e);
                } catch (WriterException e) {
                    throw new RuntimeException(e);
                }
            }
            return ev;
        });*/

        return reservation;
    }

    @Override
    public Reservation AnnulerReservation(Reservation reservation, String Statut) {
        StatutReservation statutReservation = statutRepo.findByStatut(Statut);
        reservation.setStatut(statutReservation);
        return reservationRepo.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }
}
