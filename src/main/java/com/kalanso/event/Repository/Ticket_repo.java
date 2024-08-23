package com.kalanso.event.Repository;

import com.kalanso.event.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Ticket_repo extends JpaRepository<Ticket, Long> {
    //Optional<QrCode> findByNameFile(String nameFile);
    Ticket findByNameFile(String nameFile);
    @Query("SELECT q FROM Ticket q where q.reservation.evenement.id = :event_id and q.reservation.utilisateur.email = :email")
    List<Ticket> findTickets(@Param("event_id") Long id, @Param("email") String email);


}
