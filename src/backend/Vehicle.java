package backend;

import java.sql.Timestamp;

public class Vehicle {
	
	String id;
	Job job;
	VehicleOwner owner;
	Timestamp registerTime;
	Timestamp departureTime;
	
	public Job getJob() {
		return this.job;
	}

}
