package com.daus.Persistence;

/**
 * 
 * @author jordi.miret
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.daus.Model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
