package com.example.filmservice.service.impl;

import com.example.filmservice.model.Cinema;
import com.example.filmservice.repository.CinemaRepository;
import com.example.filmservice.repository.UserRepository;
import com.example.filmservice.service.CinemaService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Transactional
@Slf4j
@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final UserRepository userRepository;


    @Override
    public Optional<Cinema> getCinemaById(Long id) {
        return cinemaRepository.findById(id);
    }

    @Override
    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema updateCinema(Long id, Cinema updatedCinema) {
        return cinemaRepository.findById(id)
                .map(cinema -> {
                    cinema.setName(updatedCinema.getName());
                    cinema.setLocation(updatedCinema.getLocation());
                    return cinemaRepository.save(cinema);
                })
                .orElseThrow(() -> new RuntimeException("Кинотеатр не найден"));
    }

    @Override
    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }
}
