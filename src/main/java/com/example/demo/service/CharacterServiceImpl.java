package com.example.demo.service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.CharacterRequest;
import com.example.demo.model.CharacterResponse;
import com.example.demo.persistence.entity.Character;
import com.example.demo.persistence.repository.CharacterRepository;
@CrossOrigin(origins = "http://localhost:4200")

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository repository;

    @Override
    public CharacterResponse create(CharacterRequest request) {
        Character character = new Character();
        character.setCreate(request.getCreate());
        character.setGender(request.getGender());
        character.setImage(request.getImage());
        character.setName(request.getName());
        character.setSpecies(request.getSpecies());
        character.setStatus(request.getStatus());
        character.setType(request.getType());
        character.setUrl(request.getUrl());

        repository.save(character);

        return createResponse(character);
    }

    @Override
    public List<CharacterResponse> getAll() {
        List<CharacterResponse> responses = new ArrayList<>();

        List<Character> characters = repository.findAll();
        if (!characters.isEmpty()) {
            characters.forEach(character -> responses.add(createResponse(character)));
        }

        return responses;
    }

    private CharacterResponse createResponse(Character character) {
        CharacterResponse response = new CharacterResponse();
        response.setId(character.getId());
        response.setCreate(character.getCreate());
        response.setGender(character.getGender());
        response.setImage(character.getImage());
        response.setName(character.getName());
        response.setSpecies(character.getSpecies());
        response.setStatus(character.getStatus());
        response.setType(character.getType());
        response.setUrl(character.getUrl());
        return response;
    }
    
}
