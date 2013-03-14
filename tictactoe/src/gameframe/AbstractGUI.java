package gameframe;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * GUI class that functions as the Controller (MVC) in the Grid-Based Game Framework.
 * @author Juan Carlos Escobar
 *
 */
public abstract class AbstractGUI extends JPanel implements GUI, MouseListener
{
	/**
	 * Construct a new GUI.
	 * @param w the screen width.
	 * @param h the screen height.
	 * @param col the columns on the grid board.
	 * @param row the rows on the grid board.
	 */
	public AbstractGUI(int w, int h, int col, int row)
	{
		frameWidth = w;
		frameHeight = h;
		boardCols = col;
		boardRows = row;
		clickIndex = 0;
	}
	
	/**
	 * Message to display.
	 * @param message the message.
	 */
	public void displayMessage(String message)
	{
		if (JOptionPane.showConfirmDialog
				(null,
				message +"\n\tPlay Again?",
				null,
				JOptionPane.YES_NO_OPTION) 
			!= JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	
	/**
	 * Set the brush stroke size
	 * @param size the new size
	 */
	public void setBrushStrokeSize(int size)
	{
		brushStrokeSize = size;
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public abstract void paintComponent(Graphics g);
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public abstract void mouseClicked(MouseEvent me);
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public abstract void mouseEntered(MouseEvent me);
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public abstract void mouseExited(MouseEvent me);
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public abstract void mousePressed(MouseEvent me);
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public abstract void mouseReleased(MouseEvent me);
	
	protected int frameWidth;
	protected int frameHeight;
	protected int boardCols;
	protected int boardRows;
	protected int brushStrokeSize = 5;	// default size 5
	protected int clickIndex;
	
	protected Game game;
	protected Drawable drawBoard;
	
	private static final long serialVersionUID = 661807662743055654L;
}
