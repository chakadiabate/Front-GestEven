package com.kalanso.event.Repository;

import com.kalanso.event.Model.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Lieu_repo extends JpaRepository<Lieu, Integer> {
    Lieu findByNom(String nom);

}
