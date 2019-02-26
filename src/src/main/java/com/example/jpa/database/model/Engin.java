package src.main.java.com.example.jpa.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Inheritance (strategy=InheritanceType.JOINED)
@Table (name="engin")
public abstract class Engin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_engin;
	@Column(name = "couleur", length = 30, nullable = false, unique = true)
	private String couleur;
	@Column(name = "vitesse_max", nullable = false)
	private Integer vitesse_max;
	
	@ManyToOne
	@JoinColumn(name="id_avatar")
	private Avatar avatar;

	
	
	public Engin() {

	}

	public Integer getId_engin() {
		return id_engin;
	}

	public void setId_engin(Integer id_engin) {
		this.id_engin = id_engin;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Integer getVitesse_max() {
		return vitesse_max;
	}

	public void setVitesse_max(Integer vitesse_max) {
		this.vitesse_max = vitesse_max;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "Engin [id_engin=" + id_engin + ", couleur=" + couleur + ", vitesse_max=" + vitesse_max + ", personnage="
				+ avatar + "]";
	}
	
	

}
