package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "derouler")
public class Derouler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lieu_id")
   // @JsonIgnoreProperties("derouler")
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
  //  @JsonIgnoreProperties("derouler")
    private Evenement evenement;



}