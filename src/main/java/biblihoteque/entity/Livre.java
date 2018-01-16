package biblihoteque.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // Indique que la classe doit être gérée par JPA
@Table(name = "livre") // @Table (facultatif) désigne la table à mapper
public class Livre {
	@Id
	private Integer id;

	@Column(name = "TITRE")
	private String titre;

	@Column(name = "AUTEUR")
	private String auteur;

	@ManyToMany
	@JoinTable(
			name = "compo", 
			joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"), 
			inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")
	)
	private List<Emprunt> emprunt;

	// constructeurs
	public Livre() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
