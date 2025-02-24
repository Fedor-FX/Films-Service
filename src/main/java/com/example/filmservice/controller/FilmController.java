package com.example.filmservice.controller;

import com.example.filmservice.model.Film;
import com.example.filmservice.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/films")
@AllArgsConstructor
public class FilmController {

    private final FilmService service;

    @GetMapping("/{id}")
    public Film findFilmById(@PathVariable("id") int id) {
        return service.findFilmById(id);
    }

    @GetMapping("/searchByTitle")
    public Film getFilmByTitle(@RequestParam String title) {
        return service.getFilmByTitle(title);
    }
}
