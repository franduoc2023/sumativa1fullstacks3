package com.example.demo.dto;

import java.time.LocalDate;

public class ForoDto {
    private Long id;
    private String comentario;
    private LocalDate fechaCreacion;
    private String nombreUsarios;

    public Long getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getNombreUsuario() {
        return nombreUsarios;
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

    public void setNombreUsuario(String nombreUsarios) {
        this.nombreUsarios = nombreUsarios;
    }
}

