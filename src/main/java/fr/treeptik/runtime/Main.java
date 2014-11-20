package fr.treeptik.runtime;

import java.util.List;

import fr.treeptik.dao.DAOFactory;
import fr.treeptik.jsoup.JSOUPUtil;
import fr.treeptik.model.Annonce;
import fr.treeptik.model.User;
import fr.treeptik.service.AnnonceService;
import fr.treeptik.service.UserService;

public class Main {

	public static void main(String[] args) {
		//getAllUser();
		//JSOUPUtil.getJsoup();
		//getAllAnnonce();
		//findAnnonceById(2);
		 //finUserById(2);
		//addAnnoncesToUser();
		//findAnnonceByTitle("aaa");
		//findByPrix(300, 5000);

	}
	public static List<User> getAllUser(){
		UserService userservice = new UserService();
		List<User> allUser = userservice.getAllUser();
		for (User user2 : allUser) {
			System.out.println(user2.getNom());
		}
		return allUser;
	}
	public static List<Annonce> getAllAnnonce(){
		AnnonceService annonceservice = new AnnonceService();
		List<Annonce> allAnnonce = annonceservice.getAllAnnonce();
		for (Annonce annonce : allAnnonce) {
			System.out.println(annonce.getPrix());
		}
		return allAnnonce;
	}
	public static Annonce findAnnonceById(Integer id){
		Annonce annonce = DAOFactory.getAnnonceDAO().findAnnonceById(id);
		System.out.println(annonce.getPrix());
		return null;
	}
	public static User finUserById(Integer id){
		 User user = DAOFactory.getUserDAO().findUserById(id);
		 System.out.println(user.getNom());
		 return user;
	}
	public static User addAnnoncesToUser(){
		List<Annonce>annonces =getAllAnnonce();
		User user = finUserById(2);
		UserService userService = new UserService(); 
		userService.addAnnoncesToUser(user, annonces);
		return user;
		
	}
	public static List<Annonce> findAnnonceByTitle(String title){
		AnnonceService annonceService = new AnnonceService();
		List<Annonce> annonces = annonceService.findByTitle(title);
		for (Annonce annonce : annonces) {
			System.out.println(annonce.getId());
		}
		return annonces;
	}
	public static List<Annonce> findByPrix(Integer min, Integer max){
		AnnonceService annonceService = new AnnonceService();
		List<Annonce> list = annonceService.findByPrix(min, max);
		for (Annonce annonce : list) {
			System.out.println(annonce.getId());
		}
		return list;
		
	}

}
