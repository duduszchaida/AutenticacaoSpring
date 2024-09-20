package com.vedoble.web.repository;

import com.vedoble.web.entity.Usua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


public interface UsuaRepository extends JpaRepository<Usua, String> {
    UserDetails findByUsualogin(String usualogin);
}
