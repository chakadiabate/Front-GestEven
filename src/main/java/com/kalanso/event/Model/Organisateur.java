package com.kalanso.event.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Organisateur extends Utilisateur{
    @OneToMany(mappedBy = "organisateur")
    private List<Presta> presta;
}
