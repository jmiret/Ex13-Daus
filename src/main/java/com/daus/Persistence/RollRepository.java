package com.daus.Persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.daus.Model.Player;
import com.daus.Model.Roll;

public interface RollRepository extends JpaRepository<Roll, Long> {
	
	@Query(value = "SELECT * FROM roll WHERE id_roll = :id_roll", nativeQuery = true)
	List<Roll> getRollById(@Param("id_roll") Long id_roll);
	
	@Query(value = "SELECT * FROM roll WHERE fk_player = :id_player", nativeQuery = true)
	List<Roll> getRollByPlayer(@Param("id_player") Long id_player);
				
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM roll WHERE roll_number IN (?1)", nativeQuery = true)
	void deletePlayerRoll(List<Integer> ids);
		
}
