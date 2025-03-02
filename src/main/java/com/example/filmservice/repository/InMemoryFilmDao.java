package com.example.filmservice.repository;

import com.example.filmservice.model.Film;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


@Repository
public class InMemoryFilmDao {
    private final List<Film> films = new ArrayList<>();

    public Film findFilmById(int id) {
        return films.stream()
                .filter(element -> element.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public Film getFilmByTitle(String title) {
        return films.stream()
                .filter(book -> book.getTitle().equals(title)) // Совпадение по названию
                .findFirst() // Берем первый найденный элемент
                .orElse(null); // Если книги не найдены, возвращаем null
    }

    public List<Film> showAll() {
        return films;
    }

    public Film addFilm(Film film) {
        films.add(film);
        return film;
    }
}