package src.main.java.com.example.jpa;

import java.util.List;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import src.main.java.com.example.jpa.database.DatabaseHandle;
import src.main.java.com.example.jpa.database.model.Player;
import src.main.java.com.example.jpa.database.model.Engin;
import src.main.java.com.example.jpa.database.model.Partie;
import src.main.java.com.example.jpa.database.model.Aeronef;
import src.main.java.com.example.jpa.database.model.Avatar;
import src.main.java.com.example.jpa.database.model.Bolide;

public class Main {

	public static void main(String[] args) {

		EntityManager em = DatabaseHandle.getEntityManagerFactory();

		EntityTransaction transaction = em.getTransaction();

		// Begin the transaction
		transaction.begin();

		// the record is read and the object is now managed by Hibernate in memory
		Player p = em.find(Player.class, 1);
		//System.out.println(p.toString());
		//System.out.println(p.getNom());
		TypedQuery<Player> query = em.createQuery("FROM Player", Player.class);
		System.out.println("Nombre de joueurs : " + query.getResultList().size());
		System.out.println(query.getResultList());

		// the persistent object is modified
		// p.setPseudo("JeanMichelPseudo");

		// the new objet is transient

		Partie part1 = new Partie();
		part1.setNiveau(10);
		part1.setScore(685654552);
		part1.setDate_DATE(LocalDate.of(1993, 3, 3));

		// this object become a persistent object

		Partie part2 = new Partie();
		part2.setNiveau(5);
		part2.setScore(52394);
		part2.setDate_DATE(LocalDate.of(2003, 5, 6));

		// this object become a persistent object
		
		Avatar perso1 = new Avatar();
		perso1.setNom("Gudul");
		perso1.setPuissance(50000);
		
		Avatar perso2 = new Avatar();
		perso2.setNom("Doe");
		perso2.setPuissance(35000);

		
		Bolide bolide1 = new Bolide();
		bolide1.setVitesse_max(50);
		bolide1.setCouleur("bleu");
		bolide1.setAutonomie_heure(65);
		bolide1.setNb_roues(4);
		bolide1.setAvatar(perso1);

		
		Bolide bolide2 = new Bolide();
		bolide2.setVitesse_max(52);
		bolide2.setCouleur("rouge");
		bolide2.setAutonomie_heure(35);
		bolide2.setNb_roues(10);
		bolide2.setAvatar(perso2);
		
		Aeronef aeronef1 = new Aeronef();
		aeronef1.setVitesse_max(89);
		aeronef1.setCouleur("violet");
		aeronef1.setAutonomie_heure(45);
		aeronef1.setType("route");
		aeronef1.setAvatar(perso1);
		
		Aeronef aeronef2 = new Aeronef();
		aeronef2.setVitesse_max(76);
		aeronef2.setCouleur("jaune");
		aeronef2.setAutonomie_heure(82);
		aeronef2.setType("cross");
		aeronef2.setAvatar(perso2);
		
		
		// p = em.find(Player.class, 1);
		// System.out.println(p.toString());

		// all the objects will be detached
		
		em.persist(part1);
		em.persist(part2);
		
		TypedQuery<Partie> query2 = em.createQuery("FROM Partie", Partie.class);
		System.out.println(query2.getResultList());
		
		em.persist(perso1);
		em.persist(perso2);
		
		TypedQuery<Avatar> query3 = em.createQuery("FROM Avatar", Avatar.class);
		System.out.println(query3.getResultList());
		
		em.persist(bolide1);
		em.persist(bolide2);
		
		TypedQuery<Bolide> query4 = em.createQuery("FROM Bolide", Bolide.class);
		System.out.println(query4.getResultList());
		
		em.persist(aeronef1);
		em.persist(aeronef2);
		
		TypedQuery<Aeronef> query5 = em.createQuery("FROM Aeronef", Aeronef.class);
		System.out.println(query5.getResultList());
		

		try {
			for (Partie partie : query2.getResultList()) {
				partie.setNiveau(partie.getNiveau() + 1);
			}
			transaction.commit();

		} catch (Exception e) {
			System.out.println("Pas d'ajout de niveau");
			transaction.rollback();
		}

		System.out.println(query2.getResultList());
		
		Query query6 = em.createQuery("SELECT p FROM Player p WHERE p.nom= :name");
		query6.setParameter("name", "Doe");
		
		Query query7 = em.createQuery("SELECT p FROM Player p");
		System.out.println(query7.getResultList()); 
		

		em.close();
		System.exit(0);
	}

}
