package IT178Monopoly;

public class Player {
	private String name;
	private int location;
	private double cash;
	private int turn;
	private boolean inJail = false;
	
	
	public Player(String name, double cashBalance, int locale, int playerTurn)
	{
		this.cash = cash;
		this.location = location;
		this.name = name;
		this.turn = playerTurn;
		
	}
	public void payOwner(Player payer, int rent){
		
		this.cash +=rent;
		payer.cash -= rent;
	}
	public void buyFunction(){
		
	}
	public void buyFunction(int rent){
		this.cash -=rent;
		
	}
	
	public void moveSpaces(int roll) {
		
		if ( inJail == true ) { 
				turn++; 
		 }
		else if(location + roll > 40) {
			this.location = 40 - location - roll;
		}
		else {
			this.location = location + roll; 
		}
		
			}
		
	public int getLocation() {
		return location;
	}
	public String getName(){
		return name;
	}
	public int getCash(){
		return 0;
	}
	

	
	
	
			
			//cash balance zero, bust
	
			
	
	
}
