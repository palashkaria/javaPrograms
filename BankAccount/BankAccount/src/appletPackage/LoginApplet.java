/**
 * 
 */
package appletPackage;

import guiPackage.HelpFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import package1.ATMManager;
import package1.BankAccount;

/**
 * @author Palash
 *
 */
public class LoginApplet extends JApplet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4321289362144417550L;

	public void init(){
		final Container pane = getContentPane();
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
		
		//setVisible(true);
		//pack
		Dimension d = pane.getLayout().preferredLayoutSize(pane);
		setSize((int)d.getWidth(),(int)d.getHeight());
		
		//event
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					char[] pass = passField.getPassword();
				
					String passString = new String(pass);
					long accNo = Long.parseLong(textField.getText());
					final BankAccount current = ATMManager.accountLogin(accNo, passString);
					if(current!=null)
					{
						panelRight.setVisible(false);
						panelLeft.setVisible(false);
						System.out.println("visible false");
						
						
						
						//pane.setLayout(new BorderLayout());
						//make panels for   left and right

						final JPanel panelLeft = new JPanel();
						final JPanel panelRight = new JPanel();
						GridLayout grid = new GridLayout(3,0,0,10);
						panelLeft.setLayout(grid);
						panelRight.setLayout(grid);

						
						
						
						//create buttons
						final JButton withdrawButton = new JButton("Withdraw");
						final JButton secondLeftButton = new JButton("Transfer");
						final JButton thirdLeftButton = new JButton("Show Balance");
						final JButton firstRightButton = new JButton("Quick Withdrawal");
						final JButton helpButton = new JButton("Help");
					
						
						// create text area, labels, password field
						final JLabel topLabel = new JLabel("Welcome to the ATM");

						
						
						//set fonts. temporary method. need to find a more efficient way.
						Font f = new Font("Lato", Font.PLAIN, 16);
						Font f2 = new Font("Lato", Font.PLAIN, 12);

						topLabel.setFont(f);

						withdrawButton.setFont(f2);
						secondLeftButton.setFont(f2);
						thirdLeftButton.setFont(f2);
						firstRightButton.setFont(f2);
						helpButton.setFont(f2);
						
				
						panelLeft.add(withdrawButton);
						panelLeft.add(secondLeftButton);
						panelLeft.add(thirdLeftButton);
						
						panelRight.add(firstRightButton);
						panelRight.add(helpButton);
						//panelRight.add(thirdRightButton);
						
						
						//add everything to main content pane
						pane.add(topLabel, BorderLayout.NORTH);
					
						pane.add(panelLeft, BorderLayout.WEST);
						pane.add(panelRight, BorderLayout.EAST);
						panelLeft.setVisible(true);
						panelRight.setVisible(true);						
						System.out.println("visible true");
						
						//event listeners
						withdrawButton.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								panelLeft.setVisible(false);
								panelRight.setVisible(false);
								topLabel.setVisible(false);
								pane.setLayout(new BorderLayout());
								
								//create panels for holding buttons
								final JPanel panelLeft = new JPanel();
								final JPanel panelRight = new JPanel();
								GridLayout grid = new GridLayout(3,0,0,10);
								panelLeft.setLayout(grid);
								panelRight.setLayout(grid);
								
								
								
								//label
								final JLabel balanceLabel = new JLabel("Balance");
								final JLabel withdrawLabel = new JLabel("Amount to be withdrawn");
								String balance = String.valueOf(current.getBalance());
								final JLabel balanceAmount = new JLabel(balance);
								final JTextField withdrawAmount = new JTextField("",10);
								
								//create button
										final JButton submitButton = new JButton("Submit");
										
							
								
								//fonts
							//	Font f = new Font("Lato", Font.PLAIN, 16);
								Font f2 = new Font("Lato", Font.PLAIN, 12);
								submitButton.setFont(f2);
								
								// add buttons to panels
								
								panelLeft.add(balanceLabel);
								panelLeft.add(withdrawLabel);
								panelRight.add(balanceAmount);
								panelRight.add(withdrawAmount);
								panelRight.add(submitButton);		
								//add to content pane
							pane.add(panelLeft, BorderLayout.EAST);
							pane.add(panelRight, BorderLayout.WEST);
							setVisible(true);
								
								
								submitButton.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e){
										try{
										long amount = Long.parseLong(withdrawAmount.getText());
										
										if(current.withdraw(amount))
										{
										
											String newBalance = String.valueOf(current.getBalance());
											balanceAmount.setText(newBalance);
											Component frame = null;
											JOptionPane.showMessageDialog(frame, "Withdrawal Successful!");
									
											
												
											}
										else
										{
											Component frame = null;
											JOptionPane.showMessageDialog(frame, "Not enough balance!");
										}}
										catch (NumberFormatException ex){
											Component frame = null;
											JOptionPane.showMessageDialog(frame, "Enter digits only");
										}	
									}
								});
									}
								});
						
						helpButton.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
										HelpFrame frame = new HelpFrame();
										frame.setLocationRelativeTo(null);
									}
								});
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
	
}

