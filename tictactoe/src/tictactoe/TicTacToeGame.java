package tictactoe;

import gameframe.AbstractGame;

/**
 * Class that allows user to play a game of Tic Tac Toe
 * @author Juan Carlos Escobar
 *
 */
public class TicTacToeGame extends AbstractGame
{	
	public TicTacToeGame(int capacity)
	{
		super(capacity);				// create a new ArrayBoard with capacity
		currentPlayer = 0;				// no current player
		p1TotalMoves = 0;
		p2TotalMoves = 0;
		totalMoves = 0;
		setAI(new EasyAI(2));
	}
	
	/**
     * User action
     * @param index the index of the grid the user clicked on
     */
	public void userAction(int choice)
    {		
		if (choice >= 0 && choice < getBoardCapacity() && getBoardElement(choice) == 0)
		{
			currentPlayer = 1;
			board.setElement(choice, currentPlayer);
			p1TotalMoves++;
			totalMoves++;
			checkWinner(currentPlayer);
		}
    }
    
    /**
     * AI action
     */
    public void aiAction()
    {
    	int aiPlay = ai.getMove();
    	currentPlayer = ai.getId();
		while (!board.isAvailable(aiPlay)) {
			aiPlay = ai.getMove();
		}
		board.setElement(aiPlay, currentPlayer); 
		p2TotalMoves++;
		totalMoves++;
		checkWinner(currentPlayer);
    }
    
    /**
     * Check if player is a winner
     * @param player the player
     */
    public void checkWinner(int player)
    {
    	switch (isWinner(player))
		{
			case -1:
				setNotification(TIE);
				p1TotalMoves = p2TotalMoves = totalMoves = 0;
				break;
			case 0:
				break;
			case 1:
				if (player == 1) {
					setNotification(WIN);
				}
				else if (player == 2) {
					setNotification(LOSE);
				}
				p1TotalMoves = p2TotalMoves = totalMoves = 0;
				break;
			default:
				break;
		}

    }
    
	/**
	 * Check board if winning combination exists
	 * @param player the player to check
	 */
	public int isWinner (int player)
	{
		int tmpCount = 0;
		switch (player)
		{
			case 1:
				tmpCount = p1TotalMoves;
				break;
			case 2:
				tmpCount = p2TotalMoves;
				break;
			default:
				tmpCount = 0;
				break;
		}
		if (tmpCount >= 3)	// only check if players have each placed at least 3 marks on the grid
		{
			int win;
			for (int i = 0; i < WINNERS.length; i++) 
			{
				win = 0;
				for (int j = 0; j < WINNERS[i].length; j++) 
				{
					if (board.getElement((WINNERS[i][j])) == player) 
					{
						win++;
						if (win == 3) 
						{
							return 1;
						}
					}
				}
			}
		}
		
		if (totalMoves == getBoardCapacity())
		{
			return -1;
		}
		
		return 0;
	}

	private int currentPlayer;					// current player
	private int p1TotalMoves;					// User's total move count
	private int p2TotalMoves;					// AI's total move count
	private int totalMoves;						// Total move count of each game
	private final int[][] WINNERS =				// winning combinations
	{
		{0,1,2}, {3,4,5}, {6,7,8},	// **horizontal wins**
		{0,3,6}, {1,4,7}, {2,5,8},  // **vertical wins**
		{0,4,8}, {2,4,6}			// **diagonal wins**
	};
	
	private final String TIE = "Cat's Game!";	// Game TIE message
	private final String LOSE = "You LOSE!";	// Game LOSE message
	private final String WIN = "You WIN!";		// Game WIN message
}
