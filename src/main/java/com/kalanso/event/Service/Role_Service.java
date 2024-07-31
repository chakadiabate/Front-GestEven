package com.kalanso.event.Service;

import com.kalanso.event.Model.RoleUser;
import com.kalanso.event.Repository.RoleUserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
//@NoArgsConstructor
public class Role_Service {
    private RoleUserRepo roleUserRepo;

    public RoleUser AjouterRole(RoleUser Ro){
        return roleUserRepo.save(Ro);
    }

    public List<RoleUser> ListeRole(){
        return roleUserRepo.findAll();
    }

    public String supprimer(long id){
        roleUserRepo.deleteById(id);
        return "Role supprimer avec succès";
    }

    public RoleUser ModifierCategorie(long id, RoleUser roleUser){
        return roleUserRepo.findById(id)
                .map(R->{
                    R.setRole(roleUser.getRole());
                    return roleUserRepo.save(R);
                }).orElseThrow(()-> new RuntimeException("Role non trouvée"));
    }


}
