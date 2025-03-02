package com.example.filmservice.service;

import com.example.filmservice.model.Film;
import java.util.List;

public interface FilmService {


    Film findFilmById(int id);

    Film getFilmByTitle(String title);

    List<Film> showAll();

    Film  addFilm(Film film);
}