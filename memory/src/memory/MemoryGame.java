package memory;

import java.util.ArrayList;

import gameframe.AbstractGame;

/**
 * Class that allows user to play a game of Tic Tac Toe
 * @author Juan Carlos Escobar
 *
 */
public class MemoryGame extends AbstractGame
{	
	public MemoryGame(int capacity)
	{
		super(capacity);				// create a new ArrayBoard with capacity
		setAI(new GeneratorAI(2));
		generatePattern(patternSize);
	}
	
	/**
	 * Generate a new pattern
	 */
	private void generatePattern(int length)
	{
		round = 0;
		winningPattern = new ArrayList<Integer>(length);
		playerPattern = new ArrayList<Integer>(length);
		
		for (int i = 0; i < length; i++)
		{
			winningPattern.add((ai.getMove()));
		}
		
		// DEBUG
		/*
		for (int i = 0; i < winningPattern.size()-1; i++)
		{
			System.out.print(winningPattern.get(i)+",");
		}
		System.out.print(winningPattern.get(patternSize-1));
		System.out.println();
		*/
	}
	
	/**
     * User action
     * @param index the index of the grid the user clicked on
     */
	public void userAction(int choice)
    {		
		if (choice >= 0 && choice < getBoardCapacity() && getBoardElement(choice) == 0)
		{
			board.setElement(choice, choice+1);
			playerPattern.add(choice+1);
			checkWinner(round);
		}
    }
	
	/**
	 * Remove all elements from the board
	 */
	public void clearBoard()
	{
		board.setElement(0, 0);
		board.setElement(1, 0);
		board.setElement(2, 0);
		board.setElement(3, 0);
	}
	
    /**
     * AI action
     */
	int round = 0;
    public void aiAction()
    {
    	if (round == winningPattern.size()) {
    		round = 1;
    	}
    	
    	for (int i = 0; i < round+1; i++)
    	{
    		board.setElement(winningPattern.get(i)-1,winningPattern.get(i));
    	}
    	round++;
    }
    
    /**
     * Check if user wins
     */
	protected void checkWinner(int round) {
		for (int i = 0; i < playerPattern.size(); i++) {
			if (playerPattern.get(i) == winningPattern.get(i)) {
				// Continue game...
			}
			else {
				setNotification(LOSE);
				generatePattern(patternSize);
			}
		}
		
		if (round == patternSize-1) {
			this.round = 0;
			setNotification(WIN);
			generatePattern(patternSize);
		}
	}

	/**
	 * Return the pattern generated
	 * @return the pattern
	 */
	public String getPattern() 
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("\n");
		for (int i = 0; i < winningPattern.size(); i++)
		{
			sb.append(" "+Integer.toString(i)+": ");
			switch( (winningPattern.get(i)) )
			{
				case 1:
					sb.append("Green\n");
					break;
				case 2:
					sb.append("Red\n");
					break;
				case 3:
					sb.append("Yellow\n");
					break;
				case 4:
					sb.append("Blue\n");
					break;
				default:
					break;
			}
		}
		return sb.toString();
	}

	private int patternSize = 10;					// Total move count of each game
	private final String LOSE = "You LOSE!";	// Game LOSE message
	private final String WIN = "You WIN!";		// Game WIN message
	
	private ArrayList<Integer> winningPattern;
	private ArrayList<Integer> playerPattern;
}
