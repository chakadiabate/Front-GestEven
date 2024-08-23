package com.kalanso.event.Repository;

import com.kalanso.event.Model.CategorieBillet;
import com.kalanso.event.Model.CategorieEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieBilletRepo extends JpaRepository<CategorieBillet, Long> {
    CategorieBillet findByCategory( String Category);

    /*@Query("select c from CategorieBillet c where c.billets[].evenement.id = :id")
    List<CategorieBillet> findCategories(@Param("") Integer id);*/

}
