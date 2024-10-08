package com.kalanso.event.Repository;

import com.kalanso.event.Model.Evenement;
import com.kalanso.event.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Reservation_repo extends JpaRepository<Reservation,Long> {
    @Query("SELECT r.evenement FROM Reservation r where r.utilisateur.email = :email")
    List<Evenement> findUserEmail(@Param("email") String email);


    @Query("SELECT r FROM Reservation r where r.billet.id = :bid and r.category.id = :catid")
    List<Reservation> findcategoryByeventId(@Param("bid") Long bid, @Param("catid")Integer catid);
}
