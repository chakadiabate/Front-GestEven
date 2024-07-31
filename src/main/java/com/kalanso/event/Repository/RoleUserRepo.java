package com.kalanso.event.Repository;

import com.kalanso.event.Model.RoleUser;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RoleUserRepo extends JpaRepository<RoleUser, Long> {
    RoleUser findByRole(String role);
}