package com.kalanso.event.Repository;

import com.kalanso.event.Model.Evenement;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Evenement_repo extends JpaRepository<Evenement, Integer> {
    @Query("SELECT e FROM Evenement e WHERE e.utilisateur.id = :id")
    Evenement findEventOrg(@Param("id") int id);
   // @Query("SELECT COUNT(e) FROM Evenement e WHERE e.utilisateur.id = :id")
  //  int countEventsByUserId(@Param("id") int id);

}
