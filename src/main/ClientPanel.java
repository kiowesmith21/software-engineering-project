package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;


public class ClientPanel extends JPanel {
	
	private JLabel clientIdLabel;
	private JTextField clientIdField;
	private JLabel jobIdLabel;
	private JTextField jobIdField;
	private JLabel jobDurationLabel;
	private JTextField jobDurationField;
	private JLabel jobDeadlineLabel;
	private JTextField jobDeadlineField;
	private JButton submitButton;
	
	public ClientPanel() {
		
		super(new GridLayout(0,1));
		this.createTextFields();
		this.createButton();
		this.populatePanel();
		
	}
	
	private void createTextFields() {
		final int FIELD_WIDTH = 10;
		clientIdLabel = new JLabel("Client ID: ");
		clientIdField = new JTextField(FIELD_WIDTH);
		jobIdLabel = new JLabel("Job ID: ");
		jobIdField = new JTextField(FIELD_WIDTH);
		jobDurationLabel = new JLabel("Job Duration: ");
		jobDurationField = new JTextField(FIELD_WIDTH);
		jobDeadlineLabel = new JLabel("Job Deadline: ");
		jobDeadlineField = new JTextField(FIELD_WIDTH);
		
	}
	
	private void clearTextFields() {
		clientIdField.setText("");
		jobIdField.setText("");
		jobDurationField.setText("");
		jobDeadlineField.setText("");
	}
	
	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			PrintStream output;
			try {
				output = new PrintStream(new FileOutputStream("ClientInput.txt", true));
				String toAppend = String.format("%s,%s,%s,%s,%s\n",
						clientIdField.getText(),
						 jobIdField.getText(),
						 jobDurationField.getText(),
						 jobDeadlineField.getText(),
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
	
	private void populatePanel() {
		this.add(clientIdLabel);
		this.add(clientIdField);
		this.add(jobIdLabel);
		this.add(jobIdField);
		this.add(jobDurationLabel);
		this.add(jobDurationField);
		this.add(jobDeadlineLabel);
		this.add(jobDeadlineField);
		this.add(submitButton);
	}
}
