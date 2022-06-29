package es.dev.pruevashibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruevasJDBC {

	public static void main(String[] args) {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
			String usurio = "system";
			String pasw = "1234";
			// 1-Cramos la conexion
			Connection miCoonecxion = DriverManager.getConnection(url, usurio, pasw);
			System.out.println("conexion Exitosa !!");
		} catch (Exception e) {
			System.out.println("No COnecta ");
			e.printStackTrace();
		}
	}
}
