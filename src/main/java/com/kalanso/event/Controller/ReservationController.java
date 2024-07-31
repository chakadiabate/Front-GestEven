package com.kalanso.event.Controller;

import com.kalanso.event.Model.Reservation;
import com.kalanso.event.Service.Reservation_service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/gestEvent/event/Reservation")
@AllArgsConstructor
public class ReservationController {


    private Reservation_service reservationService;

    @PostMapping("/Reserver")
    public String Reserver(@RequestBody Reservation reservation) {
        reservationService.Reserver(reservation);
        return "Reservation Effectué avec succès !!!";
    }
    @GetMapping("/ListReservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/AnnulerReservation")
    public String CancelReservation(Reservation reservation, String Statut) {
        reservationService.AnnulerReservation(reservation, Statut);
        return "Reservation annulée avec succès!!!";
    }
}
