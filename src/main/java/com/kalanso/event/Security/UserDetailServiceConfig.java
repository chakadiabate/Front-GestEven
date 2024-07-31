package com.kalanso.event.Security;

import com.kalanso.event.Model.Utilisateur;
import com.kalanso.event.Repository.Utilisateur_repo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserDetailServiceConfig implements UserDetailsService {

    private Utilisateur_repo utilisateur_repo;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateur = utilisateur_repo.findByEmail(email);
        if (utilisateur.isPresent()) {
            Utilisateur user = utilisateur.get();
            return User
                    .withUsername(user.getEmail())
                    .password(user.getMotDePasse()) // Assurez-vous que le mot de passe est encodé
                    .roles(user.getRole().getRole())
                    .build();
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + email);
        }
    }
}
