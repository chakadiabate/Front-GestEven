package com.kalanso.event.Repository;

import com.kalanso.event.Model.StatutTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutQrcode_repo extends JpaRepository<StatutTicket, Long> {
    StatutTicket findByStatut(String Statut);
}
