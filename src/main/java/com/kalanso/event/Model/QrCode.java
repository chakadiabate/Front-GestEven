package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QrCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameFile;
    private String filepath;

    private String ticketId ;
    private String prix ;

    @ManyToOne
    @JoinColumn(name = "statutQrcode_id")
    @JsonManagedReference
    private StatutQrcode statutQrcode;

    @ManyToOne
    @JoinColumn(name = "categorieBillet_id")
    @JsonManagedReference
    private CategorieBillet category;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    @JsonManagedReference
    private Reservation reservation;

}
