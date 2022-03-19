package com.monsters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monsters.model.Monster;
import com.monsters.service.MonstersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("Buscador de monstruos")
@RestController
@CrossOrigin("*")
public class MonstersController {

	@Autowired
	MonstersService app;
	
	@ApiOperation("Full list of monsters")
	@GetMapping(value="/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Monster> getList(){
		return app.getListMonsters();
	}
	
	@ApiOperation("List of monsters names")
	@GetMapping(value="/monsters", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getMonsters(){
		return app.getMonsters();
	}
	
	@ApiOperation("Monster with most strength")
	@GetMapping(value="/monster/mostSTR", produces = MediaType.APPLICATION_JSON_VALUE)
	public Monster getMonsterMostStrength() {
		return app.getMonsterMostStrength();
	}
	
	@ApiOperation("Show by trait")
	@GetMapping(value="/monsters/trait", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Monster> getMonstersByTrait(@ApiParam("Trait to search") @PathVariable("trait") @RequestParam String trait){
		return app.getMonstersSomeTrait(trait);
	}	
	
	@ApiOperation("Show by action")
	@GetMapping(value="/monsters/action", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Monster> getMonstersByAction(@ApiParam("Action to search") @PathVariable("action") @RequestParam String action){
		return app.getMonstersSomeTrait(action);
	}	
	
	@ApiOperation("Show by name")
	@GetMapping(value="/monsters/name", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Monster> getMonsterByName(@ApiParam("Name of monster") @PathVariable("name") @RequestParam String name){
		return app.getMonsterByName(name);
	}
	
	@ApiOperation("Show all data of monster")
	@GetMapping(value="/monster/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public Monster getMonsterTable(@ApiParam("Name of monster") @RequestParam String name){
		return app.getMonsterTable(name);
	}
	
	@ApiOperation("Show by challenge")
	@GetMapping(value="/monsters/challenge", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Monster> getMonsterByChallenge(@ApiParam("from level") @RequestParam("challenge1") double challenge1, @ApiParam("To level") @RequestParam("challenge2") double challenge2){
		return app.getMonstersByChallenge(challenge1, challenge2);
	}
	
	@ApiOperation("Show by experience")
	@GetMapping(value="/monsters/exp", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Monster> getMonstersByExp(@ApiParam("minimum exp") @PathVariable("exp1") @RequestParam String exp1, @ApiParam("maximum exp") @PathVariable("exp2") @RequestParam String exp2){
		return app.getMonstersByExp(exp1, exp2);
	}
}
