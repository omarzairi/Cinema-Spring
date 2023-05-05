package com.cinema.services;

import com.cinema.proj.entities.Ticket;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface ITicketService {

    Ticket getTicketById(String code);
    Ticket addTicket(Ticket ticket,String diffusion);
    Ticket updateTicket(Ticket ticket,int code);
    void deleteTicket(String code);
    List<Ticket> getAllTickets();

    List<Ticket> getTicketsByDiffusion(String code);

    Ticket addTicketToDiffusion(String code, String ticketCode);
    Ticket deleteTicketFromDiffusion(String code, int ticketCode);

    List<Ticket> getTicketByCIN(String CIN);
    void deleteAllTicketsByDiffusion(LocalDateTime dateTemps);
}
