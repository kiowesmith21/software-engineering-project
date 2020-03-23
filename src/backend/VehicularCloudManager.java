package backend;

import java.util.ArrayList;
import java.util.Queue;

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
	
	public int calculateJobCompletionTime(int id, Queue<Job> jobs) {
		int time = 0;
		for(Job j:jobs) {
			time += j.duration;
			if (j.id == id) {
				break;
			}
		}
		return time;
	}
	
}
