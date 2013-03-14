package tictactoe;

import gameframe.GUI;

import java.awt.*;

import javax.swing.*;

/**
 * This frame adds the Tic-Tac-Toe panel to the frame
 * @author Juan Carlos Escobar
 *
 */
public class TicTacToeJFrame extends JFrame
{
	public static final int BOARD_COLUMNS = 3;
	public static final int BOARD_ROWS = 3;
	public static final int BOARD_CAPACITY = 9;
	
	/**
	 * Initialize the GUI elements
	 */
	public TicTacToeJFrame(int frameW, int frameH) 
	{
		super("Tic-Tac-Toe");
		FRAME_WIDTH = frameW;
		FRAME_HEIGHT = frameH;
		gui = new TicTacToeGUI(FRAME_WIDTH, FRAME_HEIGHT, BOARD_COLUMNS, BOARD_ROWS);
		
		add((Component) gui, BorderLayout.CENTER );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public int FRAME_WIDTH;
	public int FRAME_HEIGHT;
	GUI gui;
	
	private static final long serialVersionUID = 6691587519795047478L;
}

