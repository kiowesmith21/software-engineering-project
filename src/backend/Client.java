package backend;

import java.util.ArrayList;

public class Client extends User {
	
	ArrayList<Job> jobs;
	
	/**
	 * Constructor for client class
	 * @param id: integer client ID
	 * @param name: string client name
	 */
	public Client(int id, String name) {
		super(id, name);
		this.jobs = new ArrayList<Job>();
	}
	
	/**
	 * adds a job to the client jobs attribute
	 * @param job: job to add
	 */
	public void submitJob(Job job) {
		this.jobs.add(job);
	}
	
}
