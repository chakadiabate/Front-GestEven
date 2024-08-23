package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Taches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    @JsonIgnoreProperties("taches")
    private PriorityTask priority;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Evenement evenement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;



}
