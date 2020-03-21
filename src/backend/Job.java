package backend;

import java.sql.Timestamp;

public class Job {
	String id;
	Timestamp registerTime;
	Timestamp startTime;
	Timestamp endTime;
	int totalDuration;
	boolean isComplete;
	int percentComplete;
	
}
