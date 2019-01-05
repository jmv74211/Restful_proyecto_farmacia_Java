package jmv74211.DSS_P4.DAO;

import java.util.List;

import javax.persistence.Query;

import jmv74211.DSS_P4.models.ShippingCart;
import jmv74211.DSS_P4.models.ShippingCartProduct;
import jmv74211.DSS_P4.models.ShippingCartProductPK;

public class ShippingCartDao extends Dao<Integer,ShippingCart> {
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ShippingCartDao(){
		super();	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void save(ShippingCart shippingCart){
	
		System.out.println("A new ShippingCart has been added");
		this.persist(shippingCart);
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void delete(ShippingCart shippingCart){
		
		System.out.println("A ShippingCart with id = " + shippingCart.getCartId() + "has been deleted");
		
		this.remove(shippingCart);	
		
		String queryText = "SELECT a FROM ShippingCartProduct a WHERE a.cartId=" + shippingCart.getCartId() + "";
		
		Query query = this.query(queryText);
		
		ShippingCartProductDao shpDao = new ShippingCartProductDao();
		
		@SuppressWarnings("unchecked")
		List<ShippingCartProduct>queryResult = query.getResultList();
		
		for(ShippingCartProduct sh: queryResult){
			shpDao.remove(shpDao.getCartProduct(new ShippingCartProductPK(sh.getCartId(),sh.getProductId())));
		}
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ShippingCart getShippingCart(int id){
		
		return this.findById(id);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void updateShippingCart(ShippingCart shippingCart){
		this.update(shippingCart);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
