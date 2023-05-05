package com.cinema.services;

import com.cinema.proj.entities.Diffusion;
import com.cinema.proj.entities.Film;
import com.cinema.proj.entities.Salle;
import com.cinema.proj.entities.Ticket;
import com.cinema.proj.repositories.DiffusionRepo;
import com.cinema.proj.repositories.TicketRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DiffusionServiceImpl implements IDiffusionService{
    @Autowired
    DiffusionRepo diffusionRepo;
    @Autowired
    IFilmService filmService;
    @Autowired
    ISalleService salleService;
    @Autowired
    TicketRepo ticketRepo;


    @Override
    public Diffusion getDiffusionById(String code) {
        return diffusionRepo.findById(code).get();
    }

    @Override
    public Diffusion addDiffusion(Diffusion diffusion) {

        return diffusionRepo.save(diffusion);
    }

    @Override
    public Diffusion updateDiffusion(Diffusion diffusion,int code) {
        diffusion.setCode(code);
        return diffusionRepo.save(diffusion);
    }

    @Override
    public void deleteDiffusion(String code) {
        diffusionRepo.deleteById(code);
    }

    @Override
    public List<Diffusion> getDiffusionsByFilm(String code, LocalDateTime date) {
        return diffusionRepo.getDiffusionsByFilm(code, date);
    }

    @Override
    public Diffusion getDiffusionBySalle(String code) {
        return diffusionRepo.getDiffusionBySalle(code);
    }

    @Override
    public List<Diffusion> getAllDiffusions() {
        return diffusionRepo.findAll();
    }



    @Override
    public Diffusion removeTicketFromDiffusion(String code, String ticketCode) {
        return diffusionRepo.deleteDiffusionByTicket(code, ticketCode);
    }

    @Override
    public List<Film> getAllFilmsInDiffusions() {
        return diffusionRepo.getAllFilmsInDiffusions();
    }

    @Override
    public List<Film> getAllNonExpiredDiffusions(LocalDateTime dateTemps) {
        return diffusionRepo.getAllNonExpiredDiffusions(dateTemps);
    }

    @Override
    @Transactional
    public void deleteExpiredDiffusions(LocalDateTime dateTemps) {
        ticketRepo.deleteAllTicketsByDiffusion(dateTemps);
        diffusionRepo.deleteExpiredDiffusions(dateTemps);
    }
}
