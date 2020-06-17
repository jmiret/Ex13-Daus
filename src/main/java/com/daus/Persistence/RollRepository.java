package com.daus.Persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daus.Model.Roll;

public interface RollRepository extends JpaRepository<Roll, Long> {

	@Query(value = "SELECT COUNT(DISTINCT roll_number) from roll", nativeQuery = true)
	int getLastRoll();
	
	@Query(value = "SELECT * FROM roll WHERE roll_number = :roll_number", nativeQuery = true)
	List<Roll> getRollbyNumber(@Param("roll_number") int rollNumber);
	
}
