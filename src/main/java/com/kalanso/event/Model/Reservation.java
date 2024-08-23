package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tel;

    @ManyToOne
    @JoinColumn(name = "statut_id")
    //@JsonBackReference("StatutR")
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "id_billet", nullable = false)
  //  @JsonBackReference("billetR")
    private Billet billet;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    //@JsonBackReference("eventR")
    private Evenement evenement;

    private Date date_res = new Date();

    //@OneToMany(mappedBy = "reservation")
    //@JsonManagedReference("bookQr")
    //private List<QrCode> qrCode;


    @ManyToOne
    @JoinColumn(name = "methodePaiement_id")
    //@JsonBackReference("methodePaieR")
    private MethodePaiement methodePaiement;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    //@JsonBackReference("bookR")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "categories")
    //@JsonBackReference("categoryR")
    private CategorieBillet category;
}


