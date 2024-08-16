package com.kalanso.event.Model;
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
    @OneToMany(mappedBy = "billet")
    @JsonIgnoreProperties("billet")
    private List<Reservation> reservation;

    private int quantiteDisponible;
     private int prix;
    private LocalDate dateDebutVente;
    private LocalDate dateFinVente;
    private String description;
    private String lienQrCode;

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
