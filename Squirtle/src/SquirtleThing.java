
public class SquirtleThing extends PokeThing {

	int squaresMoved = 0;
	
	/**
	 * SquirtleThing Constructor
	 * Creates a new <code>SquirtleThing</code> object.
	 * Associated graphics file will be squirtle.png
	 ****/
	public SquirtleThing()
	{
		super("Squirtle", "", 0);	
		setImageFileType(IMAGETYPE_PNG);
	}
	
	
	/**
	 * step method -- this method is called over and over
	 * <code>SquirtleThing</code> moves in a pattern and prints how far it has gone
	 */	
	public void step()
	{
		movementPattern();
		
		
		// increment by one with each step
		squaresMoved++;
		
		Gui g = getBoard().getGui();
		g.appendTextWindow("Squirtle has moved " + squaresMoved + " squares.");
	}
	
	
	/**
	 * movement in a repeating pattern
	 * <code>SquirtleThing</code> turns right if it is blocked or encounters a wall
	 */	
	public void movementPattern()
	{
		// Check the 'next' Location.  If there is a PokeThing or wall there, turn.
			// Addition: If there is a BulbasaurThing or a FlowerThing there, print a message.
				// If there is a wall there, print a message.
		
		boolean blocked;
		boolean stuck;
		boolean blockedByBulbasaur;
		boolean blockedByFlower;
			
		Location nextLoc = getDirection().getNextLocation(getLocation()); 
		blocked = getBoard().thingAt(nextLoc) instanceof PokeThing;
		stuck = !(nextLoc.isValid(getBoard()));
		
		
		blockedByBulbasaur = getBoard().thingAt(nextLoc) instanceof BulbasaurThing;
		blockedByFlower = getBoard().thingAt(nextLoc) instanceof FlowerThing;
		
		
		if (blocked || stuck)
		{
			setDirection(getDirection().right());
		}
		
	
		if (blockedByBulbasaur)
		{
			Gui g = getBoard().getGui();
			g.appendTextWindow("Squirtle said hello to Bulbasaur.");
		}
		
		if (blockedByFlower)
		{
			Gui g = getBoard().getGui();
			g.appendTextWindow("Squirtle smelled a flower.");
		}
		
		
		if (stuck)
		{
			Gui g = getBoard().getGui();
			g.appendTextWindow("Squirtle hit a wall.");
		}
				
		move();
	}
}
