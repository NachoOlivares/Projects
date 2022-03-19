package com.monsters.locator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.monsters.model.Monster;


public class DatosLocator {
private final static String URL="https://gist.githubusercontent.com/tkfu/9819e4ac6d529e225e9fc58b358c3479/raw/d4df8804c25a662efc42936db60cfbc0a5b19db8/srd_5e_monsters.json";
	
	public static Stream<Monster> getItems(){
		
		HttpRequest request=HttpRequest.newBuilder()
				.uri(URI.create(URL))
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
			return Arrays.stream(gson.fromJson(cuerpoRespuesta, Monster[].class)).parallel();			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}
}
