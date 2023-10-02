package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CharacterRequest;
import com.example.demo.model.CharacterResponse;

public interface CharacterService {
    
    CharacterResponse create(CharacterRequest request);

    List<CharacterResponse> getAll();
}

