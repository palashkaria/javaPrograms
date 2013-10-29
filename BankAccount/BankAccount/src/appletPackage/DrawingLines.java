package appletPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * Plot a graph
 * @author Palash
 *
 */
public class DrawingLines extends JApplet {   
	/**
	 * 
	 */
	private static final long serialVersionUID = 2311056954269756777L;
	int width, height;   
	int m = 100;
	int c = 180;
	int x0 = 250;
	int y0 = 250;
	
public void init() 
	{   
	Container pane = getContentPane();
	pane.setLayout(new BorderLayout());
	setSize(500, 500);
	width = 500;// getSize().width;      
	height = 500; //getSize().height;    
	setBackground(Color.black);
	m=Integer.parseInt(JOptionPane.showInputDialog("Enter the slope"));
	c=Integer.parseInt(JOptionPane.showInputDialog("Enter the constant"));
	JLabel label = new JLabel("Line Plotter");
	pane.add(label, BorderLayout.NORTH );
	pane.add(draw, BorderLayout.CENTER);
	
	 }
final JPanel draw = new JPanel(){
	public void paint(Graphics g){
		g.setColor( Color.blue );
		draw.setBackground( Color.black );
		for ( int i = 0; i < 5; ++i ){        
			g.drawLine( width, height*i/5, 0, height*i/5 );
			
			g.drawLine(width*i/5, height, width*i/5, 0);		
		}
		for ( int i = -5; i < 5; ++i ){    
			int j=0;
			g.drawString("("+(((x0+width*i/5)-250)/100)+","+(((y0+height*j/5)-250)/100)+")",x0+width*i/5,y0+height*j/5);
		}
		g.setColor(Color.red);
		g.drawLine( width/2, height, width/2, 0 );
		g.drawLine( 0, height/2, width, height/2 );
		g.setColor(Color.ORANGE);
		
		
		//g.drawString("Line Plotter", 20, 20);
		int unit=width/5;
		
		if(c!=0)
			g.drawLine(x0-(-c/m)*unit*10,(x0-unit*c*11),((x0)+(-c/m)*unit*11),(x0+(unit*c*10)));
		else
			g.drawLine(x0,y0,x0*unit,(x0/m)*unit);
	}
};
/*public void paint( Graphics g )
	 {
	
		g.setColor( Color.green );      
		for ( int i = 0; i < 5; ++i ){        
			g.drawLine( width, height*i/5, 0, height*i/5 );
			
			g.drawLine(width*i/5, height, width*i/5, 0);		
		}
		for ( int i = -5; i < 5; ++i ){    
			int j=0;
			g.drawString("("+(((x0+width*i/5)-250)/100)+","+(((y0+height*j/5)-250)/100)+")",x0+width*i/5,y0+height*j/5);
		}
		g.setColor(Color.red);
		g.drawLine( width/2, height, width/2, 0 );
		g.drawLine( 0, height/2, width, height/2 );
		g.setColor(Color.yellow);
		
		
		//g.drawString("Line Plotter", 20, 20);
		int unit=width/5;
		
		if(c!=0)
			g.drawLine(x0-(-c/m)*unit*10,(x0-unit*c*11),((x0)+(-c/m)*unit*11),(x0+(unit*c*10)));
		else
			g.drawLine(x0,y0,x0*unit,(x0/m)*unit);
	 }*/
}