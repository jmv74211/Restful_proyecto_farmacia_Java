package jmv74211.DSS_P4.DAO;

import jmv74211.DSS_P4.models.Pharmacy;

public class PharmacyDao extends Dao<Integer,Pharmacy> {
	
	
	public PharmacyDao(){
		super();
	}
	
	public void save(Pharmacy pharmacy){
		
		System.out.println("A new pharmacy has been added");
		this.persist(pharmacy);
		
	}
	
	public void delete(Pharmacy pharmacy){
		
		System.out.println("A pharmacy with id = " + pharmacy.getId() + "has been deleted");
		this.remove(pharmacy);	
	}
	
	public Pharmacy getPharmacy(int id){
		
		return this.findById(id);
	}

}
