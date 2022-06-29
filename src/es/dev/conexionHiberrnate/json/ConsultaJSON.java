
package es.dev.conexionHiberrnate.json;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import es.dev.conexionHiberrnate.Clientes;
import sun.java2d.marlin.DPathConsumer2D;

public class ConsultaJSON {
	public static void main(String[] args) {

		SessionFactory mifactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ASM_CATALAOG2.class).buildSessionFactory();
		Session miSession = mifactory.openSession();

		try {
			miSession.beginTransaction();
			// Consulta de clientes
			String condicion = "13";
			// List<ASM_CATALAOG2> losCleientes = miSession
			// .createQuery("from ASM_CATALAOG2 cl where cl.id='" + condicion +
			// "'").getResultList();
			List<ASM_CATALAOG2> losCleientes = miSession.createQuery("from ASM_CATALAOG2").getResultList();
			// mostrar los clientes

			RecorreClientes(losCleientes);
			// Commit
			miSession.getTransaction().commit();
			miSession.close();
		} finally {
			mifactory.close();
		}
	}

	/*
	 * try{ JsonParser parser = new JsonParser(); parser.parse(passed_json_string);
	 * } catch(JsonSyntaxException jse){
	 * System.out.println("Not a valid Json String:"+jse.getMessage()); }
	 */

	private static void RecorreClientes(List<ASM_CATALAOG2> losCleientes) {
		String jsonString;
		for (ASM_CATALAOG2 unCliente : losCleientes) {
			jsonString = unCliente.getValue();
		
				// System.out.println(jsonString);
				JsonParser parser = new JsonParser();
				JsonArray gsonArr = parser.parse(jsonString).getAsJsonArray();
				for (JsonElement obj : gsonArr) {
					JsonObject gsonObj = obj.getAsJsonObject();
					String name = gsonObj.get("nombre").getAsString();
					int edad = gsonObj.get("edad").getAsInt();
					boolean casad = gsonObj.get("casado").getAsBoolean();
					System.out.println(name + " " + edad + " " + casad);
				}
			
		}
	}

}
