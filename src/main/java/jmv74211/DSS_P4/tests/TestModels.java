package jmv74211.DSS_P4.tests;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jmv74211.DSS_P4.models.Department;
import jmv74211.DSS_P4.models.Pharmacy;
import jmv74211.DSS_P4.models.Product;
import jmv74211.DSS_P4.models.Purchase;
import jmv74211.DSS_P4.models.ShippingCart;
import jmv74211.DSS_P4.models.Users.Administrator;
import jmv74211.DSS_P4.models.Users.Customer;
import jmv74211.DSS_P4.models.Users.Manager;


public class TestModels {


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
		
		userManager1.setPharmacyManaged(p1);
		userManager2.setPharmacyManaged(p2);
		userManager3.setPharmacyManaged(p3);
		
		manager.persist(userManager1);
		manager.persist(userManager2);
		manager.persist(userManager3);
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
	
		
		
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
		
		
		
		// PRODUCTOS
		
		Product product1 = new Product(dep1,"Producto1","Imagen1","Descripción1",false,35);
		Product product2 = new Product(dep2,"Producto2","Imagen2","Descripción2",true,10);
		Product product3 = new Product(dep3,"Producto3","Imagen3","Descripción3",false,12.5f);
		Product product4 = new Product(dep4,"Producto4","Imagen4","Descripción4",true,7.5f);
		Product product5 = new Product(dep5,"Producto5","Imagen5","Descripción5",false,35);
		
		manager.persist(product1);
		manager.persist(product2);
		manager.persist(product3);
		manager.persist(product4);
		manager.persist(product5);
		
		// COMPRAS
		
		List<Product>lista1= new ArrayList<Product>();
		List<Product>lista2= new ArrayList<Product>();
		List<Product>lista3= new ArrayList<Product>();
		
		lista1.add(product1); lista1.add(product3);
		lista2.add(product2); lista2.add(product5);
		lista3.add(product1); lista3.add(product4);
		
		Purchase purchase1 = new Purchase("2018-12-05",userCustomer1,lista1,"72343241");
		Purchase purchase2 = new Purchase("2018-12-12",userCustomer2,lista2,"12312542");
		Purchase purchase3 = new Purchase("2018-12-20",userCustomer1,lista3,"75125212");
		
		manager.persist(purchase1);
		manager.persist(purchase2);
		manager.persist(purchase3);
		
		// CARRITO
		
		ShippingCart shippingCart1 = new ShippingCart(userCustomer1);
		ShippingCart shippingCart2 = new ShippingCart(userCustomer2);
		
		shippingCart1.addProduct(product1);
		shippingCart1.addProduct(product3);
		
		shippingCart2.addProduct(product2);
		shippingCart2.addProduct(product4);
		
		manager.persist(shippingCart1);
		manager.persist(shippingCart2);
		
		manager.getTransaction().commit();
			
		
	}
	
	public static void main(String[] args) {
	
		initialInsert();

	}

}
