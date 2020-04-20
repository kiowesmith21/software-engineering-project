package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import java.io.PrintStream;
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

public class ClientFrame extends JFrame {
	
	public static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;

	private JLabel clientIdLabel;
	private JTextField clientIdField;
	private JLabel jobIdLabel;
	private JTextField jobIdField;
	private JLabel jobDurationLabel;
	private JTextField jobDurationField;
	private JLabel jobDeadlineLabel;
	private JTextField jobDeadlineField;
	private JButton submitButton;
	private JButton backButton;
	
	Socket socket;
	DataInputStream inputStream;
	DataOutputStream outputStream;
	
	public ClientFrame() throws IOException {
				
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
	
	public void closeFrame() {
		this.setVisible(false);
		this.dispose(); 
	}
	
	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				String jobInfo = String.format("JOB:%s,%s,%s,%s,%s\n",
						clientIdField.getText(),
						 jobIdField.getText(),
						 jobDurationField.getText(),
						 jobDeadlineField.getText(),
						 new Timestamp(System.currentTimeMillis())
						 );
				outputStream.writeUTF(jobInfo);
//				PrintStream output = new PrintStream(new FileOutputStream("ClientInput.txt", true));
//				String toAppend = String.format("%s,%s,%s,%s,%s\n",
//						clientIdField.getText(),
//						 jobIdField.getText(),
//						 jobDurationField.getText(),
//						 jobDeadlineField.getText(),
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
		ActionListener submitListener = new SubmitListener();
		submitButton.addActionListener(submitListener);
		
		backButton = new JButton("Back");
		ActionListener backListener = new BackListener();
		backButton.addActionListener(backListener);
		
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
		panel.add(backButton);
		this.add(panel);
	}
	
}
