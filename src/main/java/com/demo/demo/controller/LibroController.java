package com.demo.demo.controller;

import com.demo.demo.model.Libro;
import com.demo.demo.service.GeneroService;
import com.demo.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;
    
    @Autowired
    private GeneroService generoService;
    
    @GetMapping
    public String listLibros(Model model) {
        model.addAttribute("libros", libroService.findAll());
        return "libros/list";
    }
    
    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("generos", generoService.findAll());
        return "libros/form";
    }
    
    @PostMapping("/save")
    public String saveLibro(@ModelAttribute("libro") Libro libro) {
        libroService.saveLibro(libro);
        return "redirect:/libros?success";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Libro libro = libroService.findById(id);
        model.addAttribute("libro", libro);
        model.addAttribute("generos", generoService.findAll());
        return "libros/form";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteLibro(@PathVariable Long id) {
        libroService.deleteById(id);
        return "redirect:/libros?deleted";
    }
}
