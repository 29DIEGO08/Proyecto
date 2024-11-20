package com.example.ProyectoIntegrador.entities;

import jakarta.persistence.*;

@Entity
public class Administrativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int clave;

    public Administrativo(Long id, String nombre, int clave) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
    }

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

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

}