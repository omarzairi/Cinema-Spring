package com.cinema.proj.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.proj.entities.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FilmRepo extends JpaRepository<Film,Integer>  {

    @Query("select f from Film f where f.genre=?1")
    public List<Film> getFilmByGenre(String genre);
    @Query("select f from Film f where f.title like %?1%")
    public List<Film> getFilmByTitle(String title);
    @Query("select f from Film f where f.releaseDate=?1")
    public List<Film> getFilmByReleaseYear(int year);

}
