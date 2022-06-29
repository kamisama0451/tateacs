package es.dev.conexionHiberrnate.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class jsontext {
	public static void main(String[] args) {		
	
		// TODO Auto-generated method stub
		String json1 = "[{\"nombre\": \"lelia\", \"edad\": 16, \"casado\": false}]";

		JsonParser parser = new JsonParser();
		JsonArray gsonArr = parser.parse(json1).getAsJsonArray();
		  for (JsonElement obj : gsonArr) {
			    JsonObject gsonObj = obj.getAsJsonObject();
			    
			    String name = gsonObj.get("nombre").getAsString();
			    int edad = gsonObj.get("edad").getAsInt();	         
	            boolean casad = gsonObj.get("casado").getAsBoolean();
	            
	            System.out.println(name + " "  + edad + " " + casad);
		  }

	}

}
