package com.kalanso.event.Controller;

import com.google.zxing.WriterException;
import com.kalanso.event.Model.Billet;
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


    /*@PostMapping("/reserver")
    public ResponseEntity<Reservation> Reserver(@RequestPart("reservation") String reservationJson) throws IOException, WriterException {

        Reservation reservation = objectMapper.readValue(reservationJson, Reservation.class);
        System.out.println("Evenement Object: " + reservation);
        Reservation nouvelReservation = reservationService.Reserver(reservation);
        System.out.println("Nouvel Evenement: " + nouvelReservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelReservation);

    }*/


    @GetMapping("/ListReservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/ListReservationBycat/{bid}/{catid}")
    public List<Reservation> getcatById(@PathVariable Long bid, @PathVariable Integer catid) {
        return reservationService.getcategoryByeventId(bid ,catid);
    }

    @GetMapping("/ListReservationBycat/{bid}/{catid}/{userId}")
    public List<Reservation> getcatByIduser(@PathVariable Long bid, @PathVariable Integer catid, @PathVariable Integer userId) {
        return reservationService.reservationbilcatuser(bid ,catid, userId);
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

    /*@PatchMapping("/AnnulerReservation")
    public Reservation CancelReservation(@RequestParam Long id) {
        return reservationService.AnnulerReservation(id);
    }*/


}
