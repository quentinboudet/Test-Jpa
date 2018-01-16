package biblihoteque.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import biblihoteque.entity.Client;
import biblihoteque.entity.Emprunt;
import biblihoteque.entity.Livre;

public class TestJpa {

	public static void main(String[] args) {
		
		Persistence persistence = new Persistence();
		
		EntityManagerFactory entityManagerFactory = persistence.createEntityManagerFactory("test_jpa");
		EntityManager em = entityManagerFactory.createEntityManager();

		Livre livre = em.find(Livre.class, 1);
		System.out.println(livre);
		System.out.println(livre.getTitre());
		System.out.println(livre.getAuteur());
		
		Query query = em.createQuery("select l from Livre l where l.titre='Germinal'");
		Livre livre1 = (Livre) query.getResultList().get(0);
		System.out.println(livre1.getTitre());
		System.out.println(livre1.getAuteur());
		
		//les emprunts et leur livre
		TypedQuery<Emprunt> queryEmp = em.createQuery("select emp from Emprunt emp", Emprunt.class);
		List<Emprunt> emprunt = queryEmp.getResultList();
		
		
		for(Emprunt e: emprunt) {
			for(Livre l: e.getLivre()) {
				System.out.println(l.getTitre());
			}
		}
		
		//un client et ses emprunts
		TypedQuery<Client> queryCli = em.createQuery("select c from Client c where c.id=:idC", Client.class);
		queryCli.setParameter("idC", 1);
		Client client = queryCli.getResultList().get(0);

			for(Emprunt e: client.getEmprunt()) {
				System.out.println(e.getDateDebut());
			}
	}
}
