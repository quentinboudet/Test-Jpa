package banques.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Indique que la classe doit être gérée par JPA
@Table(name="banque") //@Table (facultatif) désigne la table à mapper 
public class Banque {
	@Id 
	private Integer id;

	@Column(name = "NOM")
	private String nom;
	
	@OneToMany(mappedBy = "banque")
	private List<Client> clients;
	
	// constructeurs
	public Banque() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}
