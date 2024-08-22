package com.kalanso.event.Repository;

import com.kalanso.event.Model.Evenement;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface Evenement_repo extends JpaRepository<Evenement, Integer> {
    @Query("SELECT e FROM Evenement e WHERE e.utilisateur.id = :id")
    Evenement findEventOrg(@Param("id") int id);
   // @Query("SELECT COUNT(e) FROM Evenement e WHERE e.utilisateur.id = :id")
  //  int countEventsByUserId(@Param("id") int id);
     @Query("SELECT e FROM Evenement e WHERE e.datedebut>= CURRENT_DATE ORDER BY e.datedebut ASC LIMIT 1")
    Evenement findNextEvent();
    //  int countEventsByUserId(@Param("id") int id);

    @Query(value = "SELECT e.* " +
            "FROM evenement e " +
            "JOIN reservation r ON e.id = r.evenement_id " +
            "GROUP BY e.id " +
            "ORDER BY COUNT(r.id) DESC " +
            "LIMIT 2", nativeQuery = true)
    List<Evenement> findTop3EvenementsByReservations();

}
