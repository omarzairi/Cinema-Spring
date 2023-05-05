package com.cinema.proj.entities;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.List;

import com.cinema.services.FilmServiceImpl;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Film  {
	
	
	@Id
	@Column(unique = true)
	private int code;
	private String title;

	private String genre;
	private String description;

	private String  releaseDate;
	

	@OneToMany(mappedBy="film",cascade = CascadeType.ALL)
	private List<Diffusion> diffusions;




	
	public Film( int code, String title
	, String genre, String description, String releaseDate) {
		super();
		this.code = code;
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.releaseDate = releaseDate;

		
	}
	
	public Film() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Film{" +
				"code='" + code + '\'' +
				", title='" + title + '\'' +
				", genre='" + genre + '\'' +
				", description='" + description + '\'' +
				", releaseDate=" + releaseDate +
				'}';
	}
}
