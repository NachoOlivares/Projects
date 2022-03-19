package com.extendedDnD.service;

import java.util.List;

import com.extendedDnD.model.Weapon;


public interface WeaponsService {
	
	List<String> getWeaponNames();
	
	List<Weapon> getAllWeapons();

	Weapon WeaponMostDamage();

	List<Weapon> getWeaponsByType(String type);
	
	Weapon getWeaponByName(String name);

	List<Weapon> getWeaponsByCost(int cost1, int cost2);

	List<Weapon> getWeaponsByWeight(double weight1, double weight2);
	
	List<Weapon> getWeaponByProperty(String property);

	List<Weapon> sortByName(boolean asc);

	List<Weapon> sortByCost(boolean asc);

	List<Weapon> sortByDamage(boolean asc);

	List<Weapon> sortByWeight(boolean asc);

	List<Weapon> sortByType(boolean asc);
}
