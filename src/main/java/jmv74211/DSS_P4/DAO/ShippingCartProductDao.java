package jmv74211.DSS_P4.DAO;

import javax.persistence.Query;

import jmv74211.DSS_P4.models.Product;
import jmv74211.DSS_P4.models.ShippingCart;
import jmv74211.DSS_P4.models.ShippingCartProduct;
import jmv74211.DSS_P4.models.ShippingCartProductPK;

public class ShippingCartProductDao extends Dao<ShippingCartProductPK,ShippingCartProduct> {

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ShippingCartProductDao(){
		super();	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void save(ShippingCartProduct shippingCartProduct){
	
		this.persist(shippingCartProduct);
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void delete(ShippingCartProduct shippingCartProduct){
		
		System.out.println("A Product with id = " + shippingCartProduct.getProductId() + "in a cart with id = + "
				+ shippingCartProduct.getCartId() + " has been deleted");
		
		this.remove(shippingCartProduct);	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void addProduct(ShippingCart shippingCart, Product product, int quantity){
		
		String queryText = "SELECT a FROM ShippingCartProduct a WHERE a.productId=" + product.getProductId()
				+ " AND a.cartId=" + shippingCart.getCartId() + "";
		
		Query query = this.query(queryText);
		
		if(query.getResultList().size()== 0){
			
			ShippingCartProduct newProduct = new ShippingCartProduct(shippingCart.getCartId(), product.getProductId(), quantity);
			this.save(newProduct);
			System.out.println("It has been successfully added " + quantity + " NEW products with id = " + 
			product.getProductId() + " to the cart with id = " + shippingCart.getCartId());
		}
		else{
			ShippingCartProduct updatedProduct = (ShippingCartProduct) query.getResultList().get(0);
			updatedProduct.setQuantity(updatedProduct.getQuantity() + quantity);
			this.save(updatedProduct);
			System.out.println("It has been successfully added " + quantity + " products with id = " + 
					product.getProductId() + " to the cart with id = " + shippingCart.getCartId() + ". Now there are " + 
					updatedProduct.getQuantity() + " saved");
			
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void updateCarProduct(ShippingCartProduct shippingCartProduct){
		this.update(shippingCartProduct);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ShippingCartProduct getCartProduct(ShippingCartProductPK key){
		
		return this.findById(key);
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
