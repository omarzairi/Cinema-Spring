package com.cinema.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.proj.entities.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TicketRepo extends JpaRepository<Ticket,String>   {

    @Query("select t from Ticket t where t.diffusion.code=?1")
    List<Ticket> getTicketByDiffusion(String code);

    @Query("update Ticket t set t.diffusion.code=?1 where t.code=?2")
    Ticket addTicketToDiffusion(String code, int ticketCode);


    @Query("delete from Ticket t where t.diffusion.code=?1 and t.code=?2")
    Ticket deleteTicketFromDiffusion(String code, int ticketCode);

    @Query("select t from Ticket t where t.CIN=?1")
    List<Ticket> getTicketByCIN(String CIN);

    //delete tickets by expired diffusion
    @Modifying
    @Query("delete from Ticket t where t.diffusion in (select d from Diffusion d where d.dateTemps < ?1)")
    void deleteAllTicketsByDiffusion(LocalDateTime dateTemps);

}
