package com.daus.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daus.Model.Dice;

public interface DiceRepository extends JpaRepository<Dice, Long> {

}
