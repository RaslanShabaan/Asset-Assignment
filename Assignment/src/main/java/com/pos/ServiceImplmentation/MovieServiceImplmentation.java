package com.pos.ServiceImplmentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.entities.Movie;
import com.pos.repositories.MovieReposarory;
import com.pos.services.MovieService;

@Service
public class MovieServiceImplmentation implements MovieService {
	@Autowired
	MovieReposarory moviereposarory;

	@Override
	public ResponseEntity<Movie> getAllMovies() {
		List<Movie> allmovies = moviereposarory.findAll();
		if (allmovies != null && allmovies.size() > 0) {
			return new ResponseEntity(allmovies, HttpStatus.OK);

		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}
	}

	@Override
	public ResponseEntity insertMovie(Movie Movie) {
		if (Movie.getMovie_description() == null || Movie.getMovie_name() == null || Movie.getMovie_rate() == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);

		} else {
			Movie movie = moviereposarory.save(Movie);
			return new ResponseEntity(movie, HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity updateMovie(Movie Movie) {
		if (Movie.getMovie_id() == null || Movie.getMovie_description() == null || Movie.getMovie_name() == null
				|| Movie.getMovie_rate() == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);

		} else {
			Movie movie = moviereposarory.save(Movie);
			return new ResponseEntity(movie, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity getMovieById(Long id) {
		if (id != null) {
			Movie m = moviereposarory.findById(id).orElse(null);
			if (m != null) {

				return new ResponseEntity(m, HttpStatus.OK);

			} else {
				return new ResponseEntity(HttpStatus.NO_CONTENT);

			}
		} else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity deleteMovieById(Long id) {
		if (id != null) {
			moviereposarory.deleteById(id);
			return new ResponseEntity(HttpStatus.OK);

		} else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);

		}

	}
}
