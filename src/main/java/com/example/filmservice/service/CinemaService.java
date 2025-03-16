package com.example.filmservice.service;

import com.example.filmservice.model.Cinema;
import java.util.List;
import java.util.Optional;

public interface CinemaService {
    Optional<Cinema> getCinemaById(Long id);

    Cinema addCinema(Cinema cinema);

    Cinema updateCinema(Long id, Cinema updatedCinema);

    void deleteCinema(Long id);

    List<Cinema> getAllCinemas();
}
