package gameframe;

/**
 * Game class that functions as the Model (MVC) of the Grid-Based Game Framework.
 * @author Juan Carlos Escobar
 *
 */
public abstract class AbstractGame implements Game
{
	/**
	 * Create a new game.
	 * @param capacity the max capacity of the board.
	 */
	public AbstractGame(int capacity)
	{
		board = new ArrayListBoard(capacity);
	}
	
	/**
	 * Set the AI (difficulty swap)
	 * @param ai the AI
	 */
	protected void setAI(AI ai)
	{
		this.ai = ai;
	}
	
	/**
	 * Get the id at index.
	 * @param index the index.
	 * @return the id.
	 */
	public int getBoardElement(int index)
	{
		return board.getElement(index);
	}
	
	/**
	 * Check if the position at the specified index is available.
	 * @param index the position to check.
	 * @return boolean.
	 * @precondition index < size().
	 */
	public boolean isAvailable(int index)
	{
		return board.isAvailable(index);
	}
	
	/**
	 * Get the notification message to display.
	 * @return the notification message.
	 */
	public String getNotification()
	{
		return notification;
	}
	
	/**
	 * Set the notification message.
	 */
	public void setNotification(String notification)
	{
		this.notification = notification;
	}
	
	/**
	 * Get the board's maximum capacity.
	 * @return the capacity.
	 */
	public int getBoardCapacity()
	{
		return board.size();
	}
	
	/**
	 * Start a new game.
	 * @param capacity the capacity of the new board.
	 */
	public void restart(int capacity)
	{
		board = new ArrayListBoard(capacity);
	}
	
	/**
	 * String representation of the board elements.
	 * @return the board.
	 */
	public String asString()
	{
		return board.asString();
	}
	
	public abstract void userAction(int index);
	public abstract void aiAction();
	protected abstract void checkWinner(int id);
	
	protected Board board;
	protected AI ai;
	private String notification;
}
