package com.example.filmservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "films")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private int releaseYear;

    @Column(length = 1000)
    private String description;

    private String director;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema; // Связь с кинотеатром

    @ManyToMany(mappedBy = "favoriteFilms")
    private Set<User> users; // Пользователи, у которых этот фильм в избранном
}
