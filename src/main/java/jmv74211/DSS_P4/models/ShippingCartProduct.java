package jmv74211.DSS_P4.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Cart_Product")
@IdClass(value = ShippingCartProductPK.class)
public class ShippingCartProduct implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int cartId;
	
	@Id
	@Column
	private int productId;
	
	@Column(name = "quantity")
	private int quantity;
	
	public ShippingCartProduct(){
		
	}

	public ShippingCartProduct(int cartId, int productId, int quantity) {
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
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
