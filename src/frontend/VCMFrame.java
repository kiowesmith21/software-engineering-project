package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.util.Scanner;


public class VCMFrame extends JFrame {
	public static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400; 
	
	private String clientInput;
	private String ownerInput;
	
	//private JLabel VCMLabel;
	private JLabel jobInfoLabel;
	private JLabel carInfoLabel;
	//private JButton backButton;
	private JButton confirmJobButton;
	private JButton declineJobButton;
	private JButton confirmCarButton;
	private JButton declineCarButton;
	//private JButton searchJobButton;
	private JTextArea jobInfo;
	private JTextArea carInfo;
	
	private JLabel messageToVCM;
	
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream inputStream;
	DataOutputStream outputStream;
	
	Connection connection;
	String url;
	String username;
	String password;
	
	
	public VCMFrame() throws IOException, SQLException{
		
		
		this.connectToDB();
		
		this.createTextFields();
		this.createButtons();
		this.createPanel();
		this.setLayout(new GridLayout(2,1));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.initServer();
		
		while(true) {
			try {
			String in = inputStream.readUTF();
			if (in.substring(0,4).equals("JOB:")) {
				this.clientInput = in.substring(4,in.length()-1);
				jobInfo.setText(clientInput);
			}
			else {
				this.ownerInput = in.substring(4,in.length()-1);
				carInfo.setText(ownerInput);
			}
			}
			catch(Exception e) {
				socket.close();
				serverSocket.close();
				this.initServer();
				continue;
			}

		}
		
	}

	private void createTextFields() {
		//final int FIELD_WIDTH = 10;
		//VCMLabel = new JLabel("VCM Manager View");
		jobInfoLabel = new JLabel("Job Information:");
		jobInfo = new JTextArea(30,60);
		carInfoLabel = new JLabel("Car Information:");
		carInfo = new JTextArea(30,60);
		messageToVCM = new JLabel();
		//JScrollPane scrollPane = new JScrollPane(jobInfo); 
		jobInfo.setEditable(false);
		carInfo.setEditable(false);
	}
	
	private void initServer() throws IOException {
		serverSocket = new ServerSocket(9806);
		socket = serverSocket.accept();
		inputStream = new DataInputStream(socket.getInputStream());
		outputStream = new DataOutputStream(socket.getOutputStream());
	}
	
	private void connectToDB() throws SQLException { 
		this.url = "jdbc:mysql://localhost:3306/VC3?useTimezone=true&serverTimezone=UTC";
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your MySQL username: ");
		this.username = scan.nextLine();
		System.out.print("Enter your MySQL password: ");
		this.password = scan.nextLine();
		this.connection = DriverManager.getConnection(url, username, password);
		scan.close();
	}
	
	private void createPanel() {
		JPanel panel = new JPanel(new GridLayout(0,1));
		//panel.add(VCMLabel);
		panel.add(jobInfoLabel);
		panel.add(jobInfo);
		panel.add(confirmJobButton);
		panel.add(declineJobButton);
		panel.add(carInfoLabel);
		panel.add(carInfo);
		panel.add(confirmCarButton);
		panel.add(declineCarButton);
		panel.add(messageToVCM);
		//panel.add(searchJobButton);
		//panel.add(backButton);
		this.add(panel);}
	
	
	public void closeFrame() {
		this.setVisible(false);
		this.dispose(); 
	}
	
	class ConfirmJobListener implements ActionListener {
		
		PrintStream output;
		
