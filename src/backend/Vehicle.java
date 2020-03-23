package backend;

import java.sql.Timestamp;

public class Vehicle {
	
	int id;
	Job job;
	VehicleOwner owner;
	Timestamp registerTime;
	Timestamp departureTime;
	int residencyTime;
	
	public Vehicle(int id, int residencyTime) {
		this.id = id;
		this.registerTime = new Timestamp(System.currentTimeMillis());
		this.residencyTime = residencyTime;
	}
	
	public void assignJob(Job job) {
		this.job = job;
	}
	
	public Job getJob() {
		return this.job;
	}
	
	public boolean hasJob() {
		if(this.job == null) {
			return false;
		}
		else {
			return true;
		}
	}

}
