package jmv74211.DSS_P4.DAO;

import jmv74211.DSS_P4.models.ShippingCart;

public class ShippingCartDao extends Dao<Integer,ShippingCart> {
	
	public ShippingCartDao(){
		super();	
	}
	
	public void save(ShippingCart shippingCart){
	
		System.out.println("A new ShippingCart has been added");
		this.persist(shippingCart);
		
	}
	
	public void delete(ShippingCart shippingCart){
		
		System.out.println("A ShippingCart with id = " + shippingCart.getCartId() + "has been deleted");
		this.remove(shippingCart);	
	}
	
	public ShippingCart getShippingCart(int id){
		
		return this.findById(id);
	}
	
	public void updateShippingCart(ShippingCart shippingCart){
		this.update(shippingCart);
	}
	
}
