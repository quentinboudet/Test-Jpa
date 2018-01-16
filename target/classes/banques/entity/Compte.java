package banques.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Indique que la classe doit être gérée par JPA
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
@Table(name="compte") //@Table (facultatif) désigne la table à mapper 
public class Compte {
	@Id 
	private Integer id;

	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "SOLDE")
	private double solde;
	
	@Column(name = "TYPE")
	private String type;
	
	@ManyToMany
	@JoinTable(
			name = "client_compte", 
			joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"), 
			inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID")
	)
	private List<Client> clients;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;
	
	// constructeurs
	public Compte() {
		
	}

	public Integer getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
