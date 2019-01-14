package controller;

import java.util.List;

import model.Client;
import repository.ClientRepository;

public class App {

	public static void main(String[] args) {

		ClientRepository cr = new ClientRepository();

		/*
		 * Saving a client:
		 * 
		 * Client client = new Client(); client.setName("Katheryn Winnick");
		 * client.setAge(41);
		 * 
		 * cr.save(client);
		 */

		/*
		 * Listing all clients:
		 * 
		 * List<Client> listClient = cr.listAll();
		 * 
		 * for (Client client : listClient) { System.out.println(client); }
		 */

		/*
		 * Searching by ID:
		 * 
		 * Client client = cr.findById(3); System.out.println(client);
		 */

		/*
		 * Searching by ID and update the client:
		 * 
		 * Client client = cr.findById(1); client.setName("Paolla Oliveira");
		 * client.setAge(36); cr.save(client);
		 */

		/*
		 * Searching by ID and deleting the client:
		 * 
		 * Client client = cr.findById(2); cr.delete(client);
		 */
	}
}
