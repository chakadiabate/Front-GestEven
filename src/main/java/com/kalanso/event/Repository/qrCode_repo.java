package com.kalanso.event.Repository;

import com.kalanso.event.Model.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface qrCode_repo extends JpaRepository<QrCode, Long> {
    //Optional<QrCode> findByNameFile(String nameFile);
    QrCode findByNameFile(String nameFile);
    @Query("SELECT q FROM QrCode q where q.reservation.evenement.id = :event_id and q.reservation.utilisateur.email = :email")
    List<QrCode> findTickets(@Param("event_id") Long id, @Param("email") String email);


}
