package com.arquitectura.firmas.controllers;

import com.arquitectura.firmas.entities.Usuario;
import com.arquitectura.firmas.repository.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUsuarioService userService;


    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/save")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> save(@RequestBody Usuario user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody Usuario user){
        return ResponseEntity.ok(userService.update(user,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}