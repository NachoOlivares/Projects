package com.extendedDnD.locator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.extendedDnD.model.Weapon;
import com.google.gson.Gson;


public class WeaponsLocator {
private final static String URLBASE="https://raw.githubusercontent.com/NachoOlivares/json-files/main/";
private final static String[] URLADD = {"FirearmsWeapons.json", "Martial-meleeWeapons.json", "Martial-rangedWeapons.json", "Simple-meleeWeapons.json", "Simple-rangedWeapons.json"};


	private static Stream<Weapon> getWeapons(String url, String type){
		
		HttpRequest request=HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();
		HttpClient client=HttpClient.newBuilder()
				.version(Version.HTTP_1_1)
				.build();
		try {
			HttpResponse<String> response=client.send(request, BodyHandlers.ofString());
			String cuerpoRespuesta=response.body();
			//convertir esa cadena JSON que viene el cuerpo de la respuesta
			//en un Stream de objetos Datos
			Gson gson=new Gson();
			return Arrays.stream(gson.fromJson(cuerpoRespuesta, Weapon[].class)).peek(t->t.setType(type)).parallel();			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	public static Stream<Weapon> app(){
		List<Weapon> weapons = new ArrayList<>();
		Stream<Weapon> weaponsType;
		String type = "";
		
		for (String add:URLADD) {
			String finalURL = URLBASE+add;
			type = add.replace("Weapons.json", "").replace("-", " ");
			
			weaponsType = getWeapons(finalURL, type);
			weapons.addAll(weaponsType.toList());
		}
		return weapons.stream();
	}
}
