
package fr.treeptik.jpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManager entityManager = null;
	public static EntityManager getEntityManager() {
		if (entityManager==null){
		entityManager = Persistence.createEntityManagerFactory(
				"boncoin").createEntityManager();
		
		}
		return entityManager;
	}
	public static void beginTX(){
		getEntityManager().getTransaction().begin();
	}
	public static void commitTX(){
		getEntityManager().getTransaction().commit();
	}
}
