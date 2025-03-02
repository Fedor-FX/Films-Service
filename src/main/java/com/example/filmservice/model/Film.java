package com.example.filmservice.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Film {
    private int id; // Уникальный идентификатор фильма
    private String title; // Название фильма
    private int releaseYear; // Год выпуска
}