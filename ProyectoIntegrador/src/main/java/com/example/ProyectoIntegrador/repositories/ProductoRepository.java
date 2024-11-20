package com.example.ProyectoIntegrador.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoIntegrador.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}