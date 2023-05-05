package com.cinema.proj.controllers;


import com.cinema.proj.entities.Diffusion;
import com.cinema.proj.entities.Film;
import com.cinema.services.IDiffusionService;
import com.cinema.services.IFilmService;
import com.cinema.services.ISalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestDiffusionController {
    @Autowired
    IDiffusionService diffusionService;
    @Autowired
    IFilmService filmService;
    @Autowired
    ISalleService salleService;


    @GetMapping("/diffusions")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Diffusion> getDiffusions(){
       return diffusionService.getAllDiffusions();
    }

    @GetMapping("/diffusions/films")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Film> getAllFilmsInDiffusions(){
        return diffusionService.getAllFilmsInDiffusions();
    }
    @PostMapping("/diffusions")
    public Diffusion addDiffusion(@RequestBody Diffusion diffusion){
        return diffusionService.addDiffusion(diffusion);
    }

    @PutMapping("/diffusions/{code}")
    public Diffusion updateDiffusion(@RequestBody Diffusion diffusion,@PathVariable("code") int code){
        return diffusionService.updateDiffusion(diffusion,code);
    }
    @DeleteMapping("/diffusions/{code}")
    public void deleteDiffusion(@PathVariable("code") String code){
        diffusionService.deleteDiffusion(code);
    }
    @GetMapping("/diffusions/{code}")
    public Diffusion getDiffusionById(@PathVariable("code") String code){
        return diffusionService.getDiffusionById(code);
    }

    @DeleteMapping("/diffusions/expired")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteExpiredDiffusions(@RequestParam("date") LocalDateTime dateTemps){
        diffusionService.deleteExpiredDiffusions(dateTemps);
    }
    @GetMapping("/diffusions/films/{code}")
    public List<Diffusion> getDiffusionsByFilm(@PathVariable("code") String code,@RequestParam("date") LocalDateTime date){
        return diffusionService.getDiffusionsByFilm(code,date);
    }
    @GetMapping("/diffusions/nonexpired")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Film> getAllNonExpiredDiffusions(@RequestParam("date") LocalDateTime dateTemps){
        return diffusionService.getAllNonExpiredDiffusions(dateTemps);
    }
    @GetMapping("/diffusions/salles/{code}")
    public Diffusion getDiffusionBySalle(@PathVariable("code") String code){
        return diffusionService.getDiffusionBySalle(code);
    }




}
