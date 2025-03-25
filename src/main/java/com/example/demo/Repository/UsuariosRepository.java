package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Usuarios;
 
public interface UsuariosRepository extends JpaRepository<Usuarios , Long>{
    Optional<Usuarios>findByEmail(String email);
      
}    