package tictactoe;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import gameframe.Drawable;

/**
 * A class for drawing the Simon game board
 * @author Juan Carlos Escobar
 *
 */
public class TicTacToeDrawable implements Drawable
{
	/**
	 * Draw the background and gridlines
	 */
	public void draw(Graphics2D g2d, int w, int h)
	{
		// Background
		g2d.setPaint(background);
		g2d.fill(new Rectangle2D.Double(0, 0, w, h));
		
		// Gridlines
		g2d.setPaint(gridlines);
		g2d.draw(new Line2D.Double(0, h/3, w, h/3));
		g2d.draw(new Line2D.Double(0, h*2/3, w, h*2/3));
		g2d.draw(new Line2D.Double(w/3, 0, w/3, h));
		g2d.draw(new Line2D.Double(w*2/3, 0, w*2/3, h));	
	}
	
	/**
	 * Draw the player marks on the board
	 */
	public void draw(Graphics2D g2d, int w, int h, String b)
	{
		// draw player marks on grid
		for (int i = 0; i < b.length(); ++i)
		{
			double xpos = (i%3 + 0.5) * w / 3.0;
		    double ypos = (i/3 + 0.5) * h / 3.0;
		    double xr = w / 10.0;
		    double yr = h / 10.0;
		    // draw O's
		    if (b.charAt(i) == '2')
		    {
		    	g2d.setPaint(O);
		    	g2d.draw(new Ellipse2D.Double(xpos-xr, ypos-yr, xr*2, yr*2));
		    }
		    // draw X's
		    else if (b.charAt(i) == '1') 
		    {
		        g2d.setPaint(X);
		        g2d.draw(new Line2D.Double(xpos-xr, ypos-yr, xpos+xr, ypos+yr));
		        g2d.draw(new Line2D.Double(xpos-xr, ypos+yr, xpos+xr, ypos-yr));
		    }
		}	
	}
	
	/**
	 * Set the color for the Xs
	 */
	public void setColorX(Color c)
	{
		X = c;
	}
	
	/**
	 * Set the color for the Os
	 */
	public void setColorO(Color c)
	{
		O = c;
	}
	
	/**
	 * Set the background color
	 */
	public void setColorBG(Color bg)
	{
		background = bg;
	}
	
	/**
	 * Set the gridlines color
	 */
	public void setColorGL(Color gl)
	{
		gridlines = gl;
	}
	
	private Color background = Color.BLACK;
	private Color gridlines = Color.LIGHT_GRAY;
	private Color X = Color.RED;
	private Color O = Color.GREEN;
}
