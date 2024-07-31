package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private java.sql.Date date;
    private java.sql.Date datedebut ;
    private Date datefin ;
    private String description;
    private String lieu;
//    @JsonBackReference

    @ManyToOne
    @JoinColumn(name = "typeEvent_id")
    private TypeEvent typeevent;

    //@ManyToOne
    //@JoinColumn(name = "users_id")
    //private Utilisateur utilisateur;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categories")
    private CategorieEvent category;

    @OneToMany(mappedBy = "evenement")
    private List<Notification> notification;

    @OneToMany(mappedBy = "evenement")
    private List<Derouler> derouler;

    @OneToMany(mappedBy = "evenement")
    private List<Reservation> reservation;

    // Getters, setters, constructeurs
}