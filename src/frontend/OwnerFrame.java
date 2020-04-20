package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import java.io.PrintStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.net.Socket;

import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class OwnerFrame extends JFrame {
	public static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;   

	private JLabel ownerIdLabel;
	private JTextField ownerIdField;
	private JLabel vehicleInfoLabel;
	private JTextField vehicleInfoField;
	private JLabel vehicleDurationLabel;
	private JTextField vehicleDurationField;
	private JButton submitButton;
	private JButton backButton;                  
	
	Socket socket;
	DataInputStream inputStream;
	DataOutputStream outputStream;
	
	public OwnerFrame() {
		
		this.createTextFields();
		this.createButtons();
		this.createPanel();
		
		this.setLayout(new GridLayout(2,1));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		try {
			socket = new Socket("localhost", 9806);
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
		}
		catch (Exception e) {
			this.closeFrame();
			JFrame errorFrame = new ErrorFrame(e.toString());
		}
		
	}
	
	private void createTextFields() {
		final int FIELD_WIDTH = 10;
		ownerIdLabel = new JLabel("Owner ID: ");
		ownerIdField = new JTextField(FIELD_WIDTH);
		vehicleInfoLabel = new JLabel("Vehicle Info: ");
		vehicleInfoField = new JTextField(FIELD_WIDTH);
		vehicleDurationLabel = new JLabel("Vehicle Duration: ");
		vehicleDurationField = new JTextField(FIELD_WIDTH);
		
	}
	
	private void clearTextFields() {
		ownerIdField.setText("");
		vehicleInfoField.setText("");
		vehicleDurationField.setText("");
	}
	
	public void closeFrame() {
		this.setVisible(false);
		this.dispose(); 
	}
	
	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String carInfo = String.format("CAR:%s,%s,%s,%s\n",
						ownerIdField.getText(),
						 vehicleInfoField.getText(),
						 vehicleDurationField.getText(),
						 new Timestamp(System.currentTimeMillis())
						 );
				outputStream.writeUTF(carInfo);
//				PrintStream output = new PrintStream(new FileOutputStream("OwnerInput.txt", true));
//				String toAppend = String.format("%s,%s,%s,%s\n",
//						ownerIdField.getText(),
//						 vehicleInfoField.getText(),
//						 vehicleDurationField.getText(),
//						 new Timestamp(System.currentTimeMillis())
//						 );
//				output.append(toAppend);
//				output.close();
				clearTextFields();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			closeFrame();
			JFrame frame = new WelcomeFrame();
			frame.setLayout(new GridLayout(2,1));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		}
	}
	
	
	private void createButtons() {
		submitButton = new JButton("Submit");
		ActionListener listener = new SubmitListener();
		submitButton.addActionListener(listener);
		
		backButton = new JButton("Back");
		ActionListener backListener = new BackListener();
		backButton.addActionListener(backListener);
	}
	
	private void createPanel() {
		JPanel panel = new JPanel(new GridLayout(0,1));
		panel.add(ownerIdLabel);
		panel.add(ownerIdField);
		panel.add(vehicleInfoLabel);
		panel.add(vehicleInfoField);
		panel.add(vehicleDurationLabel);
		panel.add(vehicleDurationField);
		panel.add(submitButton);
		panel.add(backButton);
		this.add(panel);
	}
	
}
