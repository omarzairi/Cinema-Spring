package com.cinema.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.proj.entities.Salle;

public interface SalleRepo extends JpaRepository<Salle,String>  { 

}
