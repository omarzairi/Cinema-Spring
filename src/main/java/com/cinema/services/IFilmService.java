package com.cinema.services;

import com.cinema.proj.entities.Film;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface IFilmService {

       Film getFilmById(int code);
       Film addFilm(Film film);
       Film updateFilm(Film film,int id);
       void deleteFilm(int code);
       List<Film> getAllFilms();
       List<Film> getFilmsByGenre(String genre);
       List<Film> getFilmsByTitle(String title);
       List<Film> getFilmsByReleaseYear(int year);













}
