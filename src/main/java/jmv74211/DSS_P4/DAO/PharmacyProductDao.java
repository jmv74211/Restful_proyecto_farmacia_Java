package jmv74211.DSS_P4.DAO;

import javax.persistence.Query;

import jmv74211.DSS_P4.models.Pharmacy;
import jmv74211.DSS_P4.models.PharmacyProduct;
import jmv74211.DSS_P4.models.PharmacyProductPK;
import jmv74211.DSS_P4.models.Product;



public class PharmacyProductDao extends Dao<PharmacyProductPK,PharmacyProduct> {
	
	public PharmacyProductDao(){
		super();	
	}
	
	public void save(PharmacyProduct pharmacyProduct){
	
		this.persist(pharmacyProduct);
		
	}
	
	public void delete(PharmacyProduct pharmacyProduct){
		
		System.out.println("A Product with id = " + pharmacyProduct.getProductId() + "in a pharmacy with id = + "
				+ pharmacyProduct.getPharmacyId() + " has been deleted");
		this.remove(pharmacyProduct);	
	}
	
	
	public void addProduct(Pharmacy pharmacy, Product product, int quantity){
		
		String queryText = "SELECT a FROM PharmacyProduct a WHERE a.productId=" + product.getProductId()
				+ " AND a.pharmacyId=" + pharmacy.getId() + "";
		
		Query query = this.query(queryText);
		
		if(query.getResultList().size()== 0){
			
			PharmacyProduct newProduct = new PharmacyProduct(pharmacy.getId(), product.getProductId(), quantity);
			this.save(newProduct);
			System.out.println("It has been successfully added " + quantity + " NEW products with id = " + 
			product.getProductId() + " to the pharmacy with id = " + pharmacy.getId());
		}
		else{
			PharmacyProduct updatedProduct = (PharmacyProduct) query.getResultList().get(0);
			updatedProduct.setQuantity(updatedProduct.getQuantity() + quantity);
			this.save(updatedProduct);
			System.out.println("It has been successfully added " + quantity + " products with id = " + 
					product.getProductId() + " to the pharmacy with id = " + pharmacy.getId() + ". Now there are " + 
					updatedProduct.getQuantity() + " stock");
			
		}
	}
		
	public void updateProduct(PharmacyProduct pharmacyProduct){
		this.update(pharmacyProduct);
	}
	
	public PharmacyProduct getPharmacyProduct(PharmacyProductPK key){
		
		return this.findById(key);
		
	}

}
