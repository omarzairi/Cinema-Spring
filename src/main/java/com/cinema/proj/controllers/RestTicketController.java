package com.cinema.proj.controllers;

import com.cinema.proj.entities.Ticket;
import com.cinema.services.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTicketController {

    @Autowired
    ITicketService ticketService;


    @GetMapping("/tickets")
    public List<Ticket> getTickets(){
        return ticketService.getAllTickets();
    }
    //get ticketa by cin
    @GetMapping("/tickets/cin/{cin}")
    public List<Ticket> getTicketsByCin(@PathVariable("cin") String cin){
        return ticketService.getTicketByCIN(cin);
    }

    @GetMapping("/tickets/{code}")
    public Ticket getTicketById(@PathVariable("code") String code){
        return ticketService.getTicketById(code);
    }

    @PostMapping("/tickets/{diffusion}")
    public Ticket addTicket(@RequestBody Ticket ticket,@PathVariable("diffusion") String diffusion){
        return ticketService.addTicket(ticket,diffusion);
    }
    @PutMapping("/tickets/{code}")
    public Ticket updateTicket(Ticket ticket,@PathVariable("code") int code){
        return ticketService.updateTicket(ticket,code);
    }

    @DeleteMapping("/tickets/{code}")
    public void deleteTicket(@PathVariable("code") String code){
        try {
            ticketService.deleteTicket(code);
        }
        catch (Exception e){
            ResponseEntity.badRequest().body(e.getMessage());
        }




    }

    @GetMapping("/tickets/diffusions/{code}")
    public List<Ticket> getTicketsByDiffusion(@PathVariable("code") String code){
        return ticketService.getTicketsByDiffusion(code);
    }

    @PostMapping("/tickets/diffusions/{code}")
    public Ticket addTicketToDiffusion(@PathVariable("code") String code, @RequestBody String ticketCode){
        return ticketService.addTicketToDiffusion(code,ticketCode);
    }
    @DeleteMapping("/tickets/diffusions/{code}")
    public Ticket deleteTicketFromDiffusion(@PathVariable("code") String code, @RequestBody int ticketCode){
        return ticketService.deleteTicketFromDiffusion(code,ticketCode);
    }






}
