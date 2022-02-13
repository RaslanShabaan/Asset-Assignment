package com.pos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "Movie-gen", sequenceName = "Movie_SEQ", initialValue = 200, allocationSize = 1)
@Table(name = "MOVIE")
public class Movie {
	@Column(name = "MOVIE_ID")
	private Long movie_id;
	@Column(name = "MOVIE_NAME")
	private String movie_name;
	@Column(name = "MOVIE_RATE")
	private Double movie_rate;
	@Column(name = "MOVIE_DESCRIPTION")
	private String movie_description;
//	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
//	private List<MovieCast> moviecast;
//
//	public List<MovieCast> getMoviecast() {
//		return moviecast;
//	}
//
//	public void setMoviecast(List<MovieCast> moviecast) {
//		this.moviecast = moviecast;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie-gen")
	public Long getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_description() {
		return movie_description;
	}

	public void setMovie_description(String movie_description) {
		this.movie_description = movie_description;
	}

	public Double getMovie_rate() {
		return movie_rate;
	}

	public void setMovie_rate(Double movie_rate) {
		this.movie_rate = movie_rate;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

}
