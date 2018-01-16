package banques.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banques.entity.Adresse;
import banques.entity.Banque;
import banques.entity.Client;
import banques.entity.Compte;
import banques.entity.Operation;

public class JpaBanque {

	public static void main(String[] args) {
		
		Persistence persistence = new Persistence();
		
		EntityManagerFactory entityManagerFactory = persistence.createEntityManagerFactory("jpa_banque");
		EntityManager em = entityManagerFactory.createEntityManager();
//*EM
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
//*transaction
		
		Banque b = new Banque(); // création d’une banque
		b.setId(1);
		b.setNom("World Bank");
		System.out.println(b.getNom());
		System.out.println(b.getId());
		
		Client c = new Client(); // création d’un client
		c.setId(1);
		Adresse ad = new Adresse();
		ad.setAdresse(14, "rue de la Foret", 63800, "Cournon");
		c.setAdresse(ad);
		c.setNom("Durant");
		c.setPrenom("Cédric");
		c.setDateNaissance(LocalDate.of(1990, 5, 5));
		c.setBanque(b);

		Compte co = new Compte(); // création d’un compte
		co.setId(1);
		co.setNumero("04562154");
		List<Client> ClList = new ArrayList<Client>();
		ClList.add(c);
		co.setClients(ClList);

		Operation ope = new Operation(); // création d’une opération
		ope.setId(1);
		ope.setDate(LocalDateTime.of(2018,  1, 16, 15, 1, 30));
		ope.setMontant(750);
		ope.setMotif("pour moi");
		ope.setCompte(co);
		
		
		em.persist(b);
		em.persist(c);
		em.persist(co);
		em.persist(ope);

//*/transaction
		transaction.commit();
//		
//		Entreprise e2 = (Entreprise) em.find(AbstractClient.class, 3);
//		Particulier p2 = (Particulier) em.find(AbstractClient.class, 4);
//		LOGGER.debug("Client: " + p2);
//		LOGGER.debug("Client: " + e2);
		
		
//*/EM
		em.close();
		entityManagerFactory.close();

	}
}
