package appletPackage;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
public class DrawingLines extends Applet {   
	int width, height;   
	int m = 100;
	int c = 180;
	int x0 = 250;
	int y0 = 250;
	
public void init() 
	{   
	setSize(500, 500);
	width = 500;// getSize().width;      
	height = 500; //getSize().height;    
	setBackground( Color.black );  
	
	 }   
public void paint( Graphics g )
	 {  
	g.setColor( Color.green );      
	for ( int i = 0; i < 50; ++i ){        
			 g.drawLine( width, height*i/50, 0, height*i/50 );
			 g.drawLine(width*i/50, height, width*i/50, 0);
		}   
	g.setColor(Color.red);
	g.drawLine( width/2, height, width/2, 0 );
	g.drawLine( 0, height/2, width, height/2 );
	g.setColor(Color.yellow);
	
	
	//g.drawLine(x0, (m*x0)+c, 250, 250);
	
	 }
}