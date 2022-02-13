package com.pos.services;

import org.springframework.http.ResponseEntity;

import com.pos.entities.MovieCast;

public interface MovieCastService {
	public ResponseEntity<MovieCast> getAllMovieCast();

	public ResponseEntity getMovieCastById(long id);

	public ResponseEntity insertMovieCast(MovieCast MovieCast);

	public ResponseEntity updateMovieCast(MovieCast MovieCast);

	public ResponseEntity deleteMovieCastById(long id);
	public ResponseEntity<MovieCast> getCastByById(Long id);
	
}
