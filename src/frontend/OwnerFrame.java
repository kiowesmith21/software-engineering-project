package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
	private JLabel ownerNameLabel;
	private JTextField ownerNameField;
	private JLabel vehicleIdLabel;
	private JTextField vehicleIdField;
	private JLabel vehicleDurationLabel;
	private JTextField vehicleDurationField;
	private JButton submitButton;
	private JButton backButton;
	private JLabel responseLabel;
	
	Socket socket;
	DataInputStream inputStream;
	DataOutputStream outputStream;
	
	private String vcmResponse;
	
	public OwnerFrame() throws IOException {
		
		this.createTextFields();
		this.createButtons();
		this.createPanel();
		
		this.setLayout(new GridLayout(2,1));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			socket = new Socket("localhost", 9806);
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
		}
		catch (Exception e) {
			this.closeFrame();
			JFrame errorFrame = new ErrorFrame("error, please check if the server is running");
		}
		
	}
	
	private void createTextFields() {
		final int FIELD_WIDTH = 10;
		ownerIdLabel = new JLabel("Vehicle Owner ID: ");
		ownerIdField = new JTextField(FIELD_WIDTH);
		ownerNameLabel = new JLabel("Vehicle Owner Name: ");
		ownerNameField = new JTextField(FIELD_WIDTH);
		vehicleIdLabel = new JLabel("Vehicle ID: ");
		vehicleIdField = new JTextField(FIELD_WIDTH);
		vehicleDurationLabel = new JLabel("Vehicle Duration: ");
		vehicleDurationField = new JTextField(FIELD_WIDTH);
		responseLabel = new JLabel();
		
	}
	
	private void clearTextFields() {
		ownerIdField.setText("");
		ownerNameField.setText("");
		vehicleIdField.setText("");
		vehicleDurationField.setText("");
	}
	
	public void closeFrame() {
		this.setVisible(false);
		this.dispose(); 
	}
	
	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String carInfo = String.format("CAR:%s,%s,%s,%s,%s",
						ownerIdField.getText(),
						ownerNameField.getText(),
						 vehicleIdField.getText(),
						 vehicleDurationField.getText(),
						 new Timestamp(System.currentTimeMillis())
						 );
				outputStream.writeUTF(carInfo);
				clearTextFields();
				
				while(true) {
					vcmResponse = inputStream.readUTF();
					if (vcmResponse.equals("car_confirmed")) {
						responseLabel.setText("Car accepted!");
						break;
					}
					else if (vcmResponse.equals("car_declined")) {
						responseLabel.setText("Car declined!");
						break;
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				socket.close();
				inputStream.close();
				outputStream.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			closeFrame();
			JFrame frame = new WelcomeFrame(getLocation());
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
		panel.add(ownerNameLabel);
		panel.add(ownerNameField);
		panel.add(vehicleIdLabel);
		panel.add(vehicleIdField);
		panel.add(vehicleDurationLabel);
		panel.add(vehicleDurationField);
		panel.add(submitButton);
		panel.add(backButton);
		panel.add(responseLabel);
		this.add(panel);
	}
	
}
