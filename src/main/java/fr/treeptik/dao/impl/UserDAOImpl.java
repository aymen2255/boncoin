package fr.treeptik.dao.impl;

import java.util.List;

import fr.treeptik.dao.DAOFactory;
import fr.treeptik.jpaUtil.JPAUtil;
import fr.treeptik.model.Annonce;
import fr.treeptik.model.User;

public class UserDAOImpl extends GenericDaoImpl<User, Integer> {
	public User createUser(User user) {
		return DAOFactory.getUserDAO().create(user);
	}

	public User findUserById(Integer id) {
		return JPAUtil.getEntityManager().find(User.class, id);
	}

	public User updateUser(User user) {
		return DAOFactory.getUserDAO().update(user);
	}

	public void deleteUser(User user) {
		DAOFactory.getUserDAO().delete(user);
	}
	public List<User> findAllUser(){
		 List<User> list = DAOFactory.getUserDAO().findAll(User.class);
		
		return list; 
	}
	public User addAnnoncesToUser(User user, List<Annonce>annonces){
		for (Annonce annonce : annonces) {
			user.getAnnonces().add(annonce);
			DAOFactory.getUserDAO().updateUser(user);
		}
		
		
		
		return user;
	}
}
