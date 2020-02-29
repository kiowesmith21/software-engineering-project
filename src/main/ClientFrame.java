package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.*;
import java.util.*;
import java.sql.Timestamp;

public class ClientFrame extends JFrame {
	public static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;
	
//	private static final double DEFAULT_RATE = 5;
//	private static final double INITIAL_BALANCE = 1000;   

	private JLabel clientIdLabel;
	private JTextField clientIdField;
	private JLabel jobIdLabel;
	private JTextField jobIdField;
	private JLabel jobDurationLabel;
	private JTextField jobDurationField;
	private JLabel jobDeadlineLabel;
	private JTextField jobDeadlineField;
	private JButton submitButton;
	public ClientFrame() {
		
		createTextFields();
		createButton();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
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
	
	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("CLIENT ID: " + jobIdField.getText());
		}
	}
	
	private void createButton() {
		submitButton = new JButton("Submit");
		ActionListener listener = new SubmitListener();
		submitButton.addActionListener(listener);
	}
	
	private void createPanel() {
		JPanel panel = new JPanel(new GridLayout(0,1));
		panel.add(clientIdLabel);
		panel.add(clientIdField);
		panel.add(jobIdLabel);
		panel.add(jobIdField);
		panel.add(jobDurationLabel);
		panel.add(jobDurationField);
		panel.add(jobDeadlineLabel);
		panel.add(jobDeadlineField);
		panel.add(submitButton);
		add(panel);
	}
	
}
