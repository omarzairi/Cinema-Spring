package com.cinema.services;

import com.cinema.proj.entities.Salle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISalleService {
    Salle getSalleById(String code);
    Salle addSalle(Salle salle);
    Salle updateSalle(Salle salle, int code);
    void deleteSalle(String code);
    List<Salle> getAllSalles();



}
