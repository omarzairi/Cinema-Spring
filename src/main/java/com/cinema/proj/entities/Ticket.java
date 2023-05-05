package com.cinema.proj.entities;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	private String CIN;



	@ManyToOne()
	@JoinColumn(name = "idDiffusion")
	private Diffusion diffusion;

	@JsonCreator
	public Ticket(int code,String CIN , float price, String seat) {
		super();
		this.code = code;

		this.CIN=CIN;
	}

	public Ticket() {
		super();

	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}





	@Override
	public String toString() {
		return "Ticket{" +
				"code=" + code +
				", CIN='" + CIN + '\'' +
				'}';
	}

	public void setDiffusion(Diffusion diffusion) {
		this.diffusion = diffusion;
	}

	public Diffusion getDiffusion() {
		return diffusion;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}
}

