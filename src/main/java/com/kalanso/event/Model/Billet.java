package com.kalanso.event.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToMany(mappedBy = "billet")
    //@JsonBackReference
    //private List<Reservation> reservation;

    private int quantiteDisponible;
    private int prix;
    private LocalDate date;
    private String description;
    private int nbreBilletParPersonne;

     @ManyToOne
     @JoinColumn(name = "categorieBillet_id")
     private CategorieBillet categoryBillet;

     @ManyToOne
     @JoinColumn(name = "event_id")
     private Evenement evenement;

    @ManyToOne
    @JoinColumn(name = "Statuts")
    private StatutBillet status;



}
