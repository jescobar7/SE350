package gameframe;

/**
 * A Board interface
 * @author Juan Carlos Escobar
 *
 */
public interface Board
{
	/**
	 * Add an element to the board.
	 * @param index the index position to add the element.
	 * @param element the element to add.
	 * @precondition element != null.
	 */
	void setElement(int index, int element);
	
	/**
	 * Get an element from the board.
	 * @param index index of the position to retrieve.
	 * @return the element.
	 * @precondition index < size().
	 */
	
	int getElement(int index);
	
	/**
	 * Return the board's maximum capacity.
	 * @return the capacity.
	 */
	int size();
	
	/**
	 * Check if the position at the specified index is available.
	 * @param index the position to check.
	 * @return boolean.
	 * @precondition index < size().
	 */
	boolean isAvailable(int index); 
	
	/**
	 * Return a string representation of the grid board.
	 * @return the board.
	 */
	String asString();
}
