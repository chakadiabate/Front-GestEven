package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class TypeEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;

//    @JsonBackReference(value = "TypeEvent")
    @JsonIgnore
    @OneToMany(mappedBy = "typeevent")
    private List<Evenement> evenement;

    // Getters, setters, constructeurs
}
