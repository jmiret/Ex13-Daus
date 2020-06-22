package com.daus.Persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daus.Model.Roll;

public interface RollRepository extends JpaRepository<Roll, Long> {
	
	@Query(value = "SELECT * FROM roll WHERE id_roll = :id_roll", nativeQuery = true)
	List<Roll> getRollById(@Param("id_roll") Long id_roll);
	
	@Query(value = "SELECT * FROM roll WHERE fk_player = :id_player", nativeQuery = true)
	List<Roll> getRollByPlayer(@Param("id_player") Long id_player);
	
	@Query(value = "SELECT roll.id_roll FROM roll WHERE fk_player = :id_player", nativeQuery = true)
	List<Long> getRollIdByPlayerId(@Param("id_player") Long id_player);
	
	@Query(value = "SELECT * FROM roll WHERE fk_player = :id_player", nativeQuery = true)
	List<Roll> getRollByPlayerId(@Param("id_player") Long id_player);
		
}
