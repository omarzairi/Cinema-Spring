package com.cinema.proj.controllers;

import com.cinema.proj.entities.Film;
import com.cinema.services.FilmServiceImpl;
import com.cinema.services.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestFilmController {
    @Autowired
    IFilmService filmService;


    @GetMapping("/films")
    @ResponseBody
    public List<Film> getFilms(){
        return filmService.getAllFilms();
    }
    @GetMapping("/films/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Film getFilmById(@PathVariable("id") int id){
        return filmService.getFilmById(id);
    }
    @GetMapping("films/genre")
    public List <Film> getFilmByGenre(@RequestParam("genre") String genre){
        return filmService.getFilmsByGenre(genre);
    }
    @GetMapping("films/title")
    public List<Film> getFilmByTitle(@RequestParam("title") String title){
        return filmService.getFilmsByTitle(title);
    }
    @PostMapping("/films")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public Film addFilm(@RequestBody Film film){
        return filmService.addFilm(film);
    }
    @PutMapping("/films/{id}")
    public Film updateFilm(@RequestBody Film film,@PathVariable("id") int id){
        return filmService.updateFilm(film,id);
    }
    @DeleteMapping("/films/{id}")
    public void deleteFilm(@PathVariable("id") int id){
        filmService.deleteFilm(id);
    }

    @GetMapping("films/year")
    public List<Film> getFilmByReleaseYear(@RequestParam("year") int year){
        return filmService.getFilmsByReleaseYear(year);
    }


}
