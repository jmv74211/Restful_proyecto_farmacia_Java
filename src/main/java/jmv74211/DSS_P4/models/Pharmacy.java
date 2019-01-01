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
	
	
	public Pharmacy(){
		this.latitude = 0;
		this.length = 0;
	}
	
	public Pharmacy(String name, double latitude, double length, Manager manager) {
		this.name = name;
		this.latitude = latitude;
		this.length = length;
		this.manager = manager;
		
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

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public void addProduct(Product product, int quantity){
		
		PharmacyProductDao pharmacyProductDao = new PharmacyProductDao();
		
		pharmacyProductDao.addProduct(this,product, quantity);
	}
	
	public boolean hasValidAttributes(){
		
		if(this == null || this.latitude == 0 || this.length == 0 || this.manager == null 
				|| this.name == null)
			
			return false;
		
		else
			return true;
	}


	@Override
	public String toString() {
		return "Pharmacy [id=" + pharmacyId + ", name=" + name + ", latitude=" + latitude + ", length=" + length + "]";
	}
	
	

}
