package memory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import gameframe.Drawable;

/**
 * A class for drawing the Simon grid board.
 * @author Juan Carlos Escobar
 *
 */
public class MemoryDrawable implements Drawable
{
	/**
	 * Draw the background and gridlines.
	 */
	public void draw(Graphics2D g2d, int w, int h)
	{
		// Background
		g2d.setPaint(background);
		g2d.fill(new Rectangle2D.Double(0, 0, w, h));
		
		// Gridlines
		g2d.setPaint(gridlines);
		g2d.draw(new Line2D.Double(0, h/100, w, h/100)); 	// horizontal top
		g2d.draw(new Line2D.Double(0, h/2, w, h/2)); 		// horizontal middle
		g2d.draw(new Line2D.Double(0, h-4, w, h-4)); 		// horizontal bottom
		
		g2d.draw(new Line2D.Double(w/100, 0, w/100, h));		// vertical left
		g2d.draw(new Line2D.Double(w/2, 0, w/2, h));		// vertical middle
		g2d.draw(new Line2D.Double(w-4, 0, w-4, h));		// vertical right
		
		for (int i = 0; i < 4; ++i)
		{
			double xpos = (i % 2 + 0.5) * w / 2.0;
		    double ypos = (i / 2 + 0.5) * h / 2.0;
		    double xr = w / 4.25;
		    double yr = h / 4.25;
		    
		    drawRectangle(g2d, i+4, xpos-xr, ypos-yr, xr, yr);
		}
		
	}
	
	/**
	 * Draw the player marks on the board.
	 */
	public void draw(Graphics2D g2d, int w, int h, String b)
	{
		//System.out.println(b.toString());
		
		// draw player marks on grid
		for (int i = 0; i < b.length(); ++i)
		{
			double xpos = (i % 2 + 0.5) * w / 2.0;
		    double ypos = (i / 2 + 0.5) * h / 2.0;
		    double xr = w / 4.25;
		    double yr = h / 4.25;
		    
		    if (b.charAt(i) == '1') {
		    	drawRectangle(g2d, i, xpos-xr, ypos-yr, xr, yr);
		    }
		    else if (b.charAt(i) == '2') {
		    	drawRectangle(g2d, i, xpos-xr, ypos-yr, xr, yr);
		    }
		    else if (b.charAt(i) == '3') {
		    	drawRectangle(g2d, i, xpos-xr, ypos-yr, xr, yr);
		    }
		    else if (b.charAt(i) == '4') {
		    	drawRectangle(g2d, i, xpos-xr, ypos-yr, xr, yr);
		    }
		}
		
		// Redraw gridlines ON TOP of squares
		g2d.setPaint(gridlines);
		g2d.draw(new Line2D.Double(0, h/100, w, h/100)); 	// horizontal top
		g2d.draw(new Line2D.Double(0, h/2, w, h/2)); 		// horizontal middle
		g2d.draw(new Line2D.Double(0, h-4, w, h-4)); 		// horizontal bottom
		
		g2d.draw(new Line2D.Double(w/100, 0, w/100, h));	// vertical left
		g2d.draw(new Line2D.Double(w/2, 0, w/2, h));		// vertical middle
		g2d.draw(new Line2D.Double(w-4, 0, w-4, h));		// vertical right
	}
	
	/**
	 * Draw the rectangles.
	 * @param id the id.
	 */
	private void drawRectangle(Graphics2D g2d, int id, double x, double y, double w, double h)
	{
		setSquareColor(id);
    	g2d.setPaint(color);
    	rectangle = new Rectangle2D.Double(x, y, w*2, h*2);
    	g2d.draw(rectangle);
    	g2d.fill(rectangle);
	}
	
	/**
	 * Set the color for the square.
	 */
	public void setSquareColor(int colorId)
	{
		switch (colorId+1)
		{
			case 1:
				color = Color.GREEN;
				break;
			case 2:
				color = Color.RED;
				break;
			case 3:
				color = Color.YELLOW;
				break;
			case 4:
				color = Color.BLUE;
				break;
			case 5:
				color = new Color(Integer.parseInt( "215E21",16));
				break;
			case 6:
				color = new Color(Integer.parseInt( "8C1717",16));
				break;
			case 7:
				color = new Color(Integer.parseInt( "808000",16));
				break;
			case 8:
				color = new Color(Integer.parseInt( "23238E",16));
				break;
			default:
				break;
		
		}
	}
	
	/**
	 * Set the background color.
	 */
	public void setColorBG(Color bg) {
		background = bg;
	}
	
	/**
	 * Set the gridlines color.
	 */
	public void setColorGL(Color gl) {
		gridlines = gl;
	}
	
	private Color background = Color.BLACK;
	private Color gridlines = Color.DARK_GRAY;
	private Color color;
	private Shape rectangle;
}
