
package es.dev.conexionHiberrnate.query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.dev.conexionHiberrnate.json.ASM_CATALAOG2;


public class ConsultaJSON {
	public static void main(String[] args) {
		
		SessionFactory mifactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ASM_CATALAOG2.class)
				.buildSessionFactory();
		Session miSession = mifactory.openSession();		

		try {
			miSession.beginTransaction();
			// Consulta de clientes
			String condicion = "9";
			List<ASM_CATALAOG2> losCleientes = miSession.createQuery("from ASM_CATALAOG2 cl where cl.id='" + condicion + "'")
					.getResultList();
			
			// mostrar los clientes
			
			RecorreClientes(losCleientes);
			// Commit
			miSession.getTransaction().commit();
			miSession.close();
		} finally {
			mifactory.close();
		}	
	}
	
	private static void RecorreClientes(List<ASM_CATALAOG2> losCleientes) {
		
		for (ASM_CATALAOG2 unCliente : losCleientes) {
			System.out.println(unCliente.getValue());
		}
	}


}


