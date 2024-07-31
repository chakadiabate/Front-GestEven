package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class StatutBillet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long Id;

    private String statut;

    @OneToMany(mappedBy = "status")
    private List<Billet> billet;

}