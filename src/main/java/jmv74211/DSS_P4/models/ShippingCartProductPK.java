package jmv74211.DSS_P4.models;

import java.io.Serializable;

/**
 * Clase para definir la claves primarias compuestas de la tabla Cart_Product
 */

public class ShippingCartProductPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int cartId;
	
	private int productId;
	
	public ShippingCartProductPK(){
		
	}
	
	
	
	public ShippingCartProductPK(int cartId, int productId) {
		this.cartId = cartId;
		this.productId = productId;
	}



	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
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