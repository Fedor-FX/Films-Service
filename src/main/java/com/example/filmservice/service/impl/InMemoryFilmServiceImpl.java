package com.example.filmservice.service.impl;

import com.example.filmservice.model.Film;
import com.example.filmservice.repository.InMemoryFilmDao;
import com.example.filmservice.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class InMemoryFilmServiceImpl implements FilmService { // Добавляем implements FilmService

    public final InMemoryFilmDao repository;


    @Override
    public Film findFilmById(int id) {
        return repository.findFilmById(id);
    }

    @Override
    public Film getFilmByTitle(String title) {
        return repository.getFilmByTitle(title);
    }
}
