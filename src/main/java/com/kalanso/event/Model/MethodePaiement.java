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
public class MethodePaiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long Id;
    private String methodepaie;

    @OneToMany(mappedBy = "methodePaiement")
    private List<Reservation> reservation;

}