package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor
@Data
@Table(name = "presta")
public class Presta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_presta;
    private String email;
    private Integer tel;
    private String profile;
    @OneToMany(mappedBy = "presta")
    private List<Equipement> equipement;

    @ManyToOne
    @JoinColumn(name = "organisateur_id")
    private Organisateur organisateur;

    @ManyToOne
    @JoinColumn(name = "rolePrestateur_id")
    private RolePrestateur rolePrestateur;


}
