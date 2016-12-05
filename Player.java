package IT178Monopoly;
public class Player {
	private String name;
	private int location;
	private int cash;
	final int STARTING_CASH= 300;
	final int PASS_GO_CASH = 200;
	
	public Player(){
		cash = STARTING_CASH;
		name = "";
		location = 0;
	}
	/**
	 * 
	 * @param name Name of the player in the new Object
	 */
	public Player(String name){
		cash = STARTING_CASH;
		this.name = name;
		location = 0;
	}
	/**
	 * 
	 * @param payer the Player Object who is paying this player.
	 * @param rent
	 */
	public void payOwner(Player payer, int rent){
		this.cash +=rent;
		if(payer != null){
			payer.cash -= rent;
		}
	}
	/**
	 * 
	 * @param price price of the property to buy. 
	 * @return returns null if unable to afford the property. 
	 */
	public Player buyFunction(int price){
		if(this.cash> price){
			this.cash -=price;
			return this;
		}else
			return null;
		}
	/**
	 * 
	 * @return Name of the person
	 */
	
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return location of the player (0-39)
	 */
	public int getLocation(){
		return location;
	}
	/**
	 * 
	 * @param spaces Number of spaces to move. 
	 */
	public void move(int spaces){
		
		this.location += spaces;
		if (location > 39){
			location-=40;
			cash += PASS_GO_CASH;
		}
	}
	/**
	 * returns the current cash reserves of the person. 
	 * @return
	 */
	public int getCash(){
		return cash;
	}

}
