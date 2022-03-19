package com.extendedDnD.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extendedDnD.model.Monster;
import com.extendedDnD.model.Spell;
import com.extendedDnD.model.User;
import com.extendedDnD.model.Weapon;
import com.extendedDnD.service.MonstersService;
import com.extendedDnD.service.SpellsService;
import com.extendedDnD.service.UserService;
import com.extendedDnD.service.WeaponsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("Buscador de monstruos")
@RestController
@CrossOrigin("*")
public class ExtendedController {

	@Autowired
	MonstersService mapp;
	@Autowired
	WeaponsService wapp;
	@Autowired
	SpellsService sapp;
	@Autowired
	UserService uapp;

	@ApiOperation("new user")
	@PostMapping(value="/newUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String newUser(@RequestBody User user){
		return uapp.InsertUser(user);
	}
	@ApiOperation("user login")
	@GetMapping(value="/userLogin")
	public String userLogin(@RequestParam ("email") String email, @RequestParam ("password") String password){
		return uapp.UserAuth(email, password);
	}

	@RolesAllowed({"ADMIN"})
	@ApiOperation("user delete")
	@DeleteMapping(value="/userDelete")
	public String userDelete(@RequestParam("email") String email, @RequestParam("password") String password){
		return uapp.deleteByEmail(email, password);
	}

	@ApiOperation("Full list of monsters")
	@GetMapping(value="/list")
	public List<Monster> getList(){
		return mapp.getListMonsters();
	}
	
	@ApiOperation("List of monsters names")
	@GetMapping(value="/monsters")
	public List<String> getMonsters(){
		return mapp.getMonsters();
	}
	
	@ApiOperation("List type of damage inmunity")
	@GetMapping(value="/monsters/damage_inmunity")
	public List<String> getDamageInmunitiesTypes() {
		return mapp.getDamageInmunitiesTypes();
	}
	
	@ApiOperation("Monster with most strength")
	@GetMapping(value="/monster/mostSTR")
	public Monster getMonsterMostStrength() {
		return mapp.getMonsterMostStrength();
	}
	
	@ApiOperation("Show by trait")
	@GetMapping(value="/monsters/trait")
	public List<Monster> getMonstersByTrait(@ApiParam("Trait to search") @PathVariable("trait") @RequestParam String trait){
		return mapp.getMonstersSomeTrait(trait);
	}	
	
	@ApiOperation("Show by action")
	@GetMapping(value="/monsters/action")
	public List<Monster> getMonstersByAction(@ApiParam("Action to search") @PathVariable("action") @RequestParam String action){
		return mapp.getMonstersSomeTrait(action);
	}	
	
	@ApiOperation("Show by name")
	@GetMapping(value="/monsters/name")
	public List<Monster> getMonsterByName(@ApiParam("Name of monster") @PathVariable("name") @RequestParam String name){
		return mapp.getMonsterByName(name);
	}
	
	@ApiOperation("Show all data of monster")
	@GetMapping(value="/monster/data")
	public Monster getMonsterTable(@ApiParam("Name of monster") @RequestParam String name){
		return mapp.getMonsterTable(name);
	}
	
	@ApiOperation("Show by challenge")
	@GetMapping(value="/monsters/challenge")
	public List<Monster> getMonsterByChallenge(@ApiParam("from level") @RequestParam("challenge1") double challenge1, @ApiParam("To level") @RequestParam("challenge2") double challenge2){
		return mapp.getMonstersByChallenge(challenge1, challenge2);
	}
	
	@ApiOperation("Show by experience")
	@GetMapping(value="/monsters/exp")
	public List<Monster> getMonstersByExp(@ApiParam("minimum exp") @RequestParam("exp1") String exp1, @ApiParam("maximum exp") @RequestParam("exp2") String exp2){
		return mapp.getMonstersByExp(exp1, exp2);
	}
	

	@ApiOperation("Sort by name")
	@GetMapping(value="/monsters/sortName")
	public List<Monster> sortByName(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return mapp.sortByName(asc);
	}
	@ApiOperation("Sort by intro")
	@GetMapping(value="/monsters/sortIntro")
	public List<Monster> sortByIntro(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return mapp.sortByIntro(asc);
	}
	@ApiOperation("Sort by damage inmunities")
	@GetMapping(value="/monsters/sortDamage_inmunities")
	public List<Monster> sortByDamage_inmunities(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return mapp.sortByDamage_inmunities(asc);
	}
	@ApiOperation("Sort by hit points")
	@GetMapping(value="/monsters/sortHit_points")
	public List<Monster> sortByHit_points(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return mapp.sortByHit_points(asc);
	}
	@ApiOperation("Sort by challenge")
	@GetMapping(value="/monsters/sortChallenge")
	public List<Monster> sortByChallenge(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return mapp.sortByChallenge(asc);
	}
	@ApiOperation("Sort by experiene")
	@GetMapping(value="/monsters/sortExp")
	public List<Monster> sortByExp(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return mapp.sortByExp(asc);
	}
	
	
	
	@ApiOperation("List all weapons")
	@GetMapping(value="/weapons/list")
	public List<Weapon> getWeaponList(){
		return wapp.getAllWeapons();
	}

	@ApiOperation("Weapon by name")
	@GetMapping(value="/weapon/name")
	public Weapon getWeaponByName(@ApiParam("name") @RequestParam("name") String name){
		return wapp.getWeaponByName(name);
	}
	
	@ApiOperation("List name of weapons")
	@GetMapping(value="/weapons/name")
	public List<String> getWeaponsName(){
		return wapp.getWeaponNames();
	}
	
