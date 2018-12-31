package jmv74211.DSS_P4.models;

import java.io.Serializable;

/**
 * Clase para definir la claves primarias compuestas de la tabla Pharmacy_Product
 */

public class PharmacyProductPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//private Pharmacy pharmacy;
	private int pharmacyId;
	
	//private Product product;
	private int productId;
	
	public PharmacyProductPK(){
		
	}
	
	
	
	/*
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
	*/
	
	
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



	@Override
	public boolean equals(Object obj){
		return super.equals(obj);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode();
	}
	    
}
