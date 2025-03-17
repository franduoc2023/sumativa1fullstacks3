package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Libros;

public interface LibrosRepository extends JpaRepository<Libros , Long> {
    List<Libros> findByAutor(String autor);

    
}