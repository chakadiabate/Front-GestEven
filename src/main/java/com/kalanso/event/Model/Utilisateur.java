package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Getter
@Setter
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

    //@Column(unique = true)
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "role_id")
    //@JsonManagedReference("usersRole")
    private RoleUser role;
    @Column(name = "image", columnDefinition="LONGBLOB")
    @Lob
    private byte[] image;

// Evenement
   // @OneToMany(mappedBy = "utilisateur")
    //@JsonIgnoreProperties("utilisateur, notification")
   // @JsonManagedReference("eventU")
  //  private List<Evenement> evenement;
// Fin Evenement
   // @OneToMany(mappedBy = "utilisateur")
    //@JsonIgnoreProperties("utilisateur")
  //  @JsonManagedReference("bookR")
  //  private List<Reservation> reservation;

   // @OneToMany(mappedBy = "utilisateur")
    //@JsonManagedReference("notifR")
    //private List<Notification> notification;

    //@OneToMany(mappedBy = "utilisateur")
    //@JsonManagedReference("prestaR")
    //private List<Presta> presta;


}
