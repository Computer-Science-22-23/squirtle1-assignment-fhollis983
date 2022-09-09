public class SquirtleBoard extends Board {

	
	public SquirtleBoard() 
	{
		// Call the Board constructor to make an 8x4 Board
	 	super(8, 6);
	 	newGame(false);
	 	setTitle("PokemonCode Assignment 1");
	 	setInitialText("What will Squirtle do with Bulbasaur's flowers?");
	}
	
	
	@Override
	public void newGame(boolean repaint)
	{
		super.newGame(repaint);
		
		// Create a SquirtleThing at 3, 0
	 	SquirtleThing squirtle = new SquirtleThing();
	 	squirtle.setLocation(3, 0);
	 	add(squirtle);
	 	
	 	// Create a BulbasaurThing at 0, 0
	 	BulbasaurThing bulbasaur = new BulbasaurThing();
	 	bulbasaur.setLocation(0, 0);
	 	add(bulbasaur); 	
	}
	
} 
