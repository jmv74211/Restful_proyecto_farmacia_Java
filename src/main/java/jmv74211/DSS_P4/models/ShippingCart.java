package jmv74211.DSS_P4.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@ManyToMany  
	@JoinTable(name="Cart_Products", 
	 		joinColumns=@JoinColumn(name="cartId"), 
	 		inverseJoinColumns=@JoinColumn(name="productId"))
	private List<Product> products;
	
	@Column(name = "price")
	private float price;
	
	public ShippingCart(){
		
		this.customer = new Customer();
		this.products = new ArrayList<Product>();
		this.price = 0;
	}
	
	public ShippingCart(Customer customer){
		
		this.products = new ArrayList<Product>();
		this.customer = customer;
		this.price = 0;
	}
	
	public ShippingCart(Customer customer, List<Product> products){
		
		this.products = new ArrayList<Product>();
		this.products = products;
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
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> product) {
		this.products = product;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public void addProduct(Product product){
		
		if(product != null){
			this.products.add(product);
			this.price += product.getPrice();
		}
	}
	
	public void delProduct(Product product){
		
		if(product != null){
			this.products.remove(product); // ¿Primera ocurrencia?
			this.price -= product.getPrice();
		}
	}
	
	public boolean hasValidAttributes(){
		
		if(this == null || this.customer == null || this.price < 0 || this.products == null)
			
			return false;
		
		else
			return true;
	}
	

	@Override
	public String toString() {
		return "ShippingCart [cartId=" + cartId + ", customer=" + customer + ", product=" + products + ", price=" + price
				+ "]";
	}

}
