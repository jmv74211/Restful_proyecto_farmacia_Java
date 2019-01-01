package jmv74211.DSS_P4.models;

import java.io.Serializable;

/**
 * Clase para definir la claves primarias compuestas de la tabla Pharmacy_Product
 */

public class PharmacyProductPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int pharmacyId;
	
	private int productId;
	
	public PharmacyProductPK(){
		
	}
	
	
	
	public PharmacyProductPK(int pharmacyId, int productId) {
		this.pharmacyId = pharmacyId;
		this.productId = productId;
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



	@Override
	public boolean equals(Object obj){
		return super.equals(obj);
	}
	
	@Override
	public int hashCode(){
		return super.hashCode();
	}
	    
}
