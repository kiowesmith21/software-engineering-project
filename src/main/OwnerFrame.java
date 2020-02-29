package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;

public class OwnerFrame extends JFrame {
	public static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;
	
//	private static final double DEFAULT_RATE = 5;
//	private static final double INITIAL_BALANCE = 1000;   

	private JLabel ownerIdLabel;
	private JTextField ownerIdField;
	private JLabel vehicleInfoLabel;
	private JTextField vehicleInfoField;
	private JLabel vehicleDurationLabel;
	private JTextField vehicleDurationField;
	private JButton submitButton;
	
	public OwnerFrame() {
		
		this.createTextFields();
		this.createButton();
		this.createPanel();
		
		this.setLayout(new GridLayout(2,1));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);
		
	}
	
	private void createTextFields() {
		final int FIELD_WIDTH = 10;
		ownerIdLabel = new JLabel("Client ID: ");
		ownerIdField = new JTextField(FIELD_WIDTH);
		vehicleInfoLabel = new JLabel("Job ID: ");
		vehicleInfoField = new JTextField(FIELD_WIDTH);
		vehicleDurationLabel = new JLabel("Job Duration: ");
		vehicleDurationField = new JTextField(FIELD_WIDTH);
		
	}
	
	private void clearTextFields() {
		ownerIdField.setText("");
		vehicleInfoField.setText("");
		vehicleDurationField.setText("");
	}
	
	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			PrintStream output;
			try {
				output = new PrintStream(new FileOutputStream("OwnerInput.txt", true));
				String toAppend = String.format("%s,%s,%s,%s\n",
						ownerIdField.getText(),
						 vehicleInfoField.getText(),
						 vehicleDurationField.getText(),
						 new Timestamp(System.currentTimeMillis())
						 );
				output.append(toAppend);
				output.close();
				clearTextFields();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private void createButton() {
		submitButton = new JButton("Submit");
		ActionListener listener = new SubmitListener();
		submitButton.addActionListener(listener);
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
		add(panel);
	}
	
}
