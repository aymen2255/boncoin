package fr.treeptik.dao;

import fr.treeptik.dao.impl.AnnonceDAOImpl;
import fr.treeptik.dao.impl.UserDAOImpl;

public class DAOFactory {
	
	public static UserDAOImpl getUserDAO() {
		return new UserDAOImpl();
	}
	public static AnnonceDAOImpl getAnnonceDAO() {
		return new AnnonceDAOImpl();
	}
	
}
