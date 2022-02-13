package com.pos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pos.entities.MovieCast;

public interface MovieCastReposarory extends JpaRepository<MovieCast, Long>{
	@Query("select c from MovieCast c where c.movie.movie_id =:id ")
List<MovieCast>	 getCastByById(Long id);
}
