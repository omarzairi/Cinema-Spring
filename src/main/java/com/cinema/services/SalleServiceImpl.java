package com.cinema.services;

import com.cinema.proj.entities.Salle;
import com.cinema.proj.repositories.SalleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalleServiceImpl implements ISalleService{

    @Autowired
    SalleRepo salleRepo;
    @Override
    public Salle getSalleById(String code) {
        return salleRepo.findById(code).get();
    }

    @Override
    public Salle addSalle(Salle salle) {
        return salleRepo.save(salle);
    }

    @Override
    public Salle updateSalle(Salle salle, int code) {
        salle.setNumSalle(code);
        return salleRepo.save(salle);
    }

    @Override
    public void deleteSalle(String code) {
        salleRepo.deleteById(code);

    }

    @Override
    public List<Salle> getAllSalles() {
        return salleRepo.findAll();
    }
}
