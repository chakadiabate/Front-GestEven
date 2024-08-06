package com.kalanso.event.Repository;

import com.kalanso.event.Model.Evenement;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Evenement_repo extends JpaRepository<Evenement, Integer> {
    @Query("SELECT e FROM Evenement e JOIN FETCH e.derouler d JOIN FETCH d.lieu")
    List<Evenement> findAllWithLieux();
}
