package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.treeptik.dao.Genericdao;
import fr.treeptik.jpaUtil.JPAUtil;

public class GenericDaoImpl<T,PK> implements Genericdao<T, PK> {
	protected Class<T> entityClass;
	
	@PersistenceContext(unitName="boncoin")
	protected EntityManager em;
	
	@Override
	public T create(T t) {
		this.em.persist(t);
		return t;
	}

	@Override
	public T findById(PK id) {
		//EntityManager entityManager = JPAUtil.getEntityManager();
		return this.em.find(entityClass, id);
		
	}

	@Override
	public T update(T t) {
		return JPAUtil.getEntityManager().merge(t);
		
	}

	@Override
	public void delete(T t) {
		this.em.remove(t);
		
	}

	@Override
	public List< T > findAll(Class entityClass){
		//List list = this.em.createQuery("select entity from " + entityClass.getName()+" entity").getResultList();
			
		List list = JPAUtil.getEntityManager().createQuery("select entity from " + entityClass.getName()+" entity").getResultList();
		return list;
		
	   }

}
