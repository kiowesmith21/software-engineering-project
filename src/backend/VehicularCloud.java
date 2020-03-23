package backend;

import java.util.Scanner;
import java.util.Queue; 
import java.util.ArrayList;
import java.util.LinkedList;


public class VehicularCloud {
	
	Scanner scan;
	VehicleController vehicleController;
	JobController jobController;
	UserController userController;
	Queue<Job> jobQueue;
	ArrayList<Vehicle> vehicles;
	VehicularCloudManager vcm;
	
	public VehicularCloud() {
		
		scan = new Scanner(System.in);
		vehicleController = new VehicleController();
		jobController = new JobController();
		userController = new UserController();
		jobQueue = new LinkedList<Job>();
		vehicles = new ArrayList<Vehicle>();
		vcm = new VehicularCloudManager();
		
	}
	
	public static void main(String[] args) {
		VehicularCloud vc = new VehicularCloud();
		vc.displayMainMenu();
		String input;
		input = vc.scan.next();
		switch(input) {
		case "A":
			vc.clientMenu();
			break;
		case "B":
			vc.vehicleOwnerMenu();
			break;
		case "C":
			vc.VCMMenu();
		case "D":
			break;
		}
		
		
	}
	
	public void displayMainMenu() {
		System.out.println("A = Client\n" + 
				"B = Vehicle Owner\n" + 
				"C = Vehicular Cloud Manager\n" + 
				"D = Exit");
	}
	
	public void clientMenu() {
		System.out.println("A = Submit a job\n" + 
				"B = Exit");
		String input = scan.next();
		switch (input) {
		case "A":
			this.jobMenu();
		case "B":
			this.displayMainMenu();
		}
	}
	
	public void vehicleOwnerMenu() {
		System.out.println("Enter the your vehicle ID: ");
		int vehicleID = scan.nextInt();
		System.out.println("Enter the residency time for your vehicle: ");
		int vehicleResTime = scan.nextInt();
		Vehicle vehicle = new Vehicle(vehicleID, vehicleResTime);
		this.vehicleController.addVehicle(vehicle, this.vehicles);
		
	}
	
	public void VCMMenu() {
		System.out.println("A = Calculate the completion time for the job\n" + 
				"B = Exit");
		String input = scan.next();
		switch(input) {
		case "A":
			System.out.print("Enter the job ID: ");
			int id = scan.nextInt();
			int time = vcm.calculateJobCompletionTime(id, this.jobQueue);
			System.out.printf("The job will be completed in %s hours\n", time);
		case "B":
			this.displayMainMenu();
		}
		
	}
	
	public void jobMenu() {
		System.out.println("Enter Job ID: ");
		int jobID = scan.nextInt();
		System.out.println("Enter Job Duration: ");
		int jobDuration = scan.nextInt();
		Job job = new Job(jobID, jobDuration);
		this.jobController.addJob(job, this.jobQueue);
	}

}
