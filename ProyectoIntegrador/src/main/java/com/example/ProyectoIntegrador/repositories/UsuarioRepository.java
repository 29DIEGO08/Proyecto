package com.example.ProyectoIntegrador.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoIntegrador.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}