		public void actionPerformed(ActionEvent event) {

			String[] fields = clientInput.split(",");
			String clientID = fields[0];
			String clientName = fields[1];
			String jobID = fields[2];
			String jobDuration = fields[3];
			String timestamp = fields[4]; 
			int row1, row2;
			Statement statement;
			try {
				String sql1 = String.format("INSERT INTO client (clientID, name)" + 
						" VALUES ('%s', '%s')", clientID, clientName);
				statement = connection.createStatement();
				row1 = statement.executeUpdate(sql1);
				if (row1 > 0) {
					System.out.println("client data inserted");
				} 
				else {
					System.out.println("error inserting client data");
				}
//				output = new PrintStream(new FileOutputStream("ClientInput.txt", true));
//				output.append(clientInput + "\n");
//				output.close();
//				outputStream.writeUTF("job_confirmed");
			}
			catch (SQLIntegrityConstraintViolationException e) {
				//Do nothing continue to insert job
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				statement = connection.createStatement();
				String sql2 = String.format("INSERT INTO job (jobID, duration, timeSubmitted, clientID)" + 
					" VALUES ('%s', '%s', '%s', '%s')", jobID, jobDuration, timestamp, clientID);
				row2 = statement.executeUpdate(sql2);
				if (row2 > 0) {
					System.out.println("job data inserted");
					outputStream.writeUTF("job_confirmed");
					messageToVCM.setText("job confirmed");
				}
				else {
					System.out.println("error inserting job data");
				}
				jobInfo.setText("");
			}
			catch (SQLIntegrityConstraintViolationException e) {
				messageToVCM.setText("error: job ID already in use. please decline job");
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	class DeclineJobListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				outputStream.writeUTF("job_declined");
				messageToVCM.setText("job declined");
				jobInfo.setText("");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	class ConfirmCarListener implements ActionListener {
		
		PrintStream output;
		
		public void actionPerformed(ActionEvent event) {
			String[] fields = ownerInput.split(",");
			String ownerID = fields[0];
			String ownerName = fields[1];
			String vehicleID = fields[2];
			String vehicleDuration = fields[3];
			String timestamp = fields[4];
			Statement statement;
			int row1, row2;
			try {
				String sql1 = String.format("INSERT INTO owner (ownerID, name)" + 
						" VALUES ('%s', '%s')", ownerID, ownerName);
				statement = connection.createStatement();
				row1 = statement.executeUpdate(sql1);
				if (row1 > 0) {
					System.out.println("owner data inserted");
				} 
				else {
					System.out.println("error inserting owner data");
				}
//				output = new PrintStream(new FileOutputStream("OwnerInput.txt", true));
//				output.append(ownerInput + "\n");
//				output.close();
//				outputStream.writeUTF("car_confirmed");
			}
			catch (SQLIntegrityConstraintViolationException e) {
				//DO nothing, continue with vehicle insert
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				String sql2 = String.format("INSERT INTO vehicle (vehicleID, duration, timeSubmitted, ownerID)" + 
						" VALUES ('%s', '%s', '%s', '%s')", vehicleID, vehicleDuration, timestamp, ownerID);
				statement = connection.createStatement();
				row2 = statement.executeUpdate(sql2);
				if (row2 > 0) {
					System.out.println("vehicle data inserted");
					messageToVCM.setText("vehicle confirmed");
					outputStream.writeUTF("car_confirmed");
				}
				else {
					System.out.println("error inserting vehicle data");
					
				}
				carInfo.setText("");
			}
			catch (SQLIntegrityConstraintViolationException e) {
				messageToVCM.setText("error: vehicle ID already in use. please decline vehicle");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class DeclineCarListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				outputStream.writeUTF("car_declined");
				messageToVCM.setText("car declined");
				carInfo.setText("");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
//	class BackListener implements ActionListener {
//		
//		public void actionPerformed(ActionEvent event) {
//			closeFrame();
//			JFrame frame = new WelcomeFrame();
//			frame.setLayout(new GridLayout(2,1));
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    frame.setVisible(true);
//		    }
//		
//		}
	
	private void createButtons() {

		confirmJobButton = new JButton("Confirm Job");
		ActionListener confirmJobListener = new ConfirmJobListener();
		confirmJobButton.addActionListener(confirmJobListener);
		
		declineJobButton = new JButton("Decline Job");
		ActionListener declineJobListener = new DeclineJobListener();
		declineJobButton.addActionListener(declineJobListener);
		
		confirmCarButton = new JButton("Confirm Car");
		ActionListener confirmCarListener = new ConfirmCarListener();
		confirmCarButton.addActionListener(confirmCarListener);
		
		declineCarButton = new JButton("Decline Car");
		ActionListener declineCarListener = new DeclineCarListener();
		declineCarButton.addActionListener(declineCarListener);
		
		//searchJobButton = new JButton("Search Job/Car");
		
//		backButton = new JButton("Back");
//		ActionListener backListener = new BackListener();
//		backButton.addActionListener(backListener);
		
	}
	
}
