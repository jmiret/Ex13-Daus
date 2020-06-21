package com.daus.Persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daus.Model.Dice;
import com.daus.Model.Roll;

public interface DiceRepository extends JpaRepository<Dice, Long> {
	
	@Query(value = "SELECT SUM(value) FROM dice WHERE fk_roll = :id_roll", nativeQuery = true)
	Integer sumRollDice(@Param("id_roll") Long id_roll);
	
	@Query(value = "SELECT * FROM dice WHERE fk_roll = :id_roll", nativeQuery = true)
	List<Dice> getDiceByRollId(@Param("id_roll") Long id_roll);

}
