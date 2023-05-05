package com.cinema.services;

import com.cinema.proj.entities.Film;
import com.cinema.proj.repositories.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class FilmServiceImpl implements IFilmService{
    @Autowired
    FilmRepo filmRepo;
    @Override
    public Film getFilmById(int code) {
        return filmRepo.findById(code).get();
    }

    @Override
    public Film addFilm(Film film) {
        return filmRepo.save(film);
    }

    @Override
    public Film updateFilm(Film film,int id)
    {
        film.setCode(id);
       return filmRepo.save(film);
    }

    @Override
    public void deleteFilm(int code) {
        filmRepo.deleteById(code);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepo.findAll();
    }

    @Override
    public List<Film> getFilmsByGenre(String genre) {
     return filmRepo.getFilmByGenre(genre);
    }

    @Override
    public List<Film> getFilmsByTitle(String title) {
        return filmRepo.getFilmByTitle(title);
    }

    @Override
    public List<Film> getFilmsByReleaseYear(int year) {
        return filmRepo.getFilmByReleaseYear(year);
    }


}
