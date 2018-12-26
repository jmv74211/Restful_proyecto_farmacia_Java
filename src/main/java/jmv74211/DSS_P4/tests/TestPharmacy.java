package jmv74211.DSS_P4.tests;
import jmv74211.DSS_P4.models.Pharmacy;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestPharmacy {
	
	private static EntityManager manager ;
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("app");

	
	private static void imprimirTodo(){
		
		List<Pharmacy> pharmacys = (List<Pharmacy>) manager.createQuery("FROM Pharmacy").getResultList();
		
		System.out.println("En esta base de datos hay " + pharmacys.size() + " farmacias");
		
		for(Pharmacy p: pharmacys){
			System.out.println(p);
		}
	}
	
	
	public static void insert(){
		
		// Creamos el gestor de persistencia EM
		emf = Persistence.createEntityManagerFactory("app");
		manager = emf.createEntityManager();
		
		Pharmacy p1 = new Pharmacy(1,"Farmacia 1", 137.15, 135.12);
		Pharmacy p2 = new Pharmacy(2,"Farmacia 2", 127.15, 151.12);
		Pharmacy p3 = new Pharmacy(3,"Farmacia 3", 117.15, 158.12);
		
		manager.getTransaction().begin();
	
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		
		manager.getTransaction().commit();
		
		
	}
	
	public static void update(){
		
		manager.getTransaction().begin();
		
		int pharmacyId = 2; // Identificador de la farmacia que queremos modificar
		Pharmacy p = manager.find(Pharmacy.class,pharmacyId);
		p.setName("Nueva farmacia " + pharmacyId);
		
		manager.getTransaction().commit();
		
	}
	
	public static void delete(){
		manager.getTransaction().begin();
		
		int pharmacyId = 3; // Identificador de la farmacia que queremos eliminar
		Pharmacy p = manager.find(Pharmacy.class,pharmacyId);
		manager.remove(p);
		
		manager.getTransaction().commit();
		
	}

	public static void main(String[] args) {
		
		// Creamos el gestor de persistencia EM
		
		manager = emf.createEntityManager();
		
		update();
		
		delete();
		
		imprimirTodo();
		
		
		manager.close();
	}

}
