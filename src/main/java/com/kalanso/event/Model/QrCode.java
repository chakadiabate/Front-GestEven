package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference("satatutQr")
    private StatutQrcode statutQrcode;

    @ManyToOne
    @JoinColumn(name = "categorieBillet_id")
    @JsonBackReference("catQr")
    private CategorieBillet category;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    @JsonBackReference("bookQr")
    private Reservation reservation;

}
