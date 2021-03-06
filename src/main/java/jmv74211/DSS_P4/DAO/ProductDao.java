package jmv74211.DSS_P4.DAO;

import jmv74211.DSS_P4.models.Product;

public class ProductDao extends Dao<Integer,Product> {
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ProductDao(){
		super();	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void save(Product Product){
	
		System.out.println("A new Product has been added");
		this.persist(Product);
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void delete(Product Product){
		
		System.out.println("A Product with id = " + Product.getProductId() + "has been deleted");
		this.remove(Product);	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Product getProduct(int id){
		
		return this.findById(id);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void updateProduct(Product Product){
		this.update(Product);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
