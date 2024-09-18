package com.vedoble.web.repository;

import com.vedoble.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuaRepository extends JpaRepository<User, String> {
    UserDetails findByUsualogin(String usualogin);
}
