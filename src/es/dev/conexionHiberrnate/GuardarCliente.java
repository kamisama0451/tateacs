package es.dev.conexionHiberrnate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardarCliente {
	public static void main(String[] args) {
		SessionFactory mifactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		Session miSession = mifactory.openSession();
		
		try {
			Clientes clientes = new Clientes("asd", "asd", "asd");
			miSession.beginTransaction();
			miSession.save(clientes);
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BDDD");
			
			//lectura de registro
			
			miSession.beginTransaction();
			System.out.println("Lectura del registro con Id " + clientes.getIdcliente());
			Clientes clienteInsertadoSession = miSession.get(Clientes.class, clientes.getIdcliente());
			System.out.println("R4egistro "+ clienteInsertadoSession.getNombre());
			miSession.getTransaction().commit();
			miSession.close();
		} finally {
			mifactory.close();
		}
	}
}
