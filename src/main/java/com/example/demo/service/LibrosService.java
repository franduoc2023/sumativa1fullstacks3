package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Libros;

public interface LibrosService {
List<Libros> getAllLibros();
Optional<Libros>getLibrosById(Long id);

List <Libros>getLibrosAutor(String autor);

//metodos
Libros createLibros (Libros libros);
Libros updateLibros (Long id, Libros Libros);
    void deleteLibros (Long id);
}
