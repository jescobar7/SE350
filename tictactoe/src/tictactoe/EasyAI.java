package tictactoe;

import gameframe.AI;

import java.util.Random;

/**
 * A simple AI Player
 * @author Juan Carlos Escobar
 *
 */
public class EasyAI implements AI {

	/**
	 * Construct a new simple AI player
	 * @param m the icon of the player; 1(X's) or 2(O's)
	 */
	public EasyAI(int id)
	{
		rn = new Random();
		this.id = id;
	}

	/**
	 * Get AI's id
	 * @return the icon 
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Get AI's move
	 * @return the move
	 */
	public int getMove()
	{
		generateMove();
		return move;
	}

	/**
	 * Randomly generate a move
	 */
	private void generateMove()
	{
		move = rn.nextInt(9);
	}

	private int id;		// am I 1(X's) or 2(O's)?
	private int move;	// generated a new move
	private Random rn;
}
