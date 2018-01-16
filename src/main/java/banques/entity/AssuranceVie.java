package banques.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ASS")
public class AssuranceVie extends Compte{

	@Column(name = "DATE")
	private LocalDate date;
	
	@Column(name = "TAUX")
	private double taux;
	
	public void setAssuranceVie(LocalDate date, double taux) {
		setDate(date);
		setTaux(taux);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
