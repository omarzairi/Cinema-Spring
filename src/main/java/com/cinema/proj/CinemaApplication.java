package com.cinema.proj;

import com.cinema.proj.entities.Diffusion;
import com.cinema.proj.entities.Film;
import com.cinema.proj.entities.Salle;
import com.cinema.proj.entities.Ticket;
import com.cinema.services.DiffusionServiceImpl;
import com.cinema.services.FilmServiceImpl;
import com.cinema.services.SalleServiceImpl;
import com.cinema.services.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;


@SpringBootApplication(scanBasePackages = {"com.cinema.proj", "com.cinema.services", "com.cinema.proj.repositories"})
public class CinemaApplication  {


	public static void main(String[] args) {

		SpringApplication.run(CinemaApplication.class, args);

	}



	//Film film=new Film("1","M3GAN","horror","hola", "2023");
	//filmService.addFilm(film);
	//filmService.addFilm(new Film("2","Scream VI","horror","scream", "2023"));
	//System.out.println(filmService.getFilmsByGenre("horror"));
	//Salle s=new Salle(1,"S502",100);
	//salleService.addSalle(s);
	//System.out.println(salleService.getSalleById("1").toString());
	//Diffusion diffusion=new Diffusion(LocalDateTime.parse("2023-04-12T12:00:00"));
	//diffusion.setFilm(film);
	//diffusion.setSalle(s);
	//diffusionService.addDiffusion(diffusion);
	//System.out.println(diffusionService.getAllDiffusions());
	//Ticket ticket=new Ticket(300F, "D25");
	//Ticket ticket2=new Ticket(300F, "D26");
	//ticketService.addTicket(ticket);
	//ticketService.addTicket(ticket2);
	//ticketService.addTicketToDiffusion("1", "1");
	//ticketService.addTicketToDiffusion("1", "2");
	//System.out.println(ticketService.getAllTickets());
	//System.out.println(diffusionService.getDiffusionById("1"));













}
