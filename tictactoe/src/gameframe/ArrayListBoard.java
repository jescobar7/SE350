package gameframe;

import java.util.ArrayList;

/**
 * An Abstract Board class to store grid information.
 * @author Juan Carlos Escobar
 *
 */
public class ArrayListBoard implements Board
{
	/**
	 * Create a new Board of specified capacity.
	 * @param capacity maximum capacity of the board.
	 */
	public ArrayListBoard (int capacity) 
	{
		BOARD_CAPACITY = capacity;
		board = new ArrayList<Integer>(BOARD_CAPACITY);
		
		// populate board to allow modification at a specified index
		for (int i = 0; i < BOARD_CAPACITY; i++) 
		{
			board.add(0);
		}
	}
	
	/**
	 * Add an element to the board.
	 * @param index the index position to add the element.
	 * @param element the element to add.
	 * @precondition element != null.
	 */
	public void setElement(int index, int element) 
	{
		board.set(index, element);
	}
	
	/**
	 * Get an element from the board.
	 * @param index index of the position to retrieve.
	 * @return the element.
	 * @precondition index < size().
	 */
	
	public int getElement(int index) 
	{
		return board.get(index);
	}
	
	/**
	 * Return the board's maximum capacity.
	 * @return the capacity.
	 */
	public int size()
	{
		return BOARD_CAPACITY;
	}
	
	/**
	 * Check if the position at the specified index is available.
	 * @param index the position to check.
	 * @return boolean.
	 * @precondition index < size().
	 */
	public boolean isAvailable(int index) 
	{
		return board.get(index) == 0;
	}
	
	/**
	 * Return a string representation of the grid board.
	 * @return the board.
	 */
	public String asString()
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < board.size(); i++)
		{
			sb.append(board.get(i));
		}
		return sb.toString();
	}
	
	private ArrayList<Integer> board;	// the Board
	private int BOARD_CAPACITY;			// max capacity of the Board
}