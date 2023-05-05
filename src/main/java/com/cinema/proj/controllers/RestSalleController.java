package com.cinema.proj.controllers;

import com.cinema.proj.entities.Salle;
import com.cinema.services.ISalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestSalleController {

    @Autowired
    ISalleService salleService;

    @GetMapping("/salles")
    public List<Salle> getSalles(){
        return salleService.getAllSalles();
    }
    @GetMapping("/salles/{code}")
    public Salle getSalleById(@PathVariable("code") String code){
        return salleService.getSalleById(code);
    }
    @PostMapping("/salles")
    public Salle addSalle(@RequestBody Salle salle){
        return salleService.addSalle(salle);
    }
    @PutMapping("/salles/{code}")
    public Salle updateSalle(@RequestBody Salle salle,@PathVariable("code") int code){
        return salleService.updateSalle(salle,code);
    }
    @DeleteMapping("/salles/{code}")
    public void deleteSalle(@PathVariable("code") String code){
        salleService.deleteSalle(code);
    }

}
