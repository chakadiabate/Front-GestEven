package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference("StatutR")
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "id_billet", nullable = true)
    @JsonBackReference("billetR")
    private Billet billet;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    @JsonBackReference("eventR")
    private Evenement evenement;

    private Date date_res = new Date();



    @ManyToOne
    @JoinColumn(name = "methodePaiement_id")
    @JsonBackReference("methodePaieR")
    private MethodePaiement methodePaiement;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonBackReference("UserR")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "categories")
    @JsonBackReference("categoryR")
    private CategorieBillet category;
}


