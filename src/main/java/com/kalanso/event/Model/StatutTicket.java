package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class StatutTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statut;

    //@OneToMany(mappedBy = "statutQrcode")
   // @JsonManagedReference("satatutQr")
    //private List<QrCode> qrcode;
}
