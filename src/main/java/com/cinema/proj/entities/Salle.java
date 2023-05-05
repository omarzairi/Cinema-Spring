package com.cinema.proj.entities;



import java.util.List;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
public class Salle {
	@Id
	private int numSalle;
	private String name;
	private int capacite;

	
	
	

	@OneToMany(mappedBy="salle",cascade = CascadeType.ALL)
	private List<Diffusion> diffusions;

	public Salle(int numSalle,String name, int capacite) {
		super();
		this.numSalle = numSalle;
		this.name = name;
		this.capacite = capacite;
	}
	public Salle() {
		super();
	}
	public int getNumSalle() {
		return numSalle;
	}

	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Salle{" +
				"numSalle=" + numSalle +
				", name='" + name +
				", capacite=" + capacite +
				'}';
	}



}
