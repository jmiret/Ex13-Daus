package com.daus.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daus.Model.Dice;

public interface DiceRepository extends JpaRepository<Dice, Long> {
	
	@Query(value = "SELECT SUM(value) FROM dice WHERE fk_roll = :id_roll", nativeQuery = true)
	Long sumRollDice(@Param("id_roll") Long id_roll);

}
