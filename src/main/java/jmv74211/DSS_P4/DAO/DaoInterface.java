package jmv74211.DSS_P4.DAO;


/**
 * @author jmv74211
 *
 * @param <K> Type to use as the key
 * @param <E> Type of the entity
 */
public interface DaoInterface<K,E>{
	
	 void persist(E entity);
	 
     void remove(E entity);
     
     E findById(K id);
}