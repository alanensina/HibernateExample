package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Client;

/*
 * This class is in charge to persist the client in database
 */

public class ClientRepository {
	
	EntityManagerFactory emf; // Manage the database's communications
	EntityManager em; // Manage the database's transactions
	
	public ClientRepository() {
		emf = Persistence.createEntityManagerFactory("hibernate-mysql"); // Use the same persistence-unit name in META-INF/persistence.xml
		em = emf.createEntityManager();
	}

	public void save(Client client) {
		em.getTransaction().begin(); // Open the database connection
		
		// It will persist the object in the database, it already existing or not
		//em.persist(client); 
		
		// It will check in the database if the object already exists and will update it, if it does not exist, it creates a new one
		em.merge(client); 
				
		em.getTransaction().commit(); // Commit in database
		emf.close(); // Close the connection
	}
	
	public void delete(Client client) {
		em.getTransaction().begin();
		em.remove(client);
		em.getTransaction().commit();
		emf.close();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> listAll() {
		em.getTransaction().begin();
		Query query = em.createQuery("select client from Client client");
		List<Client> clientList = query.getResultList();
		em.getTransaction().commit();
		emf.close();
		
		return clientList;
	}
	
	public Client findById(int id) {
		em.getTransaction().begin();
		Client client = em.find(Client.class, id);
		em.getTransaction().commit();
		emf.close();
		
		return client;
	}

}
