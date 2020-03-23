package backend;

import java.sql.Timestamp;

public class Job {
	int id;
	Timestamp registerTime;
	Timestamp startTime;
	Timestamp endTime;
	int duration;
	boolean isComplete;
	//int percentComplete;
	
	public Job(int id, int duration) {
		this.id = id;
		this.duration = duration;
		this.registerTime = new Timestamp(System.currentTimeMillis());
		this.isComplete = false;
		//this.percentComplete = 0;
	}
	
}
