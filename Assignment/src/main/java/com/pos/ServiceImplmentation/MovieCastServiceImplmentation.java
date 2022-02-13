package com.pos.ServiceImplmentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.entities.MovieCast;
import com.pos.repositories.MovieCastReposarory;
import com.pos.services.MovieCastService;

@Service
public class MovieCastServiceImplmentation implements MovieCastService {
	@Autowired
	MovieCastReposarory moviecastreposarory;

	@Override
	public ResponseEntity<MovieCast> getAllMovieCast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity getMovieCastById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity insertMovieCast(MovieCast MovieCast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity updateMovieCast(MovieCast MovieCast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity deleteMovieCastById(long id) {
		// TODO Auto-generated method stub
		return null;
	
	}

	@Override
	public ResponseEntity<MovieCast> getCastByById(Long id) {
		if(id != null) {
			List<MovieCast> MovieCastList = moviecastreposarory.getCastByById(id);
			if(MovieCastList != null && MovieCastList.size() >0) {
				return new ResponseEntity(MovieCastList, HttpStatus.OK);

			}else {
				return new ResponseEntity( HttpStatus.NO_CONTENT);

			}
		}else {
			return new ResponseEntity( HttpStatus.BAD_REQUEST);
		}
		
	}

}
