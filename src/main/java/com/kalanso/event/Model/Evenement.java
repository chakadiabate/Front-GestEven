package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;
import java.util.TimeZone;

@Entity
@Data
@NoArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private Date date;
    private Date datedebut ;
    private Date datefin ;
    private LocalTime heure ;
    private String description;
    //private Integer nombrePlace;

    private String lieu;

    @ManyToOne
    @JoinColumn(name = "typeEvent_id")
    @JsonIgnoreProperties("evenement")
    private TypeEvent typeevent;
// User
    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonIgnoreProperties({"evenement", "reservation", "notification", "presta"})
    private Utilisateur utilisateur;
// Fin User
    @ManyToOne
    @JoinColumn(name = "categories")
    @JsonIgnoreProperties("evenement")
    private CategorieEvent category;

    @OneToMany(mappedBy = "evenement")
    @JsonIgnoreProperties({"utilisateur", "evenement"})
    private List<Notification> notification;

    @JsonIgnore
    @OneToMany(mappedBy = "evenement")
    private List<Derouler> derouler;

    @OneToMany(mappedBy = "evenement")
    @JsonIgnoreProperties({"utilisateur", "evenement"})

    private List<Reservation> reservation;
    @JsonIgnore
    @OneToMany(mappedBy = "evenement")
    private List<Billet> billets;


    // Getters, setters, constructeurs
}