	@ApiOperation("Get most powerful weapon")
	@GetMapping(value="/weapons/mostDamage")
	public Weapon getMostDamageWeapon(){
		return wapp.WeaponMostDamage();
	}
	
	@ApiOperation("Weapons by type")
	@GetMapping(value="/weapons/type")
	public List<Weapon> getWeaponsByType(@ApiParam("type to list") @RequestParam("type") String type){
		return wapp.getWeaponsByType(type);
	}
	
	@ApiOperation("get Weapons by cost")
	@GetMapping(value="/weapons/cost")
	public List<Weapon> getWeaponsByCost(@ApiParam("minimum cost") @RequestParam("cost1") int cost1, @ApiParam("maximum cost") @RequestParam("cost2") int cost2){
		return wapp.getWeaponsByCost(cost1, cost2);
	}
	
	@ApiOperation("get Weapons by weight")
	@GetMapping(value="/weapons/weight")
	public List<Weapon> getWeaponsByWeight(@ApiParam("minimum weight") @RequestParam("weight1") int weight1, @ApiParam("maximum weight") @RequestParam("weight2") int weight2){
		return wapp.getWeaponsByWeight(weight1, weight2);
	}
	
	@ApiOperation("get Weapons by property")
	@GetMapping(value="/weapons/property")
	public List<Weapon> getWeaponByProperty(@ApiParam("property to list") @RequestParam("property") String property){
		return wapp.getWeaponByProperty(property);
	}
	
	@ApiOperation("sort by name")
	@GetMapping(value="/weapons/sortName")
	public List<Weapon> sortWeaponsByName(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return wapp.sortByName(asc);
	}
	
	@ApiOperation("sort by type")
	@GetMapping(value="/weapons/sortType")
	public List<Weapon> sortWeaponsByType(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return wapp.sortByType(asc);
	}
	
	@ApiOperation("sort by damage")
	@GetMapping(value="/weapons/sortDamage")
	public List<Weapon> sortWeaponsByDamage(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return wapp.sortByDamage(asc);
	}
	
	@ApiOperation("sort by cost")
	@GetMapping(value="/weapons/sortCost")
	public List<Weapon> sortWeaponsByCost(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return wapp.sortByCost(asc);
	}
	
	@ApiOperation("sort by weight")
	@GetMapping(value="/weapons/sortWeight")
	public List<Weapon> sortWeaponsByWeight(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return wapp.sortByWeight(asc);
	}
	
	

	@ApiOperation("List all spells")
	@GetMapping(value="/spells/list")
	public List<Spell> getSpellsList(){
		return sapp.getAllSpells();
	}

	@ApiOperation("List spells by name")
	@GetMapping(value="/spells/name")
	public List<Spell> getSpellsByName(@ApiParam("name") @RequestParam("name") String name){
		return sapp.getSpellsByName(name);
	}

	@ApiOperation("Spell by name")
	@GetMapping(value="/spell/name")
	public Spell getSpellByName(@ApiParam("name") @RequestParam("name") String name){
		return sapp.getSpellByName(name);
	}

	@ApiOperation("List spells by level")
	@GetMapping(value="/spells/level")
	public List<Spell> getSpellByLevel(@ApiParam("from") @RequestParam("level1") int level1, @ApiParam("to") @RequestParam("level2") int level2){
		return sapp.getSpellsByLevel(level1, level2);
	}

	@ApiOperation("List spells by class")
	@GetMapping(value="/spells/class")
	public List<Spell> getSpellByRole(@ApiParam("role (class)") @RequestParam("role") String role){
		return sapp.getSpellsByRole(role);
	}

	@ApiOperation("List spells by school")
	@GetMapping(value="/spells/school")
	public List<Spell> getSpellBySchool(@ApiParam("school to search") @RequestParam("school") String school){
		return sapp.getSpellsBySchool(school);
	}

	@ApiOperation("Schools of magic")
	@GetMapping(value="/spells/schoolsType")
	public List<String> getSchoolsType(){
		return sapp.getSpellsSchools();
	}

	@ApiOperation("Classes that can use magic")
	@GetMapping(value="/spells/classes")
	public List<String> getSchoolsRoles(){
		return sapp.getSpellsRoles();
	}
	
	@ApiOperation("sort spells by name")
	@GetMapping(value="/spells/sortName")
	public List<Spell> sortSpellsByName(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return sapp.sortByName(asc);
	}
	
	@ApiOperation("sort spells by range")
	@GetMapping(value="/spells/sortRange")
	public List<Spell> sortSpellsByRange(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return sapp.sortByRange(asc);
	}
	
	@ApiOperation("sort spells by role")
	@GetMapping(value="/spells/sortRole")
	public List<Spell> sortSpellsByRole(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return sapp.sortByRole(asc);
	}
	
	@ApiOperation("sort spells by level")
	@GetMapping(value="/spells/sortLevel")
	public List<Spell> sortSpellsByLevel(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return sapp.sortByLevel(asc);
	}
	
	@ApiOperation("sort spells by casting time")
	@GetMapping(value="/spells/sortCasting_time")
	public List<Spell> sortSpellsByCasting_time(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return sapp.sortByCasting_time(asc);
	}
	
	@ApiOperation("sort spells by duration")
	@GetMapping(value="/spells/sortDuration")
	public List<Spell> sortSpellsByDuration(@ApiParam("ascendent? y/n") @RequestParam("asc") boolean asc){
		return sapp.sortByDuration(asc);
	}
}
