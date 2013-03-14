package gameframe;

/**
 * An AI interface for the Grid-Based Game Framework.
 * @author Juan Carlos Escobar
 *
 */
public interface AI
{
	/**
	 * The AI's unique id
	 * @return the id
	 */
	int getId();
	
	/**
	 * The AI's move
	 * @return the move
	 */
	int getMove();
}
