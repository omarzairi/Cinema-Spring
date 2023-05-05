package com.cinema.services;

import com.cinema.proj.entities.Salle;
import com.cinema.proj.entities.Ticket;
import com.cinema.proj.repositories.TicketRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TicketServiceImpl implements ITicketService {

    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    DiffusionServiceImpl diffusionService;
    @Autowired
    SalleServiceImpl salleService;

    @Override
    public Ticket getTicketById(String code) {
        return ticketRepo.findById(code).get();
    }

    @Override
    public Ticket addTicket(Ticket ticket, String diffusion) {
        Salle salle = diffusionService.getDiffusionById(diffusion).getSalle();
        salle.setCapacite(salle.getCapacite() - 1);
        ticket.setDiffusion(diffusionService.getDiffusionById(diffusion));
        salleService.updateSalle(salle, salle.getNumSalle());
        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket, int code) {
        ticket.setCode(code);
        return ticketRepo.save(ticket);
    }

    @Override
    public void deleteTicket(String code) {
        ticketRepo.deleteById(code);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }



    @Override
    public List<Ticket> getTicketsByDiffusion(String code) {
        return ticketRepo.getTicketByDiffusion(code);
    }


    @Override
    public Ticket addTicketToDiffusion(String code, String ticketCode) {
        Salle salle = diffusionService.getDiffusionById(code).getSalle();
        salle.setCapacite(salle.getCapacite() - 1);
        Ticket ticket = this.getTicketById(ticketCode);
        ticket.setDiffusion(diffusionService.getDiffusionById(code));
        salleService.updateSalle(salle, salle.getNumSalle());
        return this.updateTicket(ticket, ticket.getCode());

    }

    @Override
    public Ticket deleteTicketFromDiffusion(String code, int ticketCode) {
        return ticketRepo.deleteTicketFromDiffusion(code, ticketCode);
    }



    @Override
    public List<Ticket> getTicketByCIN(String CIN) {
        return ticketRepo.getTicketByCIN(CIN);
    }

    @Override
    @Transactional
    public void deleteAllTicketsByDiffusion(LocalDateTime date) {
        ticketRepo.deleteAllTicketsByDiffusion(date);
    }

}
