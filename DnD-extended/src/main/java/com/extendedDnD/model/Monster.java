package com.extendedDnD.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(value = { "challengeExp" })
public class Monster implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SerializedName(value="name")
    private String name;
    @SerializedName(value="meta")
    private String intro;
	@SerializedName(value="Armor Class")
	private String armor_class;
	@SerializedName(value="Hit Points")
	private String hit_points;
	@SerializedName(value="Speed")
	private String speed;
	@SerializedName(value="STR")
	private int strength;
	@SerializedName(value="STR_mod")
	private String strength_modifier;
	@SerializedName(value="DEX")
	private int dextery;
	@SerializedName(value="DEX_mod")
	private String dextery_modifier;
	@SerializedName(value="CON")
	private int constitution;
	@SerializedName(value="CON_mod")
	private String constitution_modifier;
	@SerializedName(value="INT")
	private int intellect;
	@SerializedName(value="INT_mod")
	private String intellect_modifier;
	@SerializedName(value="WIS")
	private int wisdom;
	@SerializedName(value="WIS_mod")
	private String wisdom_modifier;
	@SerializedName(value="CHA")
	private int charisma;
	@SerializedName(value="CHA_mod")
	private String charisma_modifier;
	@SerializedName(value="Saving Throws")
	private String saving_throws;
	@SerializedName(value="Skills")
	private String skills;
	@SerializedName(value="Damage Immunities")
	private String damage_inmunities;
	@SerializedName(value="Senses")
	private String senses;
	@SerializedName(value="Languages")
	private String languages;
	//Challenge contiene tanto la parte challenge como la de exp, por lo que almaceno en la propiedad ChallengeExp
	//Y luego la divido en los get de challenge y exp respectivamente para almacenar los valores en propiedades separadas
	@SerializedName(value="Challenge")
	private String challengeExp;
	
			@SuppressWarnings("unused")
			private String challenge;
			@SuppressWarnings("unused")
			private String exp;
			
	
	@SerializedName(value="Traits")
	private String traits;
	@SerializedName(value="Actions")
	private String actions;
	@SerializedName(value="Legendary Actions")
	private String legendery_actions;
	private String img_url;
	public Monster(String name, String intro, String armor_class, String hit_points, String speed, int strength,
			String strength_modifier, int dextery, String dextery_modifier, int constitution,
			String constitution_modifier, int intellect, String intellect_modifier, int wisdom, String wisdom_modifier,
			int charisma, String charisma_modifier, String saving_throws, String skills, String damage_inmunities,
			String senses, String languages, String challengeExp, String challenge, String exp, String traits,
			String actions, String legendery_actions, String img_url) {
		super();
		this.name = name;
		this.intro = intro;
		this.armor_class = armor_class;
		this.hit_points = hit_points;
		this.speed = speed;
		this.strength = strength;
		this.strength_modifier = strength_modifier;
		this.dextery = dextery;
		this.dextery_modifier = dextery_modifier;
		this.constitution = constitution;
		this.constitution_modifier = constitution_modifier;
		this.intellect = intellect;
		this.intellect_modifier = intellect_modifier;
		this.wisdom = wisdom;
		this.wisdom_modifier = wisdom_modifier;
		this.charisma = charisma;
		this.charisma_modifier = charisma_modifier;
		this.saving_throws = saving_throws;
		this.skills = skills;
		this.damage_inmunities = damage_inmunities;
		this.senses = senses;
		this.languages = languages;
		this.challengeExp = challengeExp;
		this.challenge = challenge;
		this.exp = exp;
		this.traits = traits;
		this.actions = actions;
		this.legendery_actions = legendery_actions;
		this.img_url = img_url;
	}
	public Monster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getArmor_class() {
		return armor_class;
	}
	public void setArmor_class(String armor_class) {
		this.armor_class = armor_class;
	}
	public String getHit_points() {
		return hit_points;
	}
	public void setHit_points(String hit_points) {
		this.hit_points = hit_points;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public String getStrength_modifier() {
		return strength_modifier;
	}
	public void setStrength_modifier(String strength_modifier) {
		this.strength_modifier = strength_modifier;
	}
	public int getDextery() {
		return dextery;
	}
	public void setDextery(int dextery) {
		this.dextery = dextery;
	}
	public String getDextery_modifier() {
		return dextery_modifier;
	}
	public void setDextery_modifier(String dextery_modifier) {
		this.dextery_modifier = dextery_modifier;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public String getConstitution_modifier() {
		return constitution_modifier;
	}
	public void setConstitution_modifier(String constitution_modifier) {
		this.constitution_modifier = constitution_modifier;
	}
	public int getIntellect() {
		return intellect;
	}
	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}
	public String getIntellect_modifier() {
		return intellect_modifier;
	}
	public void setIntellect_modifier(String intellect_modifier) {
		this.intellect_modifier = intellect_modifier;
	}
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	public String getWisdom_modifier() {
		return wisdom_modifier;
	}
	public void setWisdom_modifier(String wisdom_modifier) {
		this.wisdom_modifier = wisdom_modifier;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	public String getCharisma_modifier() {
		return charisma_modifier;
	}
	public void setCharisma_modifier(String charisma_modifier) {
		this.charisma_modifier = charisma_modifier;
	}
	public String getSaving_throws() {
		return saving_throws;
	}
	public void setSaving_throws(String saving_throws) {
		this.saving_throws = saving_throws;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getDamage_inmunities() {
		return damage_inmunities;
	}
	public void setDamage_inmunities(String damage_inmunities) {
		this.damage_inmunities = damage_inmunities;
	}
	public String getSenses() {
		return senses;
	}
	public void setSenses(String senses) {
		this.senses = senses;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getChallengeExp() {
		return challengeExp;
	}
	public void setChallengeExp(String challengeExp) {
		this.challengeExp = challengeExp;
	}
	public String getChallenge() {
		String[] a = getChallengeExp().split(" ");
		if (a[0].contains("/")) {
			String s = "/";
			String[] parts = a[0].split(s);
			double res = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
			return Double.toString(res);
		}
		else {return a[0];}
	}
	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}
	
	public String getExp() {
		String[] a = getChallengeExp().split(" ");
		String r = a[1]+a[2];
		return r.replace("(", "").replace("XP)", "");
	}
	public void setExp(String exp) {
		this.exp = exp;
		
	}
	public String getTraits() {
		return traits;
	}
	public void setTraits(String traits) {
		this.traits = traits;
	}
	public String getActions() {
		return actions;
	}
	public void setActions(String actions) {
		this.actions = actions;
	}
	public String getLegendery_actions() {
		return legendery_actions;
	}
	public void setLegendery_actions(String legendery_actions) {
		this.legendery_actions = legendery_actions;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
