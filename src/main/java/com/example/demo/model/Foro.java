package com.example.demo.model;

import java.time.LocalDate;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "foro")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    private LocalDate fechaCreacion;


    @ManyToOne
    @JoinColumn(name = "usuarios_id") 
    private Usuarios usuario;
    public Long getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}

