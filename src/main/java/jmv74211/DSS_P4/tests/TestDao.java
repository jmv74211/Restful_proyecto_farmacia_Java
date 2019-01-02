package jmv74211.DSS_P4.tests;

import java.util.ArrayList;
import java.util.List;

import jmv74211.DSS_P4.DAO.DepartmentDao;
import jmv74211.DSS_P4.DAO.PharmacyDao;
import jmv74211.DSS_P4.DAO.PharmacyProductDao;
import jmv74211.DSS_P4.DAO.ProductDao;
import jmv74211.DSS_P4.DAO.PurchaseDao;
import jmv74211.DSS_P4.DAO.ShippingCartDao;
import jmv74211.DSS_P4.DAO.ShippingCartProductDao;
import jmv74211.DSS_P4.DAO.Users.AdministratorDao;
import jmv74211.DSS_P4.DAO.Users.CustomerDao;
import jmv74211.DSS_P4.DAO.Users.ManagerDao;
import jmv74211.DSS_P4.models.Department;
import jmv74211.DSS_P4.models.Pharmacy;
import jmv74211.DSS_P4.models.PharmacyProduct;
import jmv74211.DSS_P4.models.Product;
import jmv74211.DSS_P4.models.Purchase;
import jmv74211.DSS_P4.models.ShippingCart;
import jmv74211.DSS_P4.models.ShippingCartProduct;
import jmv74211.DSS_P4.models.Users.Administrator;
import jmv74211.DSS_P4.models.Users.Customer;
import jmv74211.DSS_P4.models.Users.Manager;


public class TestDao {
	
	public static void insertDAO(){
		
		// DAO
		ManagerDao managerDao = new ManagerDao();
		AdministratorDao administratorDao = new AdministratorDao();
		CustomerDao customerDao = new CustomerDao();
		PharmacyDao pharmacyDao = new PharmacyDao();
		DepartmentDao departmentDao = new DepartmentDao();
		ProductDao productDao = new ProductDao();
		PurchaseDao purchaseDao = new PurchaseDao();
		ShippingCartDao shippingCartDao = new ShippingCartDao();
		PharmacyProductDao pharmacyProductDao = new PharmacyProductDao();
		ShippingCartProductDao shippingCartProductDao = new ShippingCartProductDao();
				
				
				
		// MANAGERS Y FARMACIAS
		
		Manager userManager1 = new Manager("manager1@gmail.com", "pwddss", "Juan", "Martínez Valera", "1999-11-07");
		Manager userManager2 = new Manager("manager2@gmail.com", "pwddss", "Elena", "Pérez Rodríguez", "1996-08-20");
		Manager userManager3 = new Manager("manager3@gmail.com", "pwddss", "Luis", "Calvo Fernández", "1991-12-15");
		
		managerDao.save(userManager1);
		managerDao.save(userManager2);
		managerDao.save(userManager3);
		
		Pharmacy p1 = new Pharmacy("Farmacia 1", 137.15, 135.12,userManager1);
		Pharmacy p2 = new Pharmacy("Farmacia 2", 127.15, 151.12,userManager2);
		Pharmacy p3 = new Pharmacy("Farmacia 3", 117.15, 158.12,userManager3);
		
		pharmacyDao.save(p1);
		pharmacyDao.save(p2);
		pharmacyDao.save(p3);
		
		// CLIENTES
		
		Customer userCustomer1 = new Customer("customer1@gmail.com", "pwddss", "Felipe", "Ortega Romero", "1996-06-05","771989912");
		Customer userCustomer2 = new Customer("customer2@gmail.com", "pwddss", "Julia", "Ramírez Espejo", "1993-01-12","151231231");
		
		
		customerDao.save(userCustomer1);
		customerDao.save(userCustomer2);
	
		
		// ADMINISTRADOR
		
		Administrator userAdmin1 = new Administrator("admin1@gmail.com", "pwddss", "Jonathan", "Martín Valera", "1993-01-12");
		administratorDao.save(userAdmin1);
		
		// DEPARTAMENTOS
		
		Department dep1 = new Department("HERBALIST");
		Department dep2 = new Department("HYGIENE");
		Department dep3 = new Department("INFANTIL");
		Department dep4 = new Department("COSMETICS");
		Department dep5 = new Department("PERFUMES");
		
		departmentDao.save(dep1);
		departmentDao.save(dep2);
		departmentDao.save(dep3);
		departmentDao.save(dep4);
		departmentDao.save(dep5);
		
		// PRODUCTOS
		
		Product product1 = new Product(dep3,"Producto1","Imagen1","Descripción1",false,35);
		Product product2 = new Product(dep2,"Producto2","Imagen2","Descripción2",true,10);
		Product product3 = new Product(dep3,"Producto3","Imagen3","Descripción3",false,12.5f);
		Product product4 = new Product(dep4,"Producto4","Imagen4","Descripción4",true,7.5f);
		Product product5 = new Product(dep5,"Producto5","Imagen5","Descripción5",false,35);
		
		productDao.save(product1);
		productDao.save(product2);
		productDao.save(product3);
		productDao.save(product4);
		productDao.save(product5);
		
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
		
		purchaseDao.save(purchase1);
		purchaseDao.save(purchase2);
		purchaseDao.save(purchase3);
		
		// CARRITO
		
		ShippingCart shippingCart1 = new ShippingCart(userCustomer1);
		ShippingCart shippingCart2 = new ShippingCart(userCustomer2);
		
		shippingCartDao.save(shippingCart1);
		shippingCartDao.save(shippingCart2);
		
		// PHARMACY-PRODUCT
		
		//PharmacyProduct pp1 = new PharmacyProduct(pharmacyDao.getPharmacy(2), productDao.getProduct(2),3);
		// PharmacyId, ProductId, quantity
		PharmacyProduct pp1 = new PharmacyProduct(2,2,3);
		
		
		pharmacyProductDao.save(pp1);
		
		
		
		// SHIPPINGCART-PRODUCT
		ShippingCartProduct shp1 = new ShippingCartProduct(shippingCart1.getCartId(),4,2);
		
		//ShippingCartProductDao shippingCartProductDao = new ShippingCartProductDao();
		
		shippingCartProductDao.save(shp1);
		
		/*ShippingCartProduct shp2 = new ShippingCartProduct(shippingCart1.getCartId(),2,2);
		
		
		
		
		
		
		shippingCartProductDao.save(shp2);
		
		*/
		
	}
	

	public static void main(String[] args) {
		
		/*PharmacyDao pharmacyDao = new PharmacyDao();
		
		ProductDao productDao = new ProductDao();
		
		Pharmacy pharmacy2 = pharmacyDao.getPharmacy(2);
		Product product5 = productDao.getProduct(5);
		Product product2 = productDao.getProduct(2);*/
		
		
		//insertDAO();
		
		
		//pharmacy2.addProduct(product5, 2);
		//pharmacy2.addProduct(product2, 2);
		
	}

}
