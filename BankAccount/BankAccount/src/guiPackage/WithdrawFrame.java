/**
 * 
 */
package guiPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import package1.*;
import javax.swing.*;
/**
 * @author Palash
 *
 */
public class WithdrawFrame extends JFrame{
	public static final long serialVersionUID = 431315L;
	
public WithdrawFrame(final BankAccount current){
		
		super("Cash Withdrawal");
		Container pane = getContentPane();
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
		pack();
		
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
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
				}
			}
		});

}



}

