package com.cinema.proj.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
@Table(name="Diffusion")
public class Diffusion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	private LocalDateTime dateTemps;
	

	
	@ManyToOne()
	@JoinColumn(name="idSalle")
	private  Salle salle;
	
	@ManyToOne()
	@JoinColumn(name="idFilm")
	private Film film;
	//one to many with ticket
	@OneToMany(fetch = FetchType.EAGER,mappedBy="diffusion",cascade = CascadeType.ALL)
	private List<Ticket> tickets;



    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public LocalDateTime getDateTemps() {
		return dateTemps;
	}

	public void setDateTemps(LocalDateTime dateTemps) {
		this.dateTemps = dateTemps;
	}



	public Diffusion() {
		super();
	}
	@JsonCreator
	public Diffusion(LocalDateTime dateTemps, Salle salle, Film film) {
		super();
		this.dateTemps = dateTemps;
		this.salle = salle;
		this.film = film;
	}
	


	@Override
	public String toString() {
		return "Diffusion{" +
				"code=" + code +
				", dateTemps=" + dateTemps +
				", salle=" + salle +
				", film=" + film +
				'}';
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
}
