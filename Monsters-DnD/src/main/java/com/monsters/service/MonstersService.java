package com.monsters.service;

import java.util.List;

import com.monsters.model.Monster;

public interface MonstersService {

	List<String> getMonsters();

	Monster getMonsterMostStrength();

	List<Monster> getMonstersSomeTrait(String trait);
	
	List<Monster> getMonstersSomeaction(String action);

	List<Monster> getMonsterByName(String name);

	Monster getMonsterTable(String name);
	
	List<Monster> getMonstersByChallenge(double challenge1, double challenge2);

	List<Monster> getListMonsters();

	List<Monster> getMonstersByExp(String exp1, String exp2);
}
