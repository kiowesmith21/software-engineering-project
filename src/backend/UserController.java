package backend;

import java.util.HashMap;

public class UserController {
	
	/**
	 * adds a client to a hashmap record of existing clients
	 * @param client: client object to add
	 * @param clients: hashmap record of existing clients (id:client)
	 */
	public void addClient(Client client, HashMap<Integer, Client> clients) {
		clients.put(client.id, client);
	}
	
	/**
	 * adds a vehicle owner to a hashmap record of existing owners
	 * @param owner: VehicleOwner object to add
	 * @param owners: hashmap record of existing owners (id:VehicleOwner)
	 */
	public void addVehicleOwner(VehicleOwner owner, HashMap<Integer, VehicleOwner> owners) {
		owners.put(owner.id, owner);
	}
	/**
	 * Finds a client from hashmap of clients based on id
	 * @param id: id of client to find
	 * @param clients: hashmap of clients
	 * @return client object matching the ID if found, else null
	 */
	public Client findClient(int id, HashMap<Integer, Client> clients) {
		return clients.get(id);
	}
	
	/**
	 * Finds a vehicle owner from hashmap of owners based on id
	 * @param id: id of vehicle owner to find
	 * @param vehicleOwners: hashmap of owners
	 * @return VehicleOwner object matching the id if found, else null
	 */
	public VehicleOwner findVehicleOwner(int id, HashMap<Integer, VehicleOwner> vehicleOwners) {
		return vehicleOwners.get(id);
	}
	
}
