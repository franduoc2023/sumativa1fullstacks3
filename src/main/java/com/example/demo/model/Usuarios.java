package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "password")
    private String password;
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "email")
    private String email;
     public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getEmail() {
        return email;
    }





public void setEmail(String email){
    this.email = email;
}


    
     public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}