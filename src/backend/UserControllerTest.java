package backend;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Queue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class UserControllerTest {
	
	public void testAddClient() {
		VehicularCloud vct = new VehicularCloud();
		UserController ucTest = new UserController();
		
		Client testClient = new Client(0, "Bob");
		
		ucTest.addClient(testClient, vct.clients); // add a sample client to the list
		System.out.println(ucTest.findClient(0, vct.clients)); //make sure that sample client was added
		
		Assert.assertNotNull(testClient); //Make sure the object is not null
	}
	
	public void testAddVehicleOwner() {
		VehicularCloud vct = new VehicularCloud();
		UserController ucTest = new UserController();
		
		VehicleOwner testVO = new VehicleOwner(1, "Dave");
		
		ucTest.addVehicleOwner(testVO, vct.owners);
		System.out.println(ucTest.findVehicleOwner(1, vct.owners));
		
		Assert.assertNotNull(testVO); //Make sure the object is not null
		
	}
	
	
}

