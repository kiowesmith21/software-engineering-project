package backend;

import java.util.ArrayList;

public class VehicleOwner extends User {
	
	ArrayList<Vehicle> vehicles;
	
	public VehicleOwner(String name, String id) {
		super(name, id);
		this.vehicles = new ArrayList<Vehicle>();
	}
	
	public void rentVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	

}
