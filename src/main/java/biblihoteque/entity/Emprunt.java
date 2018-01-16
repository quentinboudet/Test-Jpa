package biblihoteque.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Indique que la classe doit être gérée par JPA
@Table(name="emprunt") //@Table (facultatif) désigne la table à mapper 
public class Emprunt {
	@Id 
	private Integer id;
	
	@Column(name = "DATE_DEBUT")
	private String dateDebut;
	
	@Column(name = "DATE_FIN")
	private String dateFin;

	@Column(name = "DELAI")
	private String delai;

	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;

	@ManyToMany(mappedBy="emprunt")
	private List<Livre> livre;
	
	// constructeurs
	public Emprunt() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getDelai() {
		return delai;
	}

	public void setDelai(String delai) {
		this.delai = delai;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Livre> getLivre() {
		return livre;
	}

	public void setLivre(List<Livre> livre) {
		this.livre = livre;
	}

}
