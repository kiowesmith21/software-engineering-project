package frontend;

import java.awt.GridLayout;
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
		
		this.createClientButton();
		this.createOwnerButton();
		this.createPanel();
		
		this.setLayout(new GridLayout(2,1));
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);
	}
	
	class ClientButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			closeFrame();
			JFrame frame = new ClientFrame();
			frame.setLayout(new GridLayout(2,1));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		}
	}
	
	class OwnerButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			closeFrame();
			JFrame frame = new OwnerFrame();
			frame.setLayout(new GridLayout(2,1));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		}
	}
	
	public void closeFrame() {
		this.setVisible(false);
		this.dispose(); 
	}

	private void createClientButton() {
		clientButton = new JButton("Client");
		ActionListener listener = new ClientButtonListener();
		clientButton.addActionListener(listener);
		
	}
	
	private void createOwnerButton() {
		ownerButton = new JButton("Owner");
		ActionListener listener = new OwnerButtonListener();
		ownerButton.addActionListener(listener);
		
	}
	
	private void createPanel() {
		JPanel panel = new JPanel();
		panel.add(welcomeLabel);
		panel.add(clientButton);
		panel.add(ownerButton);
		add(panel);
	}
}