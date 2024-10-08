package com.kalanso.event.Repository;


import com.kalanso.event.Model.Billet;
import com.kalanso.event.Model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Billet_repository extends JpaRepository<Billet, Long> {
    @Query("SELECT b.prix FROM Billet b WHERE b.evenement.id = :id")
   List<Integer> findPrixBilletById(@Param("id") Long id);

    @Query("SELECT b FROM Billet b WHERE b.evenement.id = :id")
    List<Billet> findcategoryByeventId(@Param("id") Long id);

}
