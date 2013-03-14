package tictactoe;

import gameframe.AbstractGUI;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

/**
 * Class that handles the GUI elements for the game
 * @author Juan Carlos Escobar
 *
 */
public class TicTacToeGUI extends AbstractGUI
{
	public TicTacToeGUI(int w, int h, int col, int row) {
		super(w, h, col, row);
		addMouseListener(this);
		drawBoard = new TicTacToeDrawable();
		game = new TicTacToeGame(boardCols*boardRows);
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
		}
	}

	/**
	 * Draw the tic-tac-toe grid
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
	 * Handles the user mouse click events
	 */
	public void mouseClicked(MouseEvent me) 
	{
		int mouseX = me.getX() * boardCols / frameWidth;
		int mouseY = me.getY() * boardRows / frameHeight;
		clickIndex = mouseX + 3 * mouseY;
		
		// Only allow adding elements to grid if spot is empty
		if (game.isAvailable(clickIndex) == true)
		{
			// User interaction
			if (game.getNotification() == null) {
				game.userAction(clickIndex);
			}
			
			// AI interaction
			if (game.getNotification() == null) {
				game.aiAction();
			}
		}
		repaint();
		displayNotification();
	}

	/**
	 * Unused Mouse Control
	 */
	public void mouseEntered(MouseEvent me) {}
	
	/**
	 * Unused Mouse Control
	 */
	public void mouseExited(MouseEvent me) {}
	
	/**
	 * Unused Mouse Control
	 */
	public void mousePressed(MouseEvent me) {}
	
	/**
	 * Unused Mouse Control
	 */
	public void mouseReleased(MouseEvent me) {}
	
	private static final long serialVersionUID = 8985257810830581748L;
}
