package es.dev.conexionHiberrnate.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.xml.internal.resolver.Catalog;

public class json333 {

	public static void main(String[] args) {
		String jsonString = "[\r\n" + "    {\"id\": 1, \"subPriority\": \"CreateNewDoc()\"},\r\n"
				+ "    {\"id\": 2, \"subPriority\": \"OpenDoc()\"},\r\n"
				+ "    {\"id\": 3, \"subPriority\": \"CloseDoc()\"}\r\n" + " ]";

		Gson gson = new Gson();
		catalog[] catalogs = gson.fromJson(jsonString, catalog[].class);

		for (catalog catalog : catalogs) {
			System.out.println(catalog);
		}

		/*-----*/
		JsonParser parser = new JsonParser();
		JsonArray gsonArr = parser.parse(jsonString).getAsJsonArray();
		for (JsonElement obj : gsonArr) {
			
			 JsonObject gsonObj = obj.getAsJsonObject();
			 int id = gsonObj.get("id").getAsInt();
	         String subPriority = gsonObj.get("subPriority").getAsString();
	        
	         catalog ca = new catalog(id,subPriority);
	         System.out.println(ca);
	         
		}
		/*-----*/
	}
}

class catalog {

	private int id;
	private String subPriority;

	public catalog(int id, String subPriority) {
		this.id = id;
		this.subPriority = subPriority;
	}

	@Override
	public String toString() {
		return "catalog [id=" + id + ", subPriority=" + subPriority + "]";
	}
}
