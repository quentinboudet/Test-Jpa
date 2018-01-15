package entity;

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
@Table(name="client") //@Table (facultatif) désigne la table à mapper 
public class Client {
	@Id 
	private Integer id;

	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "PRENOM")
	private String prenom;

	
	@OneToMany(mappedBy="client")
	private List<Emprunt> emprunt;
	
	// constructeurs
	public Client() {
		
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Emprunt> getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(List<Emprunt> emprunt) {
		this.emprunt = emprunt;
	}



}
