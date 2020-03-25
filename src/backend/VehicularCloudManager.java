package backend;

import java.util.Queue;
import java.util.HashMap;


public class VehicularCloudManager {
	
	/**
	 * assigns a job to vehicles
	 * @param job: job to assign
	 * @param vehicles: Hashmap of vehicles to assign job to (id:vehicle)
	 */
	public void assignJob (Job job, HashMap<Integer, Vehicle> vehicles) {
		for(Vehicle v: vehicles.values()) {
			v.assignJob(job);
		}
	}
	
	/**
	 * Returns job checkpoint from a vehicle
	 * @param vehicle: vehicle object that a job is running on
	 * @return job at its current state of computation
	 */
	public Job newCheckpoint(Vehicle vehicle) {
		return vehicle.job;
	}
	
	/**
	 * Finds a vehicle without any jobs assigned to it yet
	 * @param vehicles: hashmap of vehicles (id: vehicle)
	 * @return vehicle object with no job assigned
	 */
	public Vehicle getNewVehicle(HashMap<Integer, Vehicle> vehicles) {
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
	 * calculates how long it will take for a job to complete
	 * @param id: id of job
	 * @param jobs: job queue
	 * @return integer representing hours till completion
	 */
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
