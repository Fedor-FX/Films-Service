package com.example.filmservice.controller;

import com.example.filmservice.model.Film;
import com.example.filmservice.service.FilmService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService service;

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = service.getAllFilms();
        return ResponseEntity.ok(films);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> findFilmById(@PathVariable int id) {
        return service.findFilmById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Film>> searchFilms(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer releaseYear) {
        List<Film> films = service.searchFilms(title, releaseYear);
        return films.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(films);
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        Film savedFilm = service.addFilm(film);
        return ResponseEntity.ok(savedFilm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable int id, @RequestBody Film film) {
        try {
            Film updatedFilm = service.updateFilm(id, film);
            return ResponseEntity.ok(updatedFilm);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable int id) {
        service.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
