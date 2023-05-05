package com.cinema.proj.repositories;

import com.cinema.proj.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.proj.entities.Diffusion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface DiffusionRepo extends JpaRepository<Diffusion,String>  {


    @Query("select d from Diffusion d where d.film.code=?1 and d.dateTemps>=?2 order by d.dateTemps")
    public List<Diffusion> getDiffusionsByFilm(String code,LocalDateTime dateTemps);
    @Query("select d from Diffusion d where d.salle=?1")
    public Diffusion getDiffusionBySalle(String code);
    @Query("select d from Diffusion d where d.tickets=?1")
    public Diffusion getDiffusionByTicket(String code);

    @Query("select d from Diffusion d where d.tickets=?2 and d.code=?1" )
    public Diffusion deleteDiffusionByTicket(String d,String code);


    @Query("select distinct d.film from Diffusion d")
    public List<Film> getAllFilmsInDiffusions();


    @Query("select distinct d.film from Diffusion d where d.dateTemps>=?1")
    public List<Film> getAllNonExpiredDiffusions(LocalDateTime dateTemps);
    @Modifying
    @Query("delete from Diffusion d where d.dateTemps<?1")
    public void deleteExpiredDiffusions(LocalDateTime dateTemps);




}
