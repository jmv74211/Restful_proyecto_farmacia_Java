package jmv74211.DSS_P4.DAO;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



/*
 * Reference : https://xebia.com/blog/jpa-implementation-patterns-data-access-objects/
 */
public abstract class Dao<K, E> implements DaoInterface<K,E> {
	
	protected Class<E> entityClass;
	
	protected EntityManager entityManager ;
	
	protected EntityManagerFactory entityManagerFactory;
	
	@SuppressWarnings("unchecked")
	public Dao(){
		
		this.entityManagerFactory = Persistence.createEntityManagerFactory("app");
		this.entityManager = entityManagerFactory.createEntityManager();
		
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		  this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];	
		  
		  
	}
	
	public void persist(E entity) { 
		
		//this.entityManager = entityManagerFactory.createEntityManager();
		
		this.entityManager.getTransaction().begin();
		
		this.entityManager.persist(entity); 
		
		this.entityManager.getTransaction().commit();
		
		//this.entityManager.close();
	}
	 
	public void remove(E entity) { 
		
		//this.entityManager = entityManagerFactory.createEntityManager();
		
		this.entityManager.getTransaction().begin();
		
		this.entityManager.remove(this.entityManager.contains(entity) ? entity : this.entityManager.merge(entity));
		
		this.entityManager.getTransaction().commit();
		
		//this.entityManager.close();
	}
	
	public E findById(K id) { 
		
		//this.entityManager = entityManagerFactory.createEntityManager();
		
		E object = entityManager.find(entityClass, id); 
		
		//this.entityManager.close();
		
		return object;
	
	}
	
	public void update(E entity){
		
		//this.entityManager = entityManagerFactory.createEntityManager();
		
		this.entityManager.getTransaction().begin();
		
		this.entityManager.merge(entity);
		
		this.entityManager.getTransaction().commit();
		
		//this.entityManager.close();
		
	}
	
	public Query query(String queryText){
		
		//this.entityManager = entityManagerFactory.createEntityManager();
		
		Query query = this.entityManager.createQuery(queryText);
		
		//this.entityManager.close();
		
		return query;	
	}
		
}
