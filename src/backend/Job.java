package backend;

import java.sql.Timestamp;

public class Job {
	protected int id;
	protected Timestamp registerTime;
	protected Timestamp startTime;
	protected Timestamp endTime;
	protected int duration;
	protected boolean isComplete;
	protected int hoursCompleted;
	
	/**
	 * Constructor for job class. Takes in the id and duration of
	 * a job.
	 * @param id: integer id of a job
	 * @param duration: duration of a job represented as an int
	 */
	public Job(int id, int duration) {
		this.id = id;
		this.duration = duration;
		this.registerTime = new Timestamp(System.currentTimeMillis());
		this.isComplete = false;
		this.hoursCompleted = 0;
	}
	
}
