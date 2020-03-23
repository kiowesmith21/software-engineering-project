package backend;

import java.util.ArrayList;

public class VehicularCloudManager {
	
	public void assignJob (Job job, ArrayList<Vehicle> vehicles) {
		for(Vehicle v: vehicles) {
			v.assignJob(job);
		}
	}
	public Job newCheckpoint(Vehicle vehicle) {
		return vehicle.getJob();
	}
	public Vehicle getNewVehicle(ArrayList<Vehicle> vehicles) {
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
	
}
