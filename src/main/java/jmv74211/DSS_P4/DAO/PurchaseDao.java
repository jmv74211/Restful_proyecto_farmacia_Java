package jmv74211.DSS_P4.DAO;

import jmv74211.DSS_P4.models.Purchase;

public class PurchaseDao extends Dao<Integer,Purchase> {
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public PurchaseDao(){
		super();	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void save(Purchase purchase){
	
		System.out.println("A new Purchase has been added");
		this.persist(purchase);
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void delete(Purchase purchase){
		
		System.out.println("A Purchase with id = " + purchase.getPurchaseId() + "has been deleted");
		this.remove(purchase);	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Purchase getPurchase(int id){
		
		return this.findById(id);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void updatePurchase(Purchase purchase){
		this.update(purchase);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
