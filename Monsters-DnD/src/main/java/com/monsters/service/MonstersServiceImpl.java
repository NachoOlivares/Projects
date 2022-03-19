package com.monsters.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.monsters.locator.DatosLocator;
import com.monsters.model.Monster;

@Service
public class MonstersServiceImpl implements MonstersService {

	
	@Override
	public List<Monster> getListMonsters(){
		return DatosLocator.getItems().collect(Collectors.toList());
	}
	
	@Override
	public List<String> getMonsters() {
		return DatosLocator.getItems().map(t -> t.getName()).collect(Collectors.toList());
	}

	@Override
	public List<Monster> getMonsterByName(String name) {
		return DatosLocator.getItems().filter(t -> t.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	@Override
	public Monster getMonsterTable(String name) {
		return DatosLocator.getItems().filter(t -> t.getName().equals(name)).findFirst().orElse(null);
	}

	@Override
	public Monster getMonsterMostStrength() {
		return DatosLocator.getItems().max(Comparator.comparing(Monster::getStrength)).orElse(null);
	}

	@Override
	public List<Monster> getMonstersSomeTrait(String trait) {
		return DatosLocator.getItems().filter(t -> t.getTraits()!=null && t.getTraits().toLowerCase().contains(trait.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Monster> getMonstersSomeaction(String action) {
		return DatosLocator.getItems().filter(t -> t.getActions()!=null && t.getActions().toLowerCase().contains(action.toLowerCase()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Monster> getMonstersByChallenge(double challenge1, double challenge2) {
		double aux;
		if (challenge1>challenge2) {aux = challenge1;}
		else {aux = challenge2;}
		
		return DatosLocator.getItems()
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
		
		return DatosLocator.getItems()
				.filter(t -> Integer.parseInt(t.getExp().replace(",", "")) >= from
				&& Integer.parseInt(t.getExp().replace(",", "")) <= to).collect(Collectors.toList());
		
		//return aux.flatMap(t -> Stream.of(t.getName(), t.getChallenge(), t.getExp(), t.getImg_url())).collect(Collectors.toList());
	}
}
