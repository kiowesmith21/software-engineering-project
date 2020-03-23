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
	
	public VehicularCloud() {
		
		scan = new Scanner(System.in);
		vehicleController = new VehicleController();
		jobController = new JobController();
		userController = new UserController();
		jobQueue = new LinkedList<Job>();
		vehicles = new ArrayList<Vehicle>();
		
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
			
		}
	}
	
	public Vehicle vehicleOwnerMenu() {
		System.out.println("Enter the your vehicle ID: ");
		int vehicleID = scan.nextInt();
		System.out.println("Enter the residency time for your vehicle: ");
		int vehicleResTime = scan.nextInt();
		return new Vehicle(vehicleID, vehicleResTime);
		
	}
	
	public void VCMMenu() {
		System.out.println("A = Calculate the completion time for the job\n" + 
				"B = Exit");
		
	}
	
	public Job jobMenu() {
		System.out.println("Enter Job ID: ");
		int jobID = scan.nextInt();
		System.out.println("Enter Job Duration: ");
		int jobDuration = scan.nextInt();
		return new Job(jobID, jobDuration);
	}

}
