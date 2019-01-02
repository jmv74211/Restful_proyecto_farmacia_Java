package jmv74211.DSS_P4.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;


import jmv74211.DSS_P4.DAO.ShippingCartProductDao;
import jmv74211.DSS_P4.models.Users.Customer;

@Entity
@Table(name = "ShippingCart")
public class ShippingCart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId")
	private int cartId;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
	private Customer customer;
	
	@Column(name = "price")
	private float price;
	
	public ShippingCart(){
		
		this.customer = new Customer();
		this.price = 0;
	}
	
	public ShippingCart(Customer customer){
		
		this.customer = customer;
		this.price = 0;
	}
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public void addProduct(Product product, int quantity){
		
		ShippingCartProductDao shippingCartProductDao = new ShippingCartProductDao();
		
		shippingCartProductDao.addProduct(this,product, quantity);
	}
	

	public boolean hasValidAttributes(){
		
		if(this == null || this.customer == null || this.price < 0 )
			
			return false;
		
		else
			return true;
	}
	

	@Override
	public String toString() {
		
		
		return "ShippingCart [cartId=" + cartId + ", customer=" + customer + ", price=" + price
				+ "]";
	}

}
