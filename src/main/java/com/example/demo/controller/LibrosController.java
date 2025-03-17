package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.service.LibrosService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Libros;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 

@RestController
@RequestMapping("/libros")
public class LibrosController {
    @Autowired
    private  LibrosService librosService;

 
@GetMapping
public List<Libros> getAllLibros(){
return librosService.getAllLibros();


}



@GetMapping("/{id}")
public Optional<Libros> getLibrosById(@PathVariable Long id)  {
return librosService.getLibrosById(id);

}


@PostMapping 
public Libros creaLibros(@RequestBody Libros libros ){
return librosService.createLibros(libros);

}

 @PutMapping("/{id}")
 public Libros updateLibros(@PathVariable Long id , @RequestBody Libros libros){
return librosService.updateLibros(id, libros);

 }

@DeleteMapping("/{id}")
public void deleteLibros(@PathVariable Long id){
librosService.deleteLibros(id);

}


    
}
