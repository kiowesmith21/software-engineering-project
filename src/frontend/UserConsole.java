package frontend;

import javax.swing.JFrame;

public class UserConsole {
	
	public static void main(String[] args) {
		try {
			JFrame frame = new WelcomeFrame();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
