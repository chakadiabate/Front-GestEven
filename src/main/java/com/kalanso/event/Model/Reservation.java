package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "statut_id")
    @JsonManagedReference
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "id_billet", nullable = false)
    @JsonManagedReference
    private Billet billet;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    @JsonManagedReference
    private Evenement evenement;

    private Date date_res = new Date();



    @ManyToOne
    @JoinColumn(name = "methodePaiement_id")
    @JsonManagedReference
    private MethodePaiement methodePaiement;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonManagedReference
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "categories")
    @JsonManagedReference
    private CategorieBillet category;
}


