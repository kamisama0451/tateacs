package es.dev.conexionHiberrnate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes {
	public static void main(String[] args) {

		SessionFactory mifactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = mifactory.openSession();

		try {
			miSession.beginTransaction();
			/*
			 * 1int idCliente= 2; Clientes miclientes = miSession.get(Clientes.class,
			 * idCliente); miclientes.setNombre("Pedro");11111
			 * System.out.println("Registro insertado correctamente en BDDD");
			 */
			//miSession.createQuery("update Clientes set direccion='CDMX' where direccion LIKE 'ol%'").executeUpdate();
			miSession.createQuery("delete Clientes where idcliente=5").executeUpdate();

			// Commit
			miSession.getTransaction().commit();
			miSession.close();
		} finally {
			mifactory.close();
		}
	}
}
