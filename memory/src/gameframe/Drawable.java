package gameframe;

import java.awt.Graphics2D;

/**
 * A Drawable Interface.
 * Functions as the View (MVC) of the Grid-Based Game Framework.
 * @author Juan Carlos Escobar
 *
 */
public interface Drawable 
{
	/**
	 * Draw the background elements of the board
	 * @param g2d Graphis2d Object
	 * @param w width of the screen.
	 * @param h height of the screen.
	 */
	void draw(Graphics2D g2d, int w, int h);
	
	/**
	 * Draw the player and AI elements of the game
	 * @param g2d Graphis2d Object
	 * @param w width of the screen.
	 * @param h height of the screen.
	 * @param b the elements as a string 
	 */
	void draw(Graphics2D g2d, int w, int h, String b);
}