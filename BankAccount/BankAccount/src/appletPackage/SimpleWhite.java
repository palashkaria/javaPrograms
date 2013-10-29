/**
 * 
 */
package appletPackage;

/**
 * @author Palash
 *
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JApplet;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SimpleWhite extends JApplet implements ActionListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected int lastX=0, lastY=0;
private JMenuItem red, green, blue;
private Color currentColor;
  public void init() {
    setBackground(Color.white);
    addMouseListener(new PositionRecorder());
    addMouseMotionListener(new LineDrawer());
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar (menuBar);
    JMenu colors = new JMenu ("Change Colors");
    
    menuBar.add (colors);
	
	red = new JMenuItem ("Red");
	green = new JMenuItem ("Green");
	blue = new JMenuItem ("Blue");
	
	red.addActionListener (this);
	green.addActionListener (this);
	blue.addActionListener (this);
	
	colors.add (red);
	colors.add (green);
	colors.add (blue);
	
	currentColor = Color.green;
  }
  
  public void actionPerformed (ActionEvent e)
	{
		// If the menu item red was selected change the current color to red
		if (e.getSource () == red)
			currentColor = Color.red;
		// If the menu item blue was selected change the current color to blue
		else if (e.getSource () == blue)
			currentColor = Color.blue;
		// If the menu item green was selected change the current color to green
		else if (e.getSource () == green)
			currentColor = Color.green;
		// repaint so that the changes are made visible.
		repaint();
	}
  
protected void record(int x, int y) {
    lastX = x; lastY = y;
  }

  private class PositionRecorder extends MouseAdapter {
	    public void mouseEntered(MouseEvent event) {
	      requestFocus(); // Plan ahead for typing
	      record(event.getX(), event.getY());
	    }

	    public void mousePressed(MouseEvent event) {
	      record(event.getX(), event.getY());
	    }
	  }
  private class LineDrawer extends MouseMotionAdapter {
	    public void mouseDragged(MouseEvent event) {
	      int x = event.getX();
	      int y = event.getY();
	      Graphics g = getGraphics();
	      g.setColor(currentColor);
	      
	      g.drawLine(lastX, lastY, x, y);
	      record(x, y);
	    }
	  }
	}