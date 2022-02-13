package com.pos.services;

import org.springframework.http.ResponseEntity;

import com.pos.entities.Movie;

public interface MovieService {
	public ResponseEntity<Movie>  getAllMovies();

	public ResponseEntity getMovieById(Long id);

	public ResponseEntity insertMovie(Movie Movie);

	public ResponseEntity updateMovie(Movie Movie);

	public ResponseEntity deleteMovieById(Long id);
}
