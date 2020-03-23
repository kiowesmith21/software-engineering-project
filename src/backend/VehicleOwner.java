package backend;

import java.util.ArrayList;

public class VehicleOwner extends User {
	
	ArrayList<Vehicle> vehicles;
	
	/**
	 * Constructor for vehicle owner that instantiates its id, name
	 * and the arraylist of vehicles associated with the owner	
	 * @param id: integer id
	 * @param name: string name of vehicle owner
	 */
	public VehicleOwner(int id, String name) {
		super(id, name);
		this.vehicles = new ArrayList<Vehicle>();
	}
	
	/**
	 * Adds vehicle to the arraylist of vehicles the owner owns
	 * @param vehicle: Vehicle object to add to the arraylist of vehicles
	 */
	public void rentVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	

}
