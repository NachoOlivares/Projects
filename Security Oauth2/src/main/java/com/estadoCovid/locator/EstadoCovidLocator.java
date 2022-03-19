package com.estadoCovid.locator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.stream.Stream;

import com.estadoCovid.model.Datos;
import com.estadoCovid.model.Estado;
import com.google.gson.Gson;


public class EstadoCovidLocator {

	private final static String url="https://datos.comunidad.madrid/catalogo/dataset/7da43feb-8d4d-47e0-abd5-3d022d29d09e/resource/877fa8f5-cd6c-4e44-9df5-0fb60944a841/download/covid19_tia_muni_y_distritos_s.json";

	public static Stream<Estado> getItems(){
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
			return Arrays.stream(gson.fromJson(cuerpoRespuesta, Datos.class).getEstados()).parallel();			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}
}
