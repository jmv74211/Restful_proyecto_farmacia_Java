package jmv74211.DSS_P4.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pharmacy_Product")
@IdClass(value = PharmacyProductPK.class)
public class PharmacyProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	//@OneToOne
	//@JoinColumn(name = "pharmacyId")
	@Column
	//private Pharmacy pharmacy;
	private int pharmacyId;
	
	@Id
	//@OneToOne
	//@JoinColumn(name = "productId")
	@Column
	//private Product product;
	private int productId;
	
	@Column(name = "quantity")
	private int quantity;

	public PharmacyProduct(){
		
	}

	public PharmacyProduct(int pharmacyId, int productId, int quantity) {
		super();
		this.pharmacyId = pharmacyId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(int pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	/*
	public PharmacyProduct(Pharmacy pharmacy, Product product, int quantity) {
		this.pharmacy = pharmacy;
		this.product = product;
		this.quantity = quantity;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "PharmacyProduct [pharmacy=" + pharmacy + ", product=" + product + ", quantity=" + quantity + "]";
	}
	*/
	
	
}
