package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CategorieBillet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;

    //@OneToMany(mappedBy = "category")
    //@JsonManagedReference("categoryR")
     //List<Reservation> reservation;

    //@OneToMany(mappedBy = "category")
    //@JsonManagedReference("catQr")
    //private List<QrCode> qrCode;

   // @OneToMany(mappedBy = "categoryBillet")
    //@JsonIgnoreProperties("categoryBillet")
    //private List<Billet> billets;

    //private String description;
    // Getters, setters, constructeurs
}
