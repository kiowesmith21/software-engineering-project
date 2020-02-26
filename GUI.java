import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

/**
   This program shows a frame that is filled with two components.
*/
   public static void main(String[] args)
   {
	   
	   //---------------------------------- New User
	   
	   JFrame WelcomeFrame = new JFrame();
	      JLabel intro = new JLabel("                            Welcome to the Matrix!                           ");

	      JButton signInButton = new JButton("Sign in");
	      JButton signUpButton = new JButton("Sign up");

	      JPanel introPanel = new JPanel();
	      introPanel.add(intro);
	      introPanel.add(signInButton);
	      introPanel.add(signUpButton);
	      WelcomeFrame.add(introPanel);

	      final int IntroFRAME_WIDTH = 300;
	      final int IntroFRAME_HEIGHT = 150;
	      WelcomeFrame.setSize(IntroFRAME_WIDTH, IntroFRAME_HEIGHT);
	      WelcomeFrame.setTitle("The Matrix");
	      WelcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      WelcomeFrame.setVisible(true);
	   
	   
	   
	   //---------------------------------- Existing user
	      
      JFrame LoginFrame = new JFrame();
      JLabel login = new JLabel("  Logging into to Cloud System!");
      JLabel clientUser = new JLabel("                    Are you a Client or a User?                   ");
      //JTextField text = new JTextField(4);
      

      JButton userButton = new JButton("User!");
      JButton clientButton = new JButton("Client!");

      JPanel panel = new JPanel();
      panel.add(login);
      panel.add(clientUser);
      panel.add(userButton);
      panel.add(clientButton);
      //panel.add(text);
      LoginFrame.add(panel);

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 150;
      LoginFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      LoginFrame.setTitle("The Matrix");
      LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      LoginFrame.setVisible(true);
      
     //------------------------------------ Create Account
      
      
     //------------------------------------ Client Actions
      
      
     //------------------------------------ User Actions


      
   }
}
