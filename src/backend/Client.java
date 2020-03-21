package backend;

import java.util.ArrayList;

public class Client extends User {
	
	ArrayList<Job> jobs;
	
	public Client(String name, String id) {
		super(name, id);
		this.jobs = new ArrayList<Job>();
	}
	
	public void submitJob(Job job) {
		this.jobs.add(job);
	}
	
}
