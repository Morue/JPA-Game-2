package main.java.com.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import src.main.java.com.example.jpa.database.model.Player;
import src.main.java.com.example.jpa.database.DatabaseHandle;

public class PlayerRepository {

	static /*
			 * TypedQuery<Person> query =
			 * em.createQuery("SELECT p FROM Person p WHERE p.id = ?", Person.class);
			 * query.setParameter(1, 12); Person person = query.getSingleResult();
			 */
	EntityManager em = DatabaseHandle.getEntityManagerFactory();
	EntityTransaction transaction = em.getTransaction();

	public static void getPlayerByName(String name) {
		TypedQuery<Player> q = em.createQuery("select j from Player j where j.nom = :name", Player.class);
		q.setParameter("name", name);
		Player p = q.getSingleResult();
		p.toString();
	}
	public static void getPseudoPlayerSorted() {
		TypedQuery<Player> q = em.createQuery("from Player", Player.class);
		
		q.getResultList().stream().map(e -> e.getPseudo()).sorted((o1,o2)->{
			return  (o1.equals(o2)) ? 1: (o2.equals(o1)? -1 :0) ;
		}).forEach(System.out::println);

		
	}
}
