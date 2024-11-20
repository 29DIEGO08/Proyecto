package com.example.ProyectoIntegrador.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProyectoIntegrador.entities.Administrativo;

public interface AdministrativoRepository extends JpaRepository<Administrativo, Long> {

}