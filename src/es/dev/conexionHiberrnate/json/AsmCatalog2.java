package es.dev.conexionHiberrnate.json;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AsmCatalog2 {
	public static void main(String[] args) {

		SessionFactory mifactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ASM_CATALAOG2.class)
				.buildSessionFactory();
		Session miSession = mifactory.openSession();
		
		try {
			ASM_CATALAOG2 asmCatalog =new ASM_CATALAOG2("[{\"nombre\": \"lelia2\", \"edad\": 14, \"casado\": false}]", 1);
			//Clientes clientes = new Clientes("asd", "asd", "asd");
			miSession.beginTransaction();
			miSession.save(asmCatalog);
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BDDD");
			
			//lectura de registro
			
			miSession.beginTransaction();
			System.out.println("Lectura del registro con Id " + asmCatalog.getId());
			//Clientes clienteInsertadoSession = miSession.get(Clientes.class, clientes.getIdcliente());
			//System.out.println("R4egistro "+ clienteInsertadoSession);
			miSession.getTransaction().commit();
			miSession.close();
		} finally {
			mifactory.close();
		}
		
		
	}
}
