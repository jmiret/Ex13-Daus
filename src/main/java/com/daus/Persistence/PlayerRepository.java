package com.daus.Persistence;

/**
 * 
 * @author jordi.miret
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.daus.Model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
 