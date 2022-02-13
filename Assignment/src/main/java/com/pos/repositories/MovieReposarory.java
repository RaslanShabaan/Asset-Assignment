package com.pos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.entities.Movie;

public interface MovieReposarory extends JpaRepository<Movie, Long>{

}
