package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CharacterRequest;
import com.example.demo.model.CharacterResponse;
import com.example.demo.service.CharacterService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1")
public class CharacterController {
    @Autowired
    private CharacterService service;

    @PostMapping
    public ResponseEntity<CharacterResponse> create(@RequestBody CharacterRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<CharacterResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
