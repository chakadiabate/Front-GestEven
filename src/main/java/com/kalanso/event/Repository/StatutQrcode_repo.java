package com.kalanso.event.Repository;

import com.kalanso.event.Model.StatutQrcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutQrcode_repo extends JpaRepository<StatutQrcode, Long> {
    StatutQrcode findByStatut(String Statut);
}
