package com.kalanso.event.Controller;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Model.Reservation;
import com.kalanso.event.Service.Reservation_service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/gestEvent/reservation")
@AllArgsConstructor
public class ReservationController {


    private Reservation_service reservationService;

    @PostMapping("/reserver")
    public String Reserver(@RequestBody Reservation reservation) throws IOException, WriterException {
        reservationService.Reserver(reservation);
        return "Reservation Effectué avec succès !!!";
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/ListReservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/userReservation")
    public List<Evenement> getUserReservation(@RequestParam String email){
        return reservationService.getUserReservation(email);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/AfficherReservation/{id}")
    public Reservation Afficher1(@PathVariable Long id) {
        return reservationService.afficher1(id);
    }

    @PatchMapping("/AnnulerReservation")
    public Reservation CancelReservation(@RequestParam Long id) {
        return reservationService.AnnulerReservation(id);
    }


}
