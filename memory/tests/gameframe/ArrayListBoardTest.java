package gameframe;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * JUnit Test for ArrayBoard class
 * @author Juan Carlos Escobar
 *
 */
public class ArrayListBoardTest {

	/**
	 * Test the size() method when creating a board of capacity 0
	 */
	@Test
	public void sizeZeroTest() 
	{
		board = new ArrayListBoard(0);
		
		assertTrue(board.size() == 0);
		assertFalse(board.size() < 0);
		assertFalse(board.size() >= 1);
	}
	
	/**
	 * Test the size() method when creating a board of capacity 1000
	 */
	@Test
	public void sizeHundredTest() 
	{
		board = new ArrayListBoard(1000);
		
		assertTrue(board.size() == 1000);
		assertTrue(board.size() >= 0);
		assertTrue(board.size() < 1001);
		assertFalse(board.size() < 0);
	}
	
	/**
	 * Test the size() method when creating a board of a random capacity
	 */
	@Test
	public void sizeRandomTest() 
	{
		final int randomSize = 1000;
		int random = rn.nextInt(randomSize);
		for (int i = 0; i < randomSize; i++)
		{
			board = new ArrayListBoard(random);
			
			assertTrue(board.size() == random);
			assertTrue(board.size() >= 0);
			assertTrue(board.size() < 10000);
			assertFalse(board.size() < 0);
		}
	}
	
	/**
	 * Test the setElement() method with random set indices
	 */
	@Test
	public void setElementRandomTest() 
	{
		final int boardSize = 100;
		board = new ArrayListBoard(boardSize);
		int randomIndex = rn.nextInt(boardSize);
		
		for (int i = 0; i < 10000; i++)
		{
			board.setElement(randomIndex, 1);
			assertTrue(board.getElement(randomIndex) == 1);
		}
	}
	
	/**
	 * Test the getElement() method
	 */
	@Test
	public void getElementTest() 
	{
		final int boardSize = 100;
		board = new ArrayListBoard(boardSize);
		
		for (int i = 0; i < boardSize; i++)
		{
			board.setElement(i, i);
		}
		
		for (int i = 0; i < boardSize; i++)
		{
			int randomIndex = rn.nextInt(boardSize);
			assertTrue(board.getElement(randomIndex) == randomIndex);
		}
	}
	
	/**
	 * Test the isAvailable() method
	 */
	@Test
	public void isAvailableTest()
	{
		final int boardSize = 10;
		board = new ArrayListBoard(boardSize);
		
		for (int i = 0; i < boardSize; i += 2)
		{
			board.setElement(i, 1);
		}
		
		for (int i = 0; i < boardSize; i++)
		{
			if (i % 2 == 0) {
				assertTrue(board.isAvailable(i) == false);
			}
			if (i % 2 == 1)
			{
				assertFalse(board.isAvailable(i) == false);
			}
		}
	}
	
	/**
	 * Test the asString() method
	 */
	@Test
	public void asStringTest()
	{
		final int boardSize = 21;
		final String output = "01234567891011121314151617181920";
		board = new ArrayListBoard(boardSize);
		
		for (int i = 0; i < boardSize; i++)
		{
			board.setElement(i, i);
		}
		
		assertTrue(board.asString().equals(output));
	}
	
	/**
	 * Test the asString() method
	 */
	@Test
	public void asStringRandomTest()
	{
		final int boardSize = 21;
		String output;
		board = new ArrayListBoard(boardSize);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < boardSize; i++)
		{
			int tmp = rn.nextInt(boardSize);
			sb.append(tmp);
			board.setElement(i, tmp);
		}
		
		output = sb.toString();
		assertTrue(board.asString().equals(output));
	}
	
	private ArrayListBoard board;
	private Random rn = new Random();
}
