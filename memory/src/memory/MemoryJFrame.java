package memory;

import gameframe.GUI;

import java.awt.*;

import javax.swing.*;

/**
 * This frame adds the Simon panel to the frame
 * @author Juan Carlos Escobar
 *
 */
public class MemoryJFrame extends JFrame
{
	public static final int BOARD_COLUMNS = 2;
	public static final int BOARD_ROWS = 2;
	public static final int BOARD_CAPACITY = 4;
	
	/**
	 * Initialize the GUI elements
	 */
	public MemoryJFrame(int frameW, int frameH) 
	{
		super("Memory!");
		FRAME_WIDTH = frameW;
		FRAME_HEIGHT = frameH;
		gui = new MemoryGUI(FRAME_WIDTH, FRAME_HEIGHT, BOARD_COLUMNS, BOARD_ROWS);
		
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

