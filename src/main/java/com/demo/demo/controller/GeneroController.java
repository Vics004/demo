package com.demo.demo.controller;

import com.demo.demo.model.Genero;
import com.demo.demo.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroService generoService;
    
    @GetMapping
    public String listGenero(Model model) {
        model.addAttribute("generos", generoService.findAll());
        return "generos/list";
    }
    
    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("genero", new Genero());
        return "generos/form";
    }
    
    @PostMapping("/save")
    public String saveGenero(@ModelAttribute("genero") Genero genero) {
        generoService.save(genero);
        return "redirect:/generos";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Genero genero = generoService.findById(id);
        model.addAttribute("genero", genero);
        return "generos/form";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteGenero(@PathVariable Long id) {
        generoService.deleteById(id);
        return "redirect:/generos";
    }
}
