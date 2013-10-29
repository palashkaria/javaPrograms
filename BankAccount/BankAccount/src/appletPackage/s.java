package appletPackage;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class s extends Applet {
  /**
	 * 
	 */
	private static final long serialVersionUID = -100545168174191059L;
protected int lastX=0, lastY=0;	
  public void init() {
    setBackground(Color.white);
    setForeground(Color.blue);
    addMouseListener(new PositionRecorder());
    addMouseMotionListener(new LineDrawer());
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
      g.drawLine(lastX, lastY, x, y);
      record(x, y);
    }
  }
}