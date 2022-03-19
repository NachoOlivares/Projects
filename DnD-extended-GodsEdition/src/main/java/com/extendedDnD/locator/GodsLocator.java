package com.extendedDnD.locator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.stream.Stream;

import com.extendedDnD.model.Gods.Appendix;
import com.google.gson.Gson;

public class GodsLocator {
private final static String URL="https://raw.githubusercontent.com/NachoOlivares/json-files/main/Gods.json";
	
	public static Stream<Appendix> getItems(){
		
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
			return Arrays.stream(gson.fromJson(cuerpoRespuesta, Appendix[].class)).parallel();			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}
}
