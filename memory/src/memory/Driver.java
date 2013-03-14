package memory;

/**
 * Driver for Simon game
 * @author Juan Carlos Escobar
 *
 */
public class Driver 
{
	public static final int FRAME_WIDTH = 400;
	public static final int FRAME_HEIGHT = 400;
	
	public static void main(String[] args)
	{
		new MemoryJFrame(FRAME_WIDTH, FRAME_HEIGHT);
	}
}