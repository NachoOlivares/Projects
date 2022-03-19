package com.extendedDnD.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.extendedDnD.locator.SpellsLocator;
import com.extendedDnD.model.Spell;

@Service
public class SpellsServiceImpl implements SpellsService {

	@Override
	public List<Spell> getAllSpells() {
		return SpellsLocator.getItems().collect(Collectors.toList());
	}
	
	@Override
	public List<Spell> getSpellsByName(String name) {
		return SpellsLocator.getItems().filter(t->t.getName().contains(name)).collect(Collectors.toList());
	}

	@Override
	public List<String> getSpellsName() {
		return SpellsLocator.getItems().map(Spell::getName).distinct().collect(Collectors.toList());
	}
	
	@Override
	public List<String> getSpellsSchools() {
		return SpellsLocator.getItems().map(Spell::getSchool).distinct().collect(Collectors.toList());
	}

	@Override
	public Spell spellMostLevel() {
		return SpellsLocator.getItems().max(Comparator.comparing(Spell::getLevel)).orElse(null);
	}

	@Override
	public List<Spell> getSpellsByRange(int range1, int range2) {
		return SpellsLocator.getItems().filter(t->Integer.parseInt(t.getRange())>=range1 && Integer.parseInt(t.getRange())<=range2).collect(Collectors.toList());
	}

	@Override
	public Spell getSpellByName(String name) {
		return SpellsLocator.getItems().filter(t->t.getName().toLowerCase().equals(name.toLowerCase())).findAny().orElse(null);
	}

	@Override
	public List<Spell> getSpellsBySchool(String school) {
		return SpellsLocator.getItems().filter(t->t.getSchool().contains(school)).collect(Collectors.toList());
	}

	@Override
	public List<String> getSpellsRoles() {
		List<String> aux = SpellsLocator.getItems().map(Spell::getRole).distinct().collect(Collectors.toList());
		List<String> result = new ArrayList<>();
		String[] parts;
		for (String res:aux) {
			parts = res.split(", ");
			for (String part:parts) {
				result.add(part);
			}
		}
		return result.stream().distinct().collect(Collectors.toList());
	}

	@Override
	public List<Spell> getSpellsByRole(String role) {
		return SpellsLocator.getItems().filter(t->t.getRole().contains(role)).collect(Collectors.toList());
	}
	
	private int formatLevel(String level) {
		return Integer.parseInt(level.replace("th-level", "").replace("Cantrip", "0").replace("nd-level", "").replace("rd-level", "").replace("st-level", ""));
	}

	@Override
	public List<Spell> getSpellsByLevel(int level1, int level2) {
		return SpellsLocator.getItems().filter(t->formatLevel(t.getLevel())>=level1 && formatLevel(t.getLevel())<=level2).collect(Collectors.toList());
	}

	@Override
	public List<Spell> sortByName(boolean asc) {
		if(asc) {
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getName)).collect(Collectors.toList());
		}
		else
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getName).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Spell> sortByRange(boolean asc) {
		if(asc) {
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getRange)).collect(Collectors.toList());
		}
		else
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getRange).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Spell> sortByRole(boolean asc) {
		if(asc) {
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getRole)).collect(Collectors.toList());
		}
		else
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getRole).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Spell> sortByLevel(boolean asc) {
		if(asc) {
			return SpellsLocator.getItems().peek(t->{
				t.setLevel(t.getLevel().replace("Cantrip", "0"));
			}).sorted(Comparator.comparing(Spell::getLevel).reversed()).peek(t->{
				t.setLevel(t.getLevel().replace("0", "Cantrip"));
				}).collect(Collectors.toList());
			}
		else
			return SpellsLocator.getItems().peek(t->{
				t.setLevel(t.getLevel().replace("Cantrip", "0"));
			}).sorted(Comparator.comparing(Spell::getLevel)).peek(t->{
				t.setLevel(t.getLevel().replace("0", "Cantrip"));
				}).collect(Collectors.toList());
	}

	@Override
	public List<Spell> sortByCasting_time(boolean asc) {
		if(asc) {
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getCasting_time)).collect(Collectors.toList());
		}
		else
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getCasting_time).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Spell> sortByDuration(boolean asc) {
		if(asc) {
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getDuration)).collect(Collectors.toList());
		}
		else
			return SpellsLocator.getItems().sorted(Comparator.comparing(Spell::getDuration).reversed()).collect(Collectors.toList());
	}

}
