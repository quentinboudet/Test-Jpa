package banques.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //Indique que la classe doit être gérée par JPA
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="operation") //@Table (facultatif) désigne la table à mapper 
public class Operation {
	@Id 
	private Integer id;

	@Column(name = "DATE")
	private LocalDateTime date;
	
	@Column(name = "MONTANT")
	private double montant;
	
	@Column(name = "MOTIF")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;
	
	// constructeurs
	public Operation() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}


}
