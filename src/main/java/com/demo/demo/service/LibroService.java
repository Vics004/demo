package com.demo.demo.service;
import com.demo.demo.model.Genero;
import com.demo.demo.model.Libro;
import com.demo.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private GeneroService generoService;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Libro findById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro saveLibro(Libro libro) {
        if (libro.getGenero() != null && libro.getGenero().getId() != null) {
            Genero genero = generoService.findById(libro.getGenero().getId());
            libro.setGenero(genero);
        }
        return libroRepository.save(libro);
    }

    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }
}
