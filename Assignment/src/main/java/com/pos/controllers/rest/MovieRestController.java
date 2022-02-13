package com.pos.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.entities.Movie;
import com.pos.services.MovieService;

// Film controller
@RestController
@RequestMapping("/Movies")
public class MovieRestController {
	@Autowired
	MovieService movieservice;

	// search all in film get all films and its data
	@GetMapping("/GetAllMovies")
	public ResponseEntity<Movie> GetAllMovies() {
		return movieservice.getAllMovies();
	}

	// search by film id to get film deatails
	@GetMapping("/GetMovieDetails/{movieid}")
	public ResponseEntity<Movie> GetAllMovieDetails(@PathVariable Long movieid) {
		return movieservice.getMovieById(movieid);
	}

	// insert new film
	@PostMapping("/AddMovie")
	public ResponseEntity<Movie> AddMovie(@RequestBody Movie movie) {
		return movieservice.insertMovie(movie);
	}

	// update film
	@PutMapping("/UpdateMovie")
	public ResponseEntity<Movie> UpdateMovie(@RequestBody Movie movie) {
		return movieservice.updateMovie(movie);
	}

	// delete film by id
	@DeleteMapping("/DeleteMovie/{movieid}")
	public ResponseEntity<Movie> DeleteMovie(@PathVariable Long movieid) {
		return movieservice.deleteMovieById(movieid);
	}

}
