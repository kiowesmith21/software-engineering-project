package backend;

import java.util.Scanner;
import java.util.Queue; 
import java.util.LinkedList;
import java.util.HashMap;

public class VehicularCloud {
	
	Scanner scan;
	VehicleController vehicleController;
	JobController jobController;
	UserController userController;
	Queue<Job> jobQueue;
	HashMap<Integer, Vehicle> vehicles;
	HashMap<Integer, Client> clients;
	HashMap<Integer, VehicleOwner> owners;
	VehicularCloudManager vcm;
	
	/**
	 * Constructor for VC that instantiates all necessary attributes
	 */
	
	public VehicularCloud() {
		
		scan = new Scanner(System.in);
		vehicleController = new VehicleController();
		jobController = new JobController();
		userController = new UserController();
		jobQueue = new LinkedList<Job>();
		vehicles = new HashMap<Integer, Vehicle>();
		clients = new HashMap<Integer, Client>();
		owners = new HashMap<Integer, VehicleOwner>();
		vcm = new VehicularCloudManager();
		
	}
	
	public static void main(String[] args) {
		VehicularCloud vc = new VehicularCloud();
		vc.displayMainMenu();
		
	}
	
	/**
	 * method that displays the main menu and
	 * handles the inputs for this specific menu
	 */
	public void displayMainMenu() {
		loop: while(true) {
			System.out.println("A = Client\n" + 
					"B = Vehicle Owner\n" + 
					"C = Vehicular Cloud Manager\n" + 
					"D = Exit");
			String input = scan.next();
			switch(input) {
			case "A":
				this.clientMenu();
				break;
			case "B":
				this.vehicleOwnerMenu();
				break;
			case "C":
				this.VCMMenu();
				break;
			case "D":
				break loop;
			}
		}
	}
	
	/**
	 * method to display the menu for the client
	 * and handles inputs for this menu
	 * it will create new client objects and add them
	 * to the client hashmap record.
	 */
	public void clientMenu() {
		System.out.println("Enter Client ID: ");
		int id = scan.nextInt();
		Client client = userController.findClient(id, clients);
		if(client == null) {
			System.out.print("New client, enter name: ");
			String name = scan.next();
			client = new Client(id, name);
			userController.addClient(client, clients);
		}
		System.out.println("A = Submit a job\n" + 
				"B = Exit");
		String input = scan.next();
		switch (input) {
		case "A":
			Job job = this.addJob();
			client.submitJob(job);
		case "B":
			break;
		}
	}
	
	/**
	 * menu to display vehicle owner menu and
	 * handle all input for this menu
	 * it will create new VehicleOwner and vehicle objects and update
	 * the vehicle and owenrs hashmap records.
	 */
	public void vehicleOwnerMenu() {
		System.out.print("Enter vehicle owner ID: ");
		int ownerID = scan.nextInt();
		VehicleOwner owner = userController.findVehicleOwner(ownerID, owners);
		if(owner == null) {
			System.out.print("New owner, enter name: ");
			String name = scan.next();
			owner = new VehicleOwner(ownerID, name);
			userController.addVehicleOwner(owner, owners);
		}
		System.out.print("Enter the your vehicle ID: ");
		int vehicleID = scan.nextInt();
		System.out.print("Enter the residency time for your vehicle: ");
		int vehicleResTime = scan.nextInt();
		Vehicle vehicle = new Vehicle(vehicleID, vehicleResTime);
		this.vehicleController.addVehicle(vehicle, this.vehicles);
		owner.rentVehicle(vehicle);
		
	}
	
	/**
	 * menu for VCM and handles all inputs for this menu
	 */
	public void VCMMenu() {
		System.out.println("A = Calculate the completion time for the job\n" + 
				"B = Exit");
		String input = scan.next();
		switch(input) {
		case "A":
			System.out.print("Enter the job ID: ");
			int id = scan.nextInt();
			Job job = jobController.findJob(id, jobQueue);
			if (job==null) {
				System.out.println("job does not exist.");
				break;
			}
			else {
			int time = vcm.calculateJobCompletionTime(id, this.jobQueue);
			System.out.printf("The job will be completed in %s hours\n", time);
			}
		case "B":
			break;
		}
		
	}
	
	/**
	 * job submission menu. handles inputs and creates the 
	 * job object and adds it to the queue
	 * @return job object that was created
	 */
	public Job addJob() {
		System.out.print("Enter Job ID: ");
		int jobID = scan.nextInt();
		System.out.print("Enter Job Duration: ");
		int jobDuration = scan.nextInt();
		Job job = new Job(jobID, jobDuration);
		this.jobController.addJob(job, this.jobQueue);
		return job;
	}

}
