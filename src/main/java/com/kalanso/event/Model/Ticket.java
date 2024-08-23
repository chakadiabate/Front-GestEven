package com.kalanso.event.Model;

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
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameFile;
    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] file;

    private String ticketId ;
    private String prix ;

    @ManyToOne
    @JoinColumn(name = "statutQrcode_id")
    private StatutQrcode statutQrcode;

    @ManyToOne
    @JoinColumn(name = "categorieBillet_id")
    private CategorieBillet category;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
