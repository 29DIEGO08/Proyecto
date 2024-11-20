package com.example.ProyectoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProyectoIntegrador.entities.Usuario;
import com.example.ProyectoIntegrador.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
        if (!existingUsuario.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Usuario updatedUsuario = existingUsuario.get();
        updatedUsuario.setNombre(usuario.getNombre());
        updatedUsuario.setApellido(usuario.getApellido());
        updatedUsuario.setDireccion(usuario.getCorreo());
        updatedUsuario.setContrasena(usuario.getContrasena());

        Usuario savedUsuario = usuarioRepository.save(updatedUsuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
