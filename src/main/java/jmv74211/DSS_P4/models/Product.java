package jmv74211.DSS_P4.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private int productId;
	
	@ManyToOne
    @JoinColumn(name="departmentId", nullable=false)
	private Department department;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "imageURL")
	private String imageURL;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "outstanding")
	private boolean outstanding;
	
	@Column(name = "price")
	private float price;

	public Product(){
		this.department = new Department();
	}
	
	public Product(Department department, String name, String imageURL, String description,
				boolean outstanding, float price) {
		
		this.department = department;
		this.name = name;
		this.imageURL = imageURL;
		this.description = description;
		this.outstanding = outstanding;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isOutstanding() {
		return outstanding;
	}

	public void setOutstanding(boolean outstanding) {
		this.outstanding = outstanding;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", department=" + department + ", name=" + name + ", imageURL="
				+ imageURL + ", description=" + description + ", outstanding=" + outstanding + ", price=" + price + "]";
	}
	
	
	
	

}
