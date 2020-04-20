package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import frontend.ClientFrame.BackListener;
import frontend.ClientFrame.SubmitListener;

import java.net.ServerSocket;
import java.net.Socket;

public class VCMFrame extends JFrame {
	public static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400; 
	
	//private JLabel VCMLabel;
	private JLabel jobInfoLabel;
	//private JLabel CarInfoLabel;
	private JButton backButton;
	private JButton confirmButton;
	private JButton declineButton;
	private JButton searchJobButton;
	private JTextArea jobInfo;
	//private JTextArea CarInfo;
	
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
		serverSocket = new ServerSocket(9806);
		socket = serverSocket.accept();
		inputStream = new DataInputStream(socket.getInputStream());
		outputStream = new DataOutputStream(socket.getOutputStream());
		
		while(true) {
			String clientInput = inputStream.readUTF();
			jobInfo.setText(clientInput);
			System.out.println(clientInput);
		}
		
	}

	private void createTextFields() {
		//final int FIELD_WIDTH = 10;
		//VCMLabel = new JLabel("VCM Manager View");
		jobInfoLabel = new JLabel("Job/Car Information:");
		jobInfo = new JTextArea(30,60);
		//CarInfoLabel = new JLabel("Car Information:");
		//CarInfo = new JTextArea(30,60);
		//JScrollPane scrollPane = new JScrollPane(jobInfo); 
		//jobInfo.setEditable(false);
	}
	
	
	
	private void createPanel() {
		JPanel panel = new JPanel(new GridLayout(0,1));
		//panel.add(VCMLabel);
		panel.add(jobInfoLabel);
		panel.add(jobInfo);
		panel.add(confirmButton);
		panel.add(declineButton);
		//panel.add(CarInfoLabel);
		//panel.add(CarInfo);
		panel.add(searchJobButton);
		panel.add(backButton);
		this.add(panel);}
	
	//private void clearTextFields() {
	//	jobInfo.setText("");
	//}
	
	public void closeFrame() {
		this.setVisible(false);
		this.dispose(); 
	}
	
	
	class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			closeFrame();
			JFrame frame = new WelcomeFrame();
			frame.setLayout(new GridLayout(2,1));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);}
		}
	
	private void createButtons() {
		//submitButton = new JButton("Submit");
		//ActionListener submitListener = new SubmitListener();
		//submitButton.addActionListener(submitListener);
		confirmButton = new JButton("Confirm Job/Car");
		
		declineButton = new JButton("Decline Job/Car");
		
		searchJobButton = new JButton("Search Job/Car");
		
		backButton = new JButton("Back");
		ActionListener backListener = new BackListener();
		backButton.addActionListener(backListener);
		
	}
	
//	private void getjobInfo() throws IOException {
//		String jobInfoIn = inputStream.readUTF();
//	}

}
