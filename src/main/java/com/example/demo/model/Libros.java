package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name ="titulo")
    private String titulo;
    @Column(name ="anio")
    private int año;
    @Column(name ="autor")
    private String autor;
    @Column(name ="genero")
    private String genero;


    public long getId(){
    return id;

    }
    public String getTitulo(){
        return titulo;
    
        }

        public int getAño(){
            return año;
        
            }

            
            public String getAutor(){
                return autor;
            
                }
                public String getGenero(){
                    return genero;
                
                    }

    public void setId(Long id){
    this.id = id;}




    public void setITitulo(String titulo){
    this.titulo = titulo;
    
    
    }

    public void setAño(int año){
        this.año = año;
        
        
        }

        public void setIAutor(String autor){
            this.autor = autor;
            
            
            }
            public void setIGenero(String genero){
                this.genero = genero;
                
                
                }

}
