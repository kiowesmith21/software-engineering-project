package frontend;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ErrorFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 100;

	private JLabel errorLabel;
	
	public  ErrorFrame(String e) {
		errorLabel = new JLabel(e);
		JPanel panel = new JPanel();
		panel.add(errorLabel);
		this.add(panel);
		this.setLayout(new GridLayout(2,1));
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setVisible(true);

	}
	
}
