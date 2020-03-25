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

public class VehicleControllerTest {

	public void testAddVehicle() {
		VehicularCloud vCloud = new VehicularCloud();
		VehicleController vc = new VehicleController();
		
		Vehicle testV = new Vehicle(0, 6);
		
		vc.addVehicle(testV, vCloud.vehicles);
		Assert.assertTrue(vc.vehicleExists(0, vCloud.vehicles)); //make sure the vehicle was added
	}
	
	public void testRemoveVehicle() {
		VehicularCloud vCloud = new VehicularCloud();
		VehicleController vc = new VehicleController();
		
		Vehicle testV = new Vehicle(0, 6);
		vc.addVehicle(testV, vCloud.vehicles); // a sample vehicle
		
		vc.removeVehicle(0, vCloud.vehicles); //test the method
		
		Assert.assertFalse(vc.vehicleExists(0, vCloud.vehicles)); //make sure the vehicle was removed
	}
	
	public void testVehicleExists() {
		VehicularCloud vCloud = new VehicularCloud();
		VehicleController vc = new VehicleController();
		
		Vehicle testV = new Vehicle(0, 6);
		
		vc.addVehicle(testV, vCloud.vehicles);
		Assert.assertTrue(vc.vehicleExists(0, vCloud.vehicles)); //test if vehicleExists method works
	}
	
	public void testCreateCheckpoint() {
		VehicularCloud vCloud = new VehicularCloud();
		VehicleController vc = new VehicleController();
		
		Vehicle testV = new Vehicle(0, 6);
		Job testJob = new Job(0, 5);
		
		testV.assignJob(testJob); //give the test vehicle a sample job
		
		Assert.assertNotNull(vc.createCheckpoint(testV)); //check to make sure when we test createCheckpoint that it returns the job
		
	}
	
}
