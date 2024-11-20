package com.example.ProyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProyectoIntegrador.entities.Administrativo;
import com.example.ProyectoIntegrador.repositories.AdministrativoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/administrativo")
public class AdministrativoController {

    @Autowired
    private AdministrativoRepository administrativoRepository;

    @GetMapping
    public ResponseEntity<List<Administrativo>> getAllAdministrativos() {
        List<Administrativo> administrativos = administrativoRepository.findAll();
        return new ResponseEntity<>(administrativos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrativo> getAdministrativoById(@PathVariable Long id) {
        Administrativo administrativo = administrativoRepository.findById(id).orElse(null);
        if (administrativo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(administrativo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Administrativo> createAdministrativo(@RequestBody Administrativo administrativo) {
        Administrativo savedAdministrativo = administrativoRepository.save(administrativo);
        return new ResponseEntity<>(savedAdministrativo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrativo> updateAdministrativo(@PathVariable Long id, @RequestBody Administrativo administrativo) {
        Administrativo existingAdministrativo = administrativoRepository.findById(id).orElse(null);
        if (existingAdministrativo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingAdministrativo.setNombre(administrativo.getNombre());
        existingAdministrativo.setClave(administrativo.getClave());
        Administrativo updatedAdministrativo = administrativoRepository.save(existingAdministrativo);
        return new ResponseEntity<>(updatedAdministrativo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAdministrativo(@PathVariable Long id) {
        administrativoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
