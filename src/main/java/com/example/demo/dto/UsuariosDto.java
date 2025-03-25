package com.example.demo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class UsuariosDto {

    private Long id;
    @NotNull
    private String nombre;
    private String apellido;
    @NotNull
    private String password;
    @NotNull
    private String nombreUsuario;
    private LocalDate fechaNacimiento;
    @NotNull
    private String email;
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getEmail() {
        return email;
    }
     public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

     public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

     public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
}

