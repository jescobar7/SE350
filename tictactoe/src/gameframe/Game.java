package gameframe;

/**
 * A Game interface
 * @author Juan Carlos Escobar
 *
 */
public interface Game
{	
	/**
	 * Get the id at index.
	 * @param index the index.
	 * @return the id.
	 */
	int getBoardElement(int index);

	/**
	 * Check if the position at the specified index is available.
	 * @param index the position to check.
	 * @return boolean.
	 * @precondition index < size().
	 */
	boolean isAvailable(int index);
	
	/**
	 * Get the notification message to display.
	 * @return the notification message.
	 */
	String getNotification();
	
	/**
	 * Set the notification message.
	 */
	void setNotification(String notification);
	
	/**
	 * Get the board's maximum capacity.
	 * @return the capacity.
	 */
	int getBoardCapacity();
	
	/**
	 * Start a new game.
	 * @param capacity the capacity of the new board.
	 */
	void restart(int capacity);
	
	/**
	 * String representation of the board elements.
	 * @return the board.
	 */
	String asString();
	
	/**
	 * The User event handler for the mouse click converted into an index for the board
	 * @param index 
	 */
	void userAction(int index);
	
	/**
	 * The AI logic handler
	 */
	void aiAction();
}
