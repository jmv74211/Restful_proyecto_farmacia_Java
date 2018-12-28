package jmv74211.DSS_P4.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jmv74211.DSS_P4.models.Department;
import jmv74211.DSS_P4.models.Pharmacy;
import jmv74211.DSS_P4.models.Users.Administrator;
import jmv74211.DSS_P4.models.Users.Customer;
import jmv74211.DSS_P4.models.Users.Manager;


public class TestUsers {


	private static EntityManager manager ;
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("app");
	
	
	public static void initialInsert(){
		
		System.out.println("Doing the initial insert...");
		
		// Creamos el gestor de persistencia EM
		emf = Persistence.createEntityManagerFactory("app");
		manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		
		// MANAGERS Y FARMACIAS
		
		Manager userManager1 = new Manager("manager1@gmail.com", "pwddss", "Juan", "Martínez Valera", "1999-11-07");
		Manager userManager2 = new Manager("manager2@gmail.com", "pwddss", "Elena", "Pérez Rodríguez", "1996-08-20");
		Manager userManager3 = new Manager("manager3@gmail.com", "pwddss", "Luis", "Calvo Fernández", "1991-12-15");
		
		Pharmacy p1 = new Pharmacy("Farmacia 1", 137.15, 135.12,userManager1);
		Pharmacy p2 = new Pharmacy("Farmacia 2", 127.15, 151.12,userManager2);
		Pharmacy p3 = new Pharmacy("Farmacia 3", 117.15, 158.12,userManager3);
		
		userManager1.setPharmarcyManaged(p1);
		userManager2.setPharmarcyManaged(p2);
		userManager3.setPharmarcyManaged(p3);
		
		manager.persist(userManager1);
		manager.persist(userManager2);
		manager.persist(userManager3);
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		
		// FIN MANAGERS Y FARMACIAS
		
		// CLIENTES
		
		Customer userCustomer1 = new Customer("customer1@gmail.com", "pwddss", "Felipe", "Ortega Romero", "1996-06-05","771989912");
		Customer userCustomer2 = new Customer("customer2@gmail.com", "pwddss", "Julia", "Ramírez Espejo", "1993-01-12");
		
		
		manager.persist(userCustomer1);
		manager.persist(userCustomer2);
		
		// ADMINISTRADOR
		
		Administrator userAdmin1 = new Administrator("admin1@gmail.com", "pwddss", "Jonathan", "Martín Valera", "1993-01-12");
		manager.persist(userAdmin1);
		
		// DEPARTAMENTOS
		Department dep1 = new Department("MEDICINES");
		Department dep2 = new Department("HYGIENE");
		Department dep3 = new Department("INFANTIL");
		Department dep4 = new Department("COSMETICS");
		Department dep5 = new Department("PERFUMES");
		
		manager.persist(dep1);
		manager.persist(dep2);
		manager.persist(dep3);
		manager.persist(dep4);
		manager.persist(dep5);
		
		manager.getTransaction().commit();
		
		
	}
	
	public static void main(String[] args) {
	
		initialInsert();

	}

}
