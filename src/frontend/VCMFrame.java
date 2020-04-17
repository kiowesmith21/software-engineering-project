package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class VCMFrame extends JFrame {
	public static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400; 
	
	//private JLabel VCMLabel;
	private JLabel JobInfoLabel;
	//private JLabel CarInfoLabel;
	private JButton backButton;
	private JButton ConfirmButton;
	private JButton DeclineButton;
	private JButton SearchJobButton;
	private JTextArea JobInfo;
	//private JTextArea CarInfo;
	
	
	public VCMFrame() {
		
		this.createTextFields();
		this.createButtons();
		this.createPanel();
		
		this.setLayout(new GridLayout(2,1));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	private void createTextFields() {
		//final int FIELD_WIDTH = 10;
		//VCMLabel = new JLabel("VCM Manager View");
		JobInfoLabel = new JLabel("Job/Car Information:");
		JobInfo = new JTextArea(30,60);
		//CarInfoLabel = new JLabel("Car Information:");
		//CarInfo = new JTextArea(30,60);
		//JScrollPane scrollPane = new JScrollPane(JobInfo); 
		//JobInfo.setEditable(false);
	}
	
	
	
	private void createPanel() {
		JPanel panel = new JPanel(new GridLayout(0,1));
		//panel.add(VCMLabel);
		panel.add(JobInfoLabel);
		panel.add(JobInfo);
		panel.add(ConfirmButton);
		panel.add(DeclineButton);
		//panel.add(CarInfoLabel);
		//panel.add(CarInfo);
		panel.add(SearchJobButton);
		panel.add(backButton);
		this.add(panel);}
	
	//private void clearTextFields() {
	//	JobInfo.setText("");
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
		ConfirmButton = new JButton("Confirm Job/Car");
		
		DeclineButton = new JButton("Decline Job/Car");
		
		SearchJobButton = new JButton("Search Job/Car");
		
		backButton = new JButton("Back");
		ActionListener backListener = new BackListener();
		backButton.addActionListener(backListener);
		
	}

}
