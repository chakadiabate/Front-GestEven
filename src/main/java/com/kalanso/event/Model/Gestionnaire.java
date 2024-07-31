package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Gestionnaire extends Utilisateur{

    @OneToMany(mappedBy = "gestionnaire")
    private List<Prestateur> prestateur;
    @OneToMany(mappedBy = "role")
    private List<RoleUser> utilisateur;
}
