package banques.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name = "NUMERO")
	private int numero;
	
	@Column(name = "CP")
	private int cp;
	
	@Column(name = "RUE")
	private String rue;

	@Column(name = "VILLE")
	private String ville;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	

	public void setAdresse(int num, String rue, int cp, String ville) {
		setNumero(num);
		setRue(rue);
		setCp(cp);
		setVille(ville);
	}
	
}
