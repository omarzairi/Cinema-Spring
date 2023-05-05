package com.cinema.services;

import com.cinema.proj.entities.Diffusion;
import com.cinema.proj.entities.Film;
import com.cinema.proj.entities.Ticket;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface IDiffusionService {
    Diffusion getDiffusionById(String code);
    Diffusion addDiffusion(Diffusion diffusion);
    Diffusion updateDiffusion(Diffusion diffusion,int code);
    void deleteDiffusion(String code);
    List<Diffusion> getDiffusionsByFilm(String code, LocalDateTime date);
    Diffusion getDiffusionBySalle(String code);
    List<Diffusion> getAllDiffusions();

    Diffusion removeTicketFromDiffusion(String code, String ticketCode);

    List<Film> getAllFilmsInDiffusions();

    List<Film> getAllNonExpiredDiffusions(LocalDateTime dateTemps);

    //delete expired diffusions
    void deleteExpiredDiffusions(LocalDateTime dateTemps);

}
