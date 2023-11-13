package service.locator;

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

import model.Item;

public class ItemsLocator {	
	static String ruta="https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";
	//static String ruta="c:\\temp\\covid.json";	
	public static Stream<Item> getJsonStream(){
		Gson gson=new Gson();
		//crear objeto HttpRequest
		HttpRequest request=HttpRequest.newBuilder() //Builder
							.uri(URI.create(ruta)) //Builder
							.GET()//Builder
							.build();//HttpRequest
		//crear objeto HttpClient
		HttpClient client=HttpClient.newBuilder() //Builder
				.version(Version.HTTP_1_1) //Builder
				.build();
		
		//lanzar petición, indicando el objeto request y la manera en la que 
		//queremos obtener la respuesta
		try {
			HttpResponse response=client.send(request, BodyHandlers.ofString());
			//la cadena JSON está en el cuerpo de la respuesta
			//y se recupera de la siguiente manera
			String json=response.body().toString();
			Item[] items=gson.fromJson(json, Item[].class);
			return Arrays.stream(items);
		}
		catch(IOException | InterruptedException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
}
