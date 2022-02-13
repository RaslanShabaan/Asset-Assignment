package com.pos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "MovieCast-gen", sequenceName = "MovieCast_SEQ", initialValue = 200, allocationSize = 1)
@Table(name = "MOVIECAST")
public class MovieCast {
	@Column(name = "CAST_ID")
	private Long cast_id;
	@Column(name = "CASTMEMBER_NAME")
	private String castmember_name;
	@Column(name = "CASTMEMBER_DESCRIPTION")
	private String castmember_description;
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MOVIE_ID")
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MovieCast-gen")
	public Long getCast_id() {
		return cast_id;
	}

	public void setCast_id(Long cast_id) {
		this.cast_id = cast_id;
	}

	public String getCastmember_description() {
		return castmember_description;
	}

	public void setCastmember_description(String castmember_description) {
		this.castmember_description = castmember_description;
	}

	public String getCastmember_name() {
		return castmember_name;
	}

	public void setCastmember_name(String castmember_name) {
		this.castmember_name = castmember_name;
	}

}
