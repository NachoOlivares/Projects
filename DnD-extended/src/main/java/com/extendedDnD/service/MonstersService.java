package com.extendedDnD.service;

import java.util.List;

import com.extendedDnD.model.Monster;

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

	List<String> getDamageInmunitiesTypes();

	List<Monster> sortByChallenge(boolean asc);

	List<Monster> sortByExp(boolean asc);

	List<Monster> sortByHit_points(boolean asc);

	List<Monster> sortByDamage_inmunities(boolean asc);

	List<Monster> sortByIntro(boolean asc);

	List<Monster> sortByName(boolean asc);
}
