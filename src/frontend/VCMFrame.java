package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream inputStream;
	DataOutputStream outputStream;
	
	
	public VCMFrame() throws IOException {
		
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
				this.clientInput = in.substring(4,in.length()-1) + "\n";
				jobInfo.setText(clientInput);
			}
			else {
				this.ownerInput = in.substring(4,in.length()-1) +  "\n";
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
			try {
				output = new PrintStream(new FileOutputStream("ClientInput.txt", true));
				output.append(clientInput);
				output.close();
				outputStream.writeUTF("job_confirmed");
				jobInfo.setText("");
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
			try {
				output = new PrintStream(new FileOutputStream("OwnerInput.txt", true));
				output.append(ownerInput);
				output.close();
				outputStream.writeUTF("car_confirmed");
				carInfo.setText("");
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
