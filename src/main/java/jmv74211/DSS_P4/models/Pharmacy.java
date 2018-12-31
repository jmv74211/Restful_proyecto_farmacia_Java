package jmv74211.DSS_P4.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import jmv74211.DSS_P4.models.Users.User;
import jmv74211.DSS_P4.DAO.PharmacyProductDao;
import jmv74211.DSS_P4.models.Users.Manager;


@Entity
@Table(name = "Pharmacy")
public class Pharmacy implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pharmacyId")
	private int pharmacyId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "length")
	private double length;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userManagerId")
	private Manager manager;
	
	/*@ManyToMany  
	@JoinTable(name="Pharmacy_Product", 
	 		joinColumns=@JoinColumn(name="pharmacyId"), 
	 		inverseJoinColumns=@JoinColumn(name="ProductId"))*/

	// Tengo que crear este registro con @OneToMany o vicerversa??
	//@OneToMany
	//private List<PharmacyProduct> products;
	
	public Pharmacy(){
		
		//this.products = new ArrayList<PharmacyProduct>();
	}
	
	public Pharmacy(String name, double latitude, double length, Manager manager) {
		this.name = name;
		this.latitude = latitude;
		this.length = length;
		this.manager = manager;
		
		//this.products = new ArrayList<PharmacyProduct>();
	}

	public int getId() {
		return pharmacyId;
	}

	public void setId(int id) {
		this.pharmacyId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	

	public int getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(int pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public User getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public void addProduct(Product product, int quantity){
		
		PharmacyProductDao pharmacyProductDao = new PharmacyProductDao();
		
		pharmacyProductDao.addProduct(this,product, quantity);
	}
/*
	public List<PharmacyProduct> getProducts() {
		return products;
	}

	public void setProducts(List<PharmacyProduct> products) {
		this.products = products;
	}*/

	@Override
	public String toString() {
		return "Pharmacy [id=" + pharmacyId + ", name=" + name + ", latitude=" + latitude + ", length=" + length + "]";
	}
	
	

}
