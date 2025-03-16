package com.example.filmservice.service.impl;

import com.example.filmservice.model.Film;
import com.example.filmservice.repository.FilmRepository;
import com.example.filmservice.service.FilmService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    @Override
    public Optional<Film> findFilmById(int id) {
        return filmRepository.findById(id);
    }

    @Override
    public Optional<Film> getFilmByTitle(String title) {
        return filmRepository.findByTitle(title);
    }


    @Override
    public List<Film> searchFilms(String title, Integer releaseYear) {
        if (title != null) {
            return filmRepository.findByTitle(title)
                    .map(List::of)
                    .orElse(List.of());
        } else if (releaseYear != null) {
            return filmRepository.findByReleaseYear(releaseYear);
        }
        return filmRepository.findAll();
    }

    @Override
    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }

    @Override
    public Film updateFilm(int id, Film updatedFilm) {
        return filmRepository.findById(id)
                .map(film -> {
                    film.setTitle(updatedFilm.getTitle());
                    film.setReleaseYear(updatedFilm.getReleaseYear());
                    return filmRepository.save(film);
                })
                .orElseThrow(() -> new RuntimeException("Фильм не найден"));
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
}
