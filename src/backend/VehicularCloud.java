package backend;

import java.util.Scanner;

public class VehicularCloud {
	
	Scanner scan;
	VehicleController vehicleController;
	JobController jobController;
	UserController userController;
	
	public VehicularCloud() {
		scan = new Scanner(System.in);
		vehicleController = new VehicleController();
		jobController = new JobController();
		userController = new UserController();
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
	
	public void vehicleOwnerMenu() {
		System.out.println("Enter the your vehicle ID: ");
		System.out.println("Enter the residency time for your vehicle: ");
		
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
