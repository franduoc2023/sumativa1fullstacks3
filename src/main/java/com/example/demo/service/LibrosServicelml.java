package com.example.demo.service;
 import com.example.demo.Repository.LibrosRepository;
import com.example.demo.model.Libros;
 import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrosServicelml implements LibrosService {

    @Autowired
    private LibrosRepository librosRepository;



    @Override
    public List<Libros> getAllLibros(){
        return librosRepository.findAll();
    
    }
    @Override
    public Optional<Libros> getLibrosById(Long id){
    return librosRepository.findById(id);
    }

    @Override 
    public List<Libros> getLibrosAutor(String autor){
        return librosRepository.findByAutor(autor);

    }

    @Override
    public Libros createLibros(Libros libros){
        return librosRepository.save(libros);


    }
    @Override
    public Libros updateLibros(Long id , Libros libros){
        if(librosRepository.existsById(id)){
            libros.setId(id);
            return librosRepository.save(libros);
        } else {
            return null;
        }

        }

    

    @Override 
    public void deleteLibros(Long id){
        librosRepository.deleteById(id);
    }



 
}


//overide se usa aqui por que estamos usando el metodo extendido hacia el repository 