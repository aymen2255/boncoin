package fr.treeptik.service;

import java.util.List;

import fr.treeptik.dao.DAOFactory;
import fr.treeptik.jpaUtil.JPAUtil;
import fr.treeptik.model.Annonce;
import fr.treeptik.model.User;

public class UserService {
	public List<User> getAllUser() {
		return DAOFactory.getUserDAO().findAllUser();
	}
	public User addAnnoncesToUser(User user, List<Annonce>annonces){
		JPAUtil.beginTX();
		 user = DAOFactory.getUserDAO().addAnnoncesToUser(user, annonces);
		 JPAUtil.commitTX();
		 //DAOFactory.getUserDAO().updateUser(user);
		 return user;
	}
}
