/**
 * 
 */
package guiPackage;
import javax.swing.*;
import package1.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Login Frame. User has to enter Account number and password to gain access.
 * @author Palash
 *
 */
public class LoginFrame extends JFrame {
	public static final long serialVersionUID = 431231L;
	public LoginFrame(){
		super("Welcome to the ATM");
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		
		//make panels
		final JPanel panelLeft = new JPanel();
		final JPanel panelRight = new JPanel();
		panelLeft.setLayout(new GridLayout(3,0,0,10));
		panelRight.setLayout(new GridLayout(3,0,0,10));
		
		//make labels
		final JLabel accountNum = new JLabel("Enter Account Number");
		final JLabel passwd = new JLabel("Enter password");
		
		//make Button
		final JButton submitButton = new JButton("Submit!");
		
		//make text and passwd fields
		final JTextField textField = new JTextField("", 20);
		final JPasswordField passField = new JPasswordField();
		
		//add stuff
		panelLeft.add(accountNum);
		panelLeft.add(passwd);
		panelRight.add(textField);
		panelRight.add(passField);
		panelRight.add(submitButton);
		
		//add panel to content pane
		pane.add(panelLeft, BorderLayout.WEST);
		pane.add(panelRight, BorderLayout.EAST);
		
		setVisible(true);
		pack();
		
		//event
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					char[] pass = passField.getPassword();
				
					String passString = new String(pass);
					long accNo = Long.parseLong(textField.getText());
					BankAccount current = ATMManager.accountLogin(accNo, passString);
					if(current!=null)
					{
						MainATMFrame frame = new MainATMFrame(current);
						frame.setLocationRelativeTo(null);
					}
					else
					{
						Component frame = null;
						JOptionPane.showMessageDialog(frame, "WRONG");
					}
				}
			catch(Exception a)
			{
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "EXCEPTION! Please enter proper values.");
			}
			
		}});
		
		
	}
	public static void main(String[] args){
		
		LoginFrame frame = new LoginFrame();
		frame.setLocationRelativeTo(null);
	}
}
