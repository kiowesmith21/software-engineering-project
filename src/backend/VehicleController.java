package backend;

import java.util.ArrayList;

public class VehicleController {
	public void addVehicle(Vehicle vehicle) {
		
	}
	public void removeVehicle(Vehicle vehicle) {
		
	}
	public Vehicle getAvailableVehicle(ArrayList<Vehicle> vehicles) {
		for(Vehicle v: vehicles) {
			if(!v.hasJob()) {
				continue;
			}
			else {
				return v;
			}
		}
		return null;
	}
	public Job createCheckpoint(Vehicle vehicle) {
		return vehicle.job;
	}
}
