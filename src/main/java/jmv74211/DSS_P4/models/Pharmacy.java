package jmv74211.DSS_P4.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Pharmacy")
public class Pharmacy implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "length")
	private double length;
	
	public Pharmacy(int id, String name, double latitude, double length) {
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.length = length;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Pharmacy [id=" + id + ", name=" + name + ", latitude=" + latitude + ", length=" + length + "]";
	}
	
	

}
