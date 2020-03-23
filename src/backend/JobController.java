package backend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Queue;

public class JobController {
	
	/**
	 * Adds a job to the job queue
	 * @param job Job object to add to queue
	 * @param jobs Queue to be added to
	 */
	public void addJob(Job job, Queue<Job> jobs) {
		jobs.add(job);
	}
	
	/**
	 * Assigns a job to a vehicle and begins "working"
	 * on the job
	 * @param job: job to assign
	 * @param vehicle: vehicle to assign job to
	 */
	public void startJob(Job job, Vehicle vehicle) {
		vehicle.assignJob(job);
	}
	
	/**
	 * Increments the job's completion time
	 * (essentially simulates a job being computed)
	 * @param job: Job object to increment
	 */
	public void incrementJob(Job job) {
		job.hoursCompleted += 1;
	}
	
	/**
	 * Write a job to a textfile db
	 * @param job: Job to write to textfile
	 */
	public void transferJob(Job job) {
		PrintStream output;
		try {
			output = new PrintStream(new FileOutputStream("Jobs.txt", true));
			String toAppend = String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
					job.id,
					job.duration,
					job.registerTime,
					job.startTime,
					job.endTime,
					job.duration,
					job.isComplete,
					job.hoursCompleted
					 );
			output.append(toAppend);
			output.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Searches through the queue of jobs for job matching the id
	 * else returns null if not found
	 * @param jobs Queue of jobs
	 * @param id id of the job to search for
	 * @return the Job object
	 */
	public Job findJob(int id, Queue<Job> jobs) {
		for(Job j: jobs) {
			if(j.id == id) {
				return j;
			}
		}
		return null;
	}
	
	/**
	 * Removes the head of the job queue and writes it to a text file db
	 * @param jobs: Queue of jobs
	 */
	public void eraseJob(Queue<Job> jobs) {
		Job job = jobs.remove();
		this.transferJob(job);
	}
}
