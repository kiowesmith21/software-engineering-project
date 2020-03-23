package backend;

import java.sql.Timestamp;

public class Vehicle {
	
	protected int id;
	protected Job job;
	protected VehicleOwner owner;
	protected Timestamp registerTime;
	protected Timestamp departureTime;
	protected int residencyTime;
	
	/**
	 * Constructor for vehicle class, initialized with id,
	 * residencyTime and a timestamp for when it's "registered"
	 * @param id: integer id
	 * @param residencyTime: how long the vehicle will be in the VC
	 */
	public Vehicle(int id, int residencyTime) {
		this.id = id;
		this.registerTime = new Timestamp(System.currentTimeMillis());
		this.residencyTime = residencyTime;
	}
	
	/**
	 * Assigns a job to be computed by vehicle
	 * @param job: job to assign
	 */
	public void assignJob(Job job) {
		this.job = job;
	}
	
	/**
	 * Returns whether or not the vehicle is currently 
	 * computing a job
	 * @return boolean: true if vehicle has a job else false
	 */
	public boolean hasJob() {
		if(this.job == null) {
			return false;
		}
		else {
			return true;
		}
	}

}
