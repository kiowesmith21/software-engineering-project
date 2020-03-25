package backend;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Queue;

//Testing JobController
	public class JobControllerTest {
		
		public void testAddJob() {
			VehicularCloud vct = new VehicularCloud();
			JobController jcTest = new JobController();
			
			Job testJob = new Job(0, 5);
			
			jcTest.addJob(testJob, vct.jobQueue);
			System.out.println(jcTest.findJob(0, vct.jobQueue));
		}
		
		public void testStartJob() {
			Vehicle testV = new Vehicle(0, 0);
			Job testJob = new Job(0, 6);
			JobController jcTest = new JobController();
			
			jcTest.startJob(testJob, testV);
			Assert.assertTrue(testV.hasJob()); //Assert true to make sure the job was added to the vehicle 
			
		}
	
		public void TestEraseJob() {
			VehicularCloud vct = new VehicularCloud();
			
			Job testJob = new Job(0, 6);
			
			JobController jcTest = new JobController();
			
			jcTest.addJob(testJob, vct.jobQueue);
			System.out.println(jcTest.findJob(0, vct.jobQueue));
			
			jcTest.eraseJob(vct.jobQueue);
			
			Assert.assertNull(jcTest.findJob(0, vct.jobQueue)); //findJob should return null because we removed the job
		}
		
		
	}
	
