package com.example.filmservice.service;

import com.example.filmservice.model.Film;

public interface FilmService {


    Film findFilmById(int id);

    Film getFilmByTitle(String title);
}
