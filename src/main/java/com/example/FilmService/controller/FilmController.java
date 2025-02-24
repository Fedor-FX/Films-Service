package com.example.FilmService.controller;

import com.example.FilmService.model.Film;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/films")
public class FilmController {

    @GetMapping // Указываем, что это GET-запрос
    public List<Film> findAllFilms() {
        return List.of(
                Film.builder()
                        .id(12)
                        .title("Inception")
                        .releaseYear(2010)
                        .build(),
                Film.builder()
                        .id(2)
                        .title("The Matrix")
                        .releaseYear(1999)
                        .build()
        );
    }
}
