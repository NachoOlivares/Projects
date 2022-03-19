package com.extendedDnD.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.extendedDnD.locator.WeaponsLocator;
import com.extendedDnD.model.Weapon;

@Service
public class WeaponsServiceImpl implements WeaponsService {

	@Override
	public List<String> getWeaponNames() {
		return WeaponsLocator.app().map(Weapon::getName).collect(Collectors.toList());
	}
	
	@Override
	public List<Weapon> getAllWeapons(){
		return WeaponsLocator.app().collect(Collectors.toList());
	}

	@Override
	public Weapon WeaponMostDamage() {
		return WeaponsLocator.app().max(Comparator.comparing(Weapon::getDamage)).orElse(null);
	}

	@Override
	public List<Weapon> getWeaponsByType(String type) {
		return WeaponsLocator.app().filter(t->t.getType().contains(type)).collect(Collectors.toList());
	}

	@Override
	public Weapon getWeaponByName(String name) {
		return WeaponsLocator.app().filter(t->t.getName().equals(name)).findFirst().orElse(null);
	}
	
	private int formatCost(String cost) {
		return Integer.parseInt(cost.replace(" gp", "00").replace(" sp", "0").replace(" cp", ""));
	}
	
	private String reformatCost(int cost) {
		String aux = Integer.toString(cost)+"t";
		if(cost<10) {
			return aux.replace("t", " cp");
		}
		else if (cost < 100 && cost >= 10) {
			return aux.replace("0t", " sp");
		}
		return aux.replace("00t", " gp");
	}

	@Override
	public List<Weapon> getWeaponsByCost(int cost1, int cost2) {
		return WeaponsLocator.app().filter(t->formatCost(t.getCost())>=cost1 && formatCost(t.getCost())<=cost2).collect(Collectors.toList());
	}

	@Override
	public List<Weapon> getWeaponsByWeight(double weight1, double weight2) {
		return WeaponsLocator.app().peek(t->{
			t.getWeight().replace(" lb", "");
		}).filter(t->Integer.parseInt(t.getWeight())>=weight1 && Integer.parseInt(t.getWeight())<=weight2).collect(Collectors.toList());
	}

	@Override
	public List<Weapon> getWeaponByProperty(String property) {
		return WeaponsLocator.app().peek(t->{
			for (String p:t.getProperties()) {
				p.contains(property);
			}
			}).collect(Collectors.toList());
	}
	
	@Override
	public List<Weapon> sortByName(boolean asc) {
		if(asc) {
			return WeaponsLocator.app().sorted(Comparator.comparing(Weapon::getName)).collect(Collectors.toList());
		}
		else
			return WeaponsLocator.app().sorted(Comparator.comparing(Weapon::getName).reversed()).collect(Collectors.toList());
	}
	//		Collections.sort(musicalInstruments, Comparator.comparing((MusicalInstrument instrument) -> instrument.getName()));
	@Override
	public List<Weapon> sortByCost(boolean asc) {
		if(asc) {
			return WeaponsLocator.app().peek(t->t.setCost(Integer.toString(formatCost(t.getCost())))).sorted(Comparator.comparingInt(t->Integer.parseInt(((Weapon) t).getCost())).reversed()).peek(t->t.setCost(reformatCost(Integer.parseInt(t.getCost())))).collect(Collectors.toList());
		}
		else {
			return WeaponsLocator.app().peek(t->t.setCost(Integer.toString(formatCost(t.getCost())))).sorted(Comparator.comparingInt(t->Integer.parseInt(((Weapon) t).getCost()))).peek(t->t.setCost(reformatCost(Integer.parseInt(t.getCost())))).collect(Collectors.toList());

		}
	}
	
	@Override
	public List<Weapon> sortByDamage(boolean asc) {
		if(asc) {
			return WeaponsLocator.app().sorted(Comparator.comparing(Weapon::getDamage).reversed()).collect(Collectors.toList());
		}
		else
			return WeaponsLocator.app().sorted(Comparator.comparing(Weapon::getDamage)).collect(Collectors.toList());
	}
	
	@Override
	public List<Weapon> sortByWeight(boolean asc) {
		if(asc) {
			return WeaponsLocator.app().sorted(Comparator.comparing(Weapon::getWeight).reversed()).collect(Collectors.toList());
		}
		else
			return WeaponsLocator.app().sorted(Comparator.comparing(Weapon::getWeight)).collect(Collectors.toList());
	}
	
	@Override
	public List<Weapon> sortByType(boolean asc) {
		if(asc) {
			return WeaponsLocator.app().sorted(Comparator.comparing(Weapon::getType)).collect(Collectors.toList());
		}
		else
			return WeaponsLocator.app().sorted(Comparator.comparing(Weapon::getType).reversed()).collect(Collectors.toList());
	}
}
