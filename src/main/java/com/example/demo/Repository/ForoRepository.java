package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Foro;
import com.example.demo.model.Usuarios;

public interface ForoRepository extends JpaRepository<Foro, Long> {
    List<Foro> findByUsuario(Usuarios usuario);
}
