package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;
import java.util.TimeZone;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private Date date;
    @JsonFormat(pattern="yyyy-MM-dd")
    private java.sql.Date datedebut ;

    @JsonFormat(pattern="yyyy-MM-dd")
    private java.sql.Date datefin ;

    @JsonFormat(pattern="HH:mm")
    private LocalTime heure ;
    private String description;
    //private Integer nombrePlace;

    @Column(name = "image", columnDefinition="LONGBLOB")
    @Lob
    private byte[] image;
    //private Integer nombrePlace;

    private String lieu;

    @ManyToOne
    @JoinColumn(name = "typeEvent_id")
    @JsonIgnoreProperties("evenement")
    private TypeEvent typeevent;
// User
    @ManyToOne
    @JoinColumn(name = "users_id")
    //@JsonIgnoreProperties({"evenement", "reservation", "notification", "presta"})
    @JsonBackReference("eventU")
    private Utilisateur utilisateur;
// Fin User
    @ManyToOne
    @JoinColumn(name = "categories")
    @JsonIgnoreProperties("evenement")
    private CategorieEvent category;

    @OneToMany(mappedBy = "evenement")
    @JsonIgnoreProperties({"utilisateur", "evenement"})
    private List<Notification> notification;

    @JsonIgnore
    @OneToMany(mappedBy = "evenement")
    private List<Derouler> derouler;

    @OneToMany(mappedBy = "evenement")
    @JsonManagedReference("eventR")
    private List<Reservation> reservation;

    @JsonIgnore
    @OneToMany(mappedBy = "evenement")
    private List<Billet> billets;


    @Configuration
    public class JacksonConfig {
        @Bean
        public ObjectMapper objectMapper() {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper;
        }
    }
}