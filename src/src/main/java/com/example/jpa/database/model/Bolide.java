package src.main.java.com.example.jpa.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
public class Bolide extends Engin {

	@Column(name = "nb_roues", nullable = false)
	private Integer nb_roues;
	
	@Column(name = "autonomie_heure", nullable = false)
	private Integer autonomie_heure;
	
	

	public Bolide() {
		super();
	}

	public Integer getNb_roues() {
		return nb_roues;
	}

	public void setNb_roues(Integer nb_roues) {
		this.nb_roues = nb_roues;
	}

	public Integer getAutonomie_heure() {
		return autonomie_heure;
	}

	public void setAutonomie_heure(Integer autonomie_heure) {
		this.autonomie_heure = autonomie_heure;
	}

	@Override
	public String toString() {
		return "Bolide [nb_roues=" + nb_roues + ", autonomie_heure=" + autonomie_heure + "]";
	}
	
	
}
