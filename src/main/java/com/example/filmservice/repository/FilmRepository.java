package com.example.filmservice.repository;

import com.example.filmservice.model.Film;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findByTitle(String title);

    List<Film> findByReleaseYear(int releaseYear);
}
