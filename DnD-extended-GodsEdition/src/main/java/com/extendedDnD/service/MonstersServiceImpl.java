package com.extendedDnD.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.extendedDnD.locator.MonstersLocator;
import com.extendedDnD.model.Monster;

@Service
public class MonstersServiceImpl implements MonstersService {

	
	@Override
	public List<Monster> getListMonsters(){
		return MonstersLocator.getItems().collect(Collectors.toList());
	}
	
	@Override
	public List<String> getMonsters() {
		return MonstersLocator.getItems().map(t -> t.getName()).collect(Collectors.toList());
	}
	
	@Override
	public List<String> getDamageInmunitiesTypes() {
		return MonstersLocator.getItems().map(Monster::getDamage_inmunities).distinct().collect(Collectors.toList());
	}

	@Override
	public List<Monster> getMonsterByName(String name) {
		return MonstersLocator.getItems().filter(t -> t.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	@Override
	public Monster getMonsterTable(String name) {
		return MonstersLocator.getItems().filter(t -> t.getName().equals(name)).findFirst().orElse(null);
	}

	@Override
	public Monster getMonsterMostStrength() {
		return MonstersLocator.getItems().max(Comparator.comparing(Monster::getStrength)).orElse(null);
	}

	@Override
	public List<Monster> getMonstersSomeTrait(String trait) {
		return MonstersLocator.getItems().filter(t -> t.getTraits()!=null && t.getTraits().toLowerCase().contains(trait.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Monster> getMonstersSomeaction(String action) {
		return MonstersLocator.getItems().filter(t -> t.getActions()!=null && t.getActions().toLowerCase().contains(action.toLowerCase()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Monster> getMonstersByChallenge(double challenge1, double challenge2) {
		double aux;
		if (challenge1>challenge2) {aux = challenge1;}
		else {aux = challenge2;}
		
		return MonstersLocator.getItems()
				.filter(t -> Double.parseDouble(t.getChallenge()) >= challenge1
				&& Double.parseDouble(t.getChallenge()) <= aux).collect(Collectors.toList());
		
		//return aux.flatMap(t -> Stream.of(t.getName(), t.getChallenge(), t.getImg_url())).collect(Collectors.toList());
	}
	
	@Override
	public List<Monster> getMonstersByExp(String exp1, String exp2){
		int from = Integer.parseInt(exp1);
		int to;
		if (from>Integer.parseInt(exp2)) {to = from;}
		else {to = Integer.parseInt(exp2);}
		
		return MonstersLocator.getItems()
				.filter(t -> Integer.parseInt(t.getExp().replace(",", "")) >= from
				&& Integer.parseInt(t.getExp().replace(",", "")) <= to).collect(Collectors.toList());
		
		//return aux.flatMap(t -> Stream.of(t.getName(), t.getChallenge(), t.getExp(), t.getImg_url())).collect(Collectors.toList());
	}
	
	@Override
	public List<Monster> sortByName(boolean asc) {
		if(asc) {
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getName)).collect(Collectors.toList());
		}
		else
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getName).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Monster> sortByIntro(boolean asc) {
		if(asc) {
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getIntro)).collect(Collectors.toList());
		}
		else
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getIntro).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Monster> sortByDamage_inmunities(boolean asc) {
		if(asc) {
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getDamage_inmunities)).collect(Collectors.toList());
		}
		else
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getDamage_inmunities).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Monster> sortByHit_points(boolean asc) {
		if(asc) {
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getHit_points).reversed()).collect(Collectors.toList());
		}
		else
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getHit_points)).collect(Collectors.toList());
	}

	@Override
	public List<Monster> sortByChallenge(boolean asc) {
		if(asc) {
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getChallenge).reversed()).collect(Collectors.toList());
		}
		else
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getChallenge)).collect(Collectors.toList());
	}

	@Override
	public List<Monster> sortByExp(boolean asc) {
		if(asc) {
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getExp).reversed()).collect(Collectors.toList());
		}
		else
			return MonstersLocator.getItems().sorted(Comparator.comparing(Monster::getExp)).collect(Collectors.toList());
	}
}
