package src.main.java.com.example.jpa.database.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table (name="avatar")
public class Avatar {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_avatar;
	@Column(name = "nom", length = 30, nullable = false, unique = true)
	private String nom;
	@Column(name = "puissance", nullable = false)
	private Integer puissance;
	
	@OneToMany(mappedBy="avatar")
	private Set<Engin> engin; 


	
	public Integer getId_personnage() {
		return id_avatar;
	}
	public void setId_personnage(Integer id_avatar) {
		this.id_avatar = id_avatar;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getPuissance() {
		return puissance;
	}
	public void setPuissance(Integer puissance) {
		this.puissance = puissance;
	}

	@Override
	public String toString() {
		return "Personnage [id_personnage=" + id_avatar + ", nom=" + nom + ", puissance=" + puissance +  ", engin=" + engin + "]";
	}
	
	
	
}