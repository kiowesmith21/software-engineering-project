package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WelcomeFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 100;
	
	private JLabel welcomeLabel;
	private JButton clientButton;
	private JButton ownerButton;
	
	public WelcomeFrame() {
		welcomeLabel = new JLabel("Welcome");
		
		createClientButton();
		createOwnerButton();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	class ClientButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			JFrame frame = new ClientFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		}
	}
	
//	class OwnerButtonListener implements ActionListener {
//		public void actionPerformed(ActionEvent event) {
//			JFrame frame = new OwnerFrame();
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    frame.setVisible(true);
//		}
//	}

	private void createClientButton() {
		clientButton = new JButton("Client");
		ActionListener listener = new ClientButtonListener();
		
		
		
	}
	
	private void createOwnerButton() {
		ownerButton = new JButton("Owner");
		
	}
	
	private void createPanel() {
		JPanel panel = new JPanel();
		panel.add(welcomeLabel);
		panel.add(clientButton);
		panel.add(ownerButton);
		add(panel);
	}
}
