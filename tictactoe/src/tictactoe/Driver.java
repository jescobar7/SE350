package tictactoe;

/**
 * Driver for Tic-Tac-Toe game
 * @author Juan Carlos Escobar
 *
 */
public class Driver 
{
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	
	public static void main(String[] args)
	{
		new TicTacToeJFrame(FRAME_WIDTH, FRAME_HEIGHT);
	}
}