package com.kalanso.event.Service;

import com.kalanso.event.Model.CategorieEvent;
import com.kalanso.event.Repository.CategorieEventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieEvent_service {

    private CategorieEventRepo categorieEventRepo;

    public CategorieEvent AjouterCategorie(CategorieEvent Ca){
        return categorieEventRepo.save(Ca);
    }

    public List<CategorieEvent> ListeCategorie(){
        return categorieEventRepo.findAll();
    }

    public String supprimer(long id){
        categorieEventRepo.deleteById(id);
        return "Categorie supprimer avec succès";
    }

    public CategorieEvent ModifierCategorie(long id, CategorieEvent Categorie){
        return categorieEventRepo.findById(id)
                .map(Cat->{
                    Cat.setCategory(Categorie.getCategory());
                    return categorieEventRepo.save(Cat);
                }).orElseThrow(()-> new RuntimeException("Categorie non trouvée"));
    }

}
