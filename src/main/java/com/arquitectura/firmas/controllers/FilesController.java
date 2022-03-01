package com.arquitectura.firmas.controllers;

import com.arquitectura.firmas.entities.Files;
import com.arquitectura.firmas.repository.services.IFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FilesController {
    @Autowired
    private IFilesService fileService;


    @PostMapping("/upload")
    public ResponseEntity<?> save(@RequestBody Files file){
        return ResponseEntity.ok( fileService.save(file));
    }
}
