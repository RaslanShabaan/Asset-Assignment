package com.pos.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.entities.MovieCast;
import com.pos.services.MovieCastService;

// Cast in Film controller
@RestController
@RequestMapping("/Cast")
public class CastRestController {
	@Autowired
	MovieCastService moviecastservice;

// search by film id to get deatails ang film cast
	@GetMapping("/GetCastByMovie/{movieid}")
	public ResponseEntity<MovieCast> GetCastByMovie(@PathVariable Long movieid) {
		return moviecastservice.getCastByById(movieid);
	}
}
