package jmv74211.DSS_P4.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Pharmacy_Product")
@IdClass(value = PharmacyProductPK.class)
public class PharmacyProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int pharmacyId;
	
	@Id
	@Column
	private int productId;
	
	@Column(name = "quantity")
	private int quantity;

	public PharmacyProduct(){
		
	}

	public PharmacyProduct(int pharmacyId, int productId, int quantity) {
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
	
	public boolean hasValidAttributes(){
		
		if(this == null || this.quantity < 0 )
			
			return false;
		
		else
			return true;
	}
		
}
