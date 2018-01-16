package banques.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement  extends Operation{

	@Column(name = "BENFICIAIRE")
	private String beneficiaire;
	
	public void setVirement(String beneficiaire, String rue, int cp, String ville) {
		setBeneficiaire(beneficiaire);
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
}
