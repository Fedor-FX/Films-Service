package com.example.filmservice.service;

import com.example.filmservice.model.Film;
import java.util.List;
import java.util.Optional;

public interface FilmService {
    Optional<Film> findFilmById(int id);

    Optional<Film> getFilmByTitle(String title);

    List<Film> searchFilms(String title, Integer releaseYear);

    Film addFilm(Film film);

    Film updateFilm(int id, Film updatedFilm);

    void deleteFilm(int id);

    List<Film> getAllFilms();
}
