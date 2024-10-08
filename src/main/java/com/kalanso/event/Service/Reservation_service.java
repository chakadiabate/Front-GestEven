package com.kalanso.event.Service;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.Billet;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Model.Reservation;

import java.io.IOException;
import java.util.List;

public interface Reservation_service {
    Reservation Reserver(Reservation reservation)throws IOException, WriterException;
    Reservation AnnulerReservation(Long id);
    List<Reservation> getAllReservations();
    List<Evenement> getUserReservation(String email);
    Reservation afficher1(Long id);
    List<Reservation> getcategoryByeventId(Long bid, Integer catid);
}
