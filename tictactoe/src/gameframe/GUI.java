package gameframe;

import java.awt.Graphics;

/**
 * A GUI interface
 * @author Juan Carlos Escobar
 *
 */
public interface GUI
{
	/**
	 * Message to display.
	 * @param message the message.
	 */
	void displayMessage(String message);
	
	/**
	 * Set the brush stroke size
	 * @param size the new size
	 */
	void setBrushStrokeSize(int size);
	
	/**
	 * The components to paint
	 * @param g
	 */
	void paintComponent(Graphics g);
}
