/**
 * 
 */
package guiPackage;
import java.awt.*;
import javax.swing.*;
/**
 * @author Palash
 *
 */
public class WithdrawHelpFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1941510378036042719L;
	final JPanel draw = new JPanel(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 2068735159626022538L;
		@Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
           
            g.drawRect(10, 10, 375, 340);
            Font myFont = new Font("Lato ", Font.PLAIN, 16);
            g.setFont(myFont);
            g.drawString("Withdrawal Help", 135, 30);
            g.drawLine(10, 35, 385, 35);
            g.drawLine(200, 35, 200, 350);
            Font myFont2 = new Font("Lato ", Font.PLAIN, 14);
            g.setFont(myFont2);
            g.drawString("Click on withdrawal", 30,55);
            g.drawString("Enter Amount", 30,76);
            g.drawString("Click on Submit!", 30, 97);
            setBackground(Color.blue);
           
	}};
	public WithdrawHelpFrame(){
		Container pane = getContentPane();
		pane.add(draw);
		setVisible(true);
		setSize(400,400);
	}

}
	
