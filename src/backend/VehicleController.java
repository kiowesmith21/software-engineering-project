package backend;

import java.util.HashMap;

public class VehicleController {
	
	/**
	 * adds a vehicle to the arraylist of vehicles in the VC
	 * @param vehicle: vehicle to add
	 * @param vehicles: Hashmap of vehicles (id:Vehicle)
	 */
	public void addVehicle(Vehicle vehicle, HashMap<Integer, Vehicle> vehicles) {
		vehicles.put(vehicle.id, vehicle);
	}
	
	/**
	 * removes a vehicle from arraylist of vehicles in VC
	 * @param vehicle: vehicle to remove
	 * @param vehicles: HashMap of vehicles (id:Vehicle)
	 */
	public void removeVehicle(int id, HashMap<Integer, Vehicle> vehicles) {
		vehicles.remove(id);
	}
	
	/**
	 * Gets a vehicle without a job assigned to it. Returns null if all 
	 * vehicles are busy
	 * @param vehicles: Hashmap of vehicles (id:vehicle)
	 * @return vehicle object without job assigned to it
	 */
	public Vehicle getAvailableVehicle(HashMap<Integer, Vehicle> vehicles) {
		for(Vehicle v: vehicles.values()) {
			if(!v.hasJob()) {
				continue;
			}
			else {
				return v;
			}
		}
		return null;
	}
	
	/**
	 * Returns true if vehicle is in VC else false
	 * @param id: id of vehicle to look for
	 * @param vehicles: Hashmap of vehicles in VC (id: vehicle)
	 * @return boolean
	 */
	public boolean vehicleExists(int id, HashMap<Integer, Vehicle> vehicles) {
		if(vehicles.get(id) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns an image of the job on a vehicle
	 * @param vehicle: vehicle with job running on it
	 * @return Job object that was running on the vehicle
	 */
	public Job createCheckpoint(Vehicle vehicle) {
		return vehicle.job;
	}
}
