package backend;

import java.util.ArrayList;

public class JobController {
	
	
	public void addJob(Job job, ArrayList<Job> jobs) {
		jobs.add(job);
	}
	
	public void startJob(Job job, Vehicle vehicle) {
		vehicle.assignJob(job);
	}
	
	public void incrementJob(Job job) {
		job.hoursCompleted += 1;
	}
	
	public void transferJob(Job job) {
		
	}
	
	public void eraseJob(Job job, ArrayList<Job> jobs) {
		jobs.remove(job);
	}
}
