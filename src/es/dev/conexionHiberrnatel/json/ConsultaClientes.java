package es.dev.conexionHiberrnatel.json;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.dev.conexionHiberrnate.Clientes;

public class ConsultaClientes {
	public static void main(String[] args) {

		SessionFactory mifactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = mifactory.openSession();

		try {
			miSession.beginTransaction();
			// Consulta de clientes
			List<Clientes> losCleientes = miSession.createQuery("from Clientes").getResultList();

			// mostrar los clientes
			RecorreClientes(losCleientes);
			// Consulta con where =
			String condicion = "pdreo";
			losCleientes = miSession.createQuery("from Clientes cl where cl.nombre='" + condicion + "'")
					.getResultList();
			RecorreClientes(losCleientes);
			//muestra un and o or
			losCleientes = miSession.createQuery("from Clientes cl where cl.nombre='" + condicion + "'" + "or cl.direccion ='Tepexi'").getResultList();

			RecorreClientes(losCleientes);
			
			// Commit
			miSession.getTransaction().commit();
			miSession.close();
		} finally {
			mifactory.close();
		}

	}

	private static void RecorreClientes(List<Clientes> losCleientes) {
		
		for (Clientes unCliente : losCleientes) {
			System.out.println(unCliente.getNombre());
		}
	}
}
