package es.dev.conexionHiberrnate;



import java.util.List;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class ReadJson2 {

	public static void main(String[] args) {

        String json1 = " [\r\n" + 
        		"    {\"id\": 1, \"onclick\": \"CreateNewDoc()\"},\r\n" + 
        		"    {\"id\": 2, \"onclick\": \"OpenDoc()\"},\r\n" + 
        		"    {\"id\": 3, \"onclick\": \"CloseDoc()\"}\r\n" + 
        		" ]";
        
        JsonParser parser = new JsonParser();

        // Obtain Array
        JsonArray gsonArr = parser.parse(json1).getAsJsonArray();

        // for each element of array
        for (JsonElement obj : gsonArr) {

            // Object of array
            JsonObject gsonObj = obj.getAsJsonObject();

            // Primitives elements of object
            int dorsal = gsonObj.get("dorsal").getAsInt();
            String name = gsonObj.get("name").getAsString();
            String team = gsonObj.get("team").getAsString();

            // List of primitive elements
            JsonArray demarcation = gsonObj.get("demarcation").getAsJsonArray();
            List<String> listDemarcation = new ArrayList<String>();
            for (JsonElement demarc : demarcation) {
                listDemarcation.add(demarc.getAsString());
            }

            // Object Constructor
            FootballPlayer iniesta = new FootballPlayer(dorsal, name,
                    listDemarcation, team);
            System.out.println(iniesta);
        }

    }
	
}
