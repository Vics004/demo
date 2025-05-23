package com.demo.demo.service;

import com.demo.demo.model.Genero;
import com.demo.demo.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public Genero findById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }
}
