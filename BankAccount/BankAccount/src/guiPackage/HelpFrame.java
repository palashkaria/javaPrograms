/**
 * 
 */
package guiPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Palash
 *
 */
public class HelpFrame extends JFrame{
	public static final long serialVersionUID = 431235L;

	public HelpFrame()
	{
		super("Help");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(3,2,10,10));
		
		//buttons
		final JButton wHelp = new JButton("Withdrawal Help");
		final JButton tHelp = new JButton("Transfer Help");
		final JButton sbHelp = new JButton("Show Balance Help");
		final JButton qwHelp = new JButton("Quick Withdrawal Help");
		final JButton exit = new JButton("Exit Help");
		
		pane.add(wHelp);
		pane.add(tHelp);
		pane.add(sbHelp);
		pane.add(qwHelp);
		pane.add(exit);
		
		setVisible(true);
		pack();
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				});
		wHelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				WithdrawHelpFrame frame = new WithdrawHelpFrame();
				frame.setLocationRelativeTo(null);
					}
				});
	}
}
