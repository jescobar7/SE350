package memory;

import gameframe.AbstractGUI;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

/**
 * Class that handles the GUI elements for the Memory game
 * @author Juan Carlos Escobar
 *
 */
public class MemoryGUI extends AbstractGUI
{
	public MemoryGUI(int w, int h, int col, int row) {
		super(w, h, col, row);
		addMouseListener(this);
		drawBoard = new MemoryDrawable();
		game = new MemoryGame(boardCols*boardRows);
		showPattern(((MemoryGame)game).getPattern());
	}
	
	/**
	 * Display any notification changes
	 */
	private void displayNotification()
	{
		String notifyMessage = game.getNotification();
		if (notifyMessage == null) { 
			// Do nothing
		}
		else {
			displayMessage(notifyMessage);
			game.setNotification(null); 				// reset the notification system
			game.restart(game.getBoardCapacity());		// reset the game board
			repaint();
			showPattern(((MemoryGame)game).getPattern());
		}
	}
	
	/**
	 * Display the pattern.
	 * @param message the message.
	 */
	public void showPattern(String pattern)
	{
		if (JOptionPane.showConfirmDialog
				(null,
				"Enter this pattern:\n" + pattern +"\nContinue?",
				null,
				JOptionPane.YES_NO_OPTION) 
			!= JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}

	/**
	 * Draw the Memory grid
	 * @param g the Graphics component
	 */
	public void paintComponent(Graphics g) 
	{
		super.paintComponents(g);
		int w = getWidth();
		int h = getHeight();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(brushStrokeSize));
		
		drawBoard.draw(g2d, w, h);
		drawBoard.draw(g2d, w, h, game.asString());
	}
	
	/**
	 * Unused Mouse Control
	 */
	public void mouseClicked(MouseEvent me) {}

	/**
	 * Unused Mouse Control
	 */
	public void mouseEntered(MouseEvent me) {}
	
	/**
	 * Unused Mouse Control
	 */
	public void mouseExited(MouseEvent me) {}
	
	/**
	 * Retrieve the index of the grid that the user pressed
	 */
	public void mousePressed(MouseEvent me)
	{
		((MemoryGame) game).clearBoard();
		repaint();
		
		int mouseX = me.getX() * boardCols / frameWidth;
		int mouseY = me.getY() * boardRows / frameHeight;
		//System.out.println(me.getX()+","+me.getY());				// FIX MOUSE OFFSET BUG
		if (mouseX == 0 && mouseY == 0) {
			mouseIndex = 0;
		}
		if (mouseX == 1 && mouseY == 0) {
			mouseIndex = 1;
		}
		if (mouseX == 0 && mouseY == 1) {
			mouseIndex = 2;
		}
		if (mouseX == 1 && mouseY == 1) {
			mouseIndex = 3;
		}
		
		// User interaction
		if (game.getNotification() == null) {
			game.userAction(mouseIndex);
		}
		
		repaint();
		displayNotification();
	}
	
	/**
	 * Clear the GUI from all drawn pressed elements
	 */
	public void mouseReleased(MouseEvent me)
	{	
		((MemoryGame) game).clearBoard();
		repaint();

		// AI interaction
		if (game.getNotification() == null) {
			game.aiAction();
			repaint();
		}
		((MemoryGame)game).clearBoard();
		repaint();
		displayNotification();
	}
	
	private static final long serialVersionUID = 8985257810830581748L;
}
