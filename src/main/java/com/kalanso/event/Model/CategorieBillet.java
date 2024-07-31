package com.kalanso.event.Model;

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

    @OneToMany(mappedBy = "category")
    private List<Reservation> reservation;
    //private String description;
    // Getters, setters, constructeurs
}
