package src.main.java.com.example.jpa.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

public class Aeronef extends Engin {

	
	@Column(name = "type", length = 30, nullable = false, unique = true)
	private String type;
	
	@Column(name = "autonomie_heure", nullable = false)
	private Integer autonomie_heure;
	
	public Aeronef() {
		super();

	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getAutonomie_heure() {
		return autonomie_heure;
	}

	public void setAutonomie_heure(Integer autonomie_heure) {
		this.autonomie_heure = autonomie_heure;
	}

	@Override
	public String toString() {
		return "Aeronef [type=" + type + ", autonomie_heure=" + autonomie_heure + "]";
	}
	
	
}
