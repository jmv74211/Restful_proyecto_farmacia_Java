package jmv74211.DSS_P4.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jmv74211.DSS_P4.models.Users.Customer;


@Entity
@Table(name = "Purchase")
public class Purchase implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchaseId")
	private int purchaseId;
	
	@Column(name = "date")
	private String date;
	
	@ManyToOne(optional = false)
    @JoinColumn(name="customerId", nullable=false)
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name="purchase_product", 
	 		joinColumns=@JoinColumn(name="purchaseId"), 
	 		inverseJoinColumns=@JoinColumn(name="productId"))
	private List<Product> products;
	
	@Column(name = "paymentData")
	private String paymentData;

	
	public Purchase(){
		
		this.products = new ArrayList<Product>();
		this.customer = new Customer();
	}
	
	public Purchase(String date, Customer customer, List<Product> products, String paymentData) {

		this.date = date;
		this.customer = customer;
		this.products = products;
		this.paymentData = paymentData;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getPaymentData() {
		return paymentData;
	}

	public void setPaymentData(String paymentData) {
		this.paymentData = paymentData;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", date=" + date + ", customer=" + customer + ", products="
				+ products + ", paymentData=" + paymentData + "]";
	}

}
