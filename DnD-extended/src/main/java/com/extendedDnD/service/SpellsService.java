package com.extendedDnD.service;

import java.util.List;

import com.extendedDnD.model.Spell;

public interface SpellsService {
	
	List<Spell> getAllSpells();
	
	List<String> getSpellsName();

	Spell spellMostLevel();

	List<Spell> getSpellsByRange(int range1, int range2);
	
	List<Spell> getSpellsByName(String name);
	
	Spell getSpellByName(String name);

	List<Spell> getSpellsBySchool(String school);

	List<Spell> getSpellsByRole(String role);
	
	List<Spell> getSpellsByLevel(int level1, int level2);

	List<Spell> sortByName(boolean asc);

	List<Spell> sortByRange(boolean asc);

	List<Spell> sortByRole(boolean asc);

	List<Spell> sortByLevel(boolean asc);

	List<Spell> sortByCasting_time(boolean asc);

	List<Spell> sortByDuration(boolean asc);

	List<String> getSpellsRoles();
	
	List<String> getSpellsSchools();
}
