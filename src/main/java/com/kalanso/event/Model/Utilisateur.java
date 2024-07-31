package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@JsonIgnoreProperties({"evenement", "reservation", "notification"}) // Ignore ces champs lors de la désérialisation
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telephone;

    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleUser role;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnoreProperties("utilisateur")
    private List<Evenement> evenement;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnoreProperties("utilisateur")
    private List<Reservation> reservation;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnoreProperties("utilisateur")
    private List<Notification> notification;

    // Constructor sans argument
    public Utilisateur() {
    }
}
