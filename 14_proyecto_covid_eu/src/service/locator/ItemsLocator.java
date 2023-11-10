package service.locator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Item;

public class ItemsLocator {	
	//String ruta="https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";
	static String ruta="c:\\temp\\covid.json";	
	public static Stream<Item> getJsonStream(){
		Gson gson=new Gson();
		try(FileReader fr=new FileReader(ruta);){
			Item[]paises=gson.fromJson(fr, Item[].class);
			return Arrays.stream(paises);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}	
	}
}
