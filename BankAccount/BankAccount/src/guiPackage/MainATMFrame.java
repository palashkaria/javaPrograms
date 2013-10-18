/**
 * 
 */
package guiPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import package1.*;
/**
 * @author Palash
 *
 */
public class MainATMFrame extends JFrame {
	public static final long serialVersionUID = 4312315L;
	
	public MainATMFrame(final BankAccount current){
		
		super("ATM Machine");
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		
		
		//make panels for  center, left and right
		//final JPanel panelCenter = new JPanel();
		final JPanel panelLeft = new JPanel();
		final JPanel panelRight = new JPanel();
		GridLayout grid = new GridLayout(3,0,0,10);
		panelLeft.setLayout(grid);
		panelRight.setLayout(grid);
	//	panelCenter.setLayout(grid);
		
		
		
		//create buttons
		final JButton withdrawButton = new JButton("Withdraw");
		final JButton secondLeftButton = new JButton("Transfer");
		final JButton thirdLeftButton = new JButton("Show Balance");
		final JButton firstRightButton = new JButton("Quick Withdrawal");
		final JButton helpButton = new JButton("Help");
		//final JButton thirdRightButton = new JButton("third right");
		//final JButton submitButton = new JButton("Submit!");
		
		// create text area, labels, password field
		final JLabel topLabel = new JLabel("Welcome to the ATM");
	//	final JLabel bottomLabel = new JLabel("bottom");
	//	final JTextField textArea = new JTextField();
	//	final JPasswordField passField = new JPasswordField();
		
		
		//set fonts. temporary method. need to find a more efficient way.
		Font f = new Font("Lato", Font.PLAIN, 16);
		Font f2 = new Font("Lato", Font.PLAIN, 12);
	//	textArea.setFont(f2);
		topLabel.setFont(f);
		//bottomLabel.setFont(f);
		withdrawButton.setFont(f2);
		secondLeftButton.setFont(f2);
		thirdLeftButton.setFont(f2);
		firstRightButton.setFont(f2);
		helpButton.setFont(f2);
		//thirdRightButton.setFont(f2);
		
		
		/*//menu bar
		final JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("Help");
		mb.add(fileMenu);
		setJMenuBar(mb);
		//set font
		fileMenu.setFont(f2);*/
		
		
		//add stuff to panels
		//panelCenter.add(textArea);
	//	panelCenter.add(passField);
	//	panelCenter.add(submitButton);
		
		panelLeft.add(withdrawButton);
		panelLeft.add(secondLeftButton);
		panelLeft.add(thirdLeftButton);
		
		panelRight.add(firstRightButton);
		panelRight.add(helpButton);
		//panelRight.add(thirdRightButton);
		
		
		//add everything to main content pane
		pane.add(topLabel, BorderLayout.NORTH);
	//	pane.add(bottomLabel, BorderLayout.SOUTH);
		pane.add(panelLeft, BorderLayout.WEST);
		pane.add(panelRight, BorderLayout.EAST);
	//	pane.add(panelCenter, BorderLayout.CENTER);
		setVisible(true);
		pack();
		
		
		
		//event listeners
		withdrawButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
						WithdrawFrame frame = new WithdrawFrame(current);
						frame.setLocationRelativeTo(null);
					}
				});
		
		helpButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
						HelpFrame frame = new HelpFrame();
						frame.setLocationRelativeTo(null);
					}
				});
	
		
	}
}

	