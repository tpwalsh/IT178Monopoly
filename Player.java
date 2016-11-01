package IT178Monopoly;
public class Player {
	private String name;
	private int location;
	private int cash;
	
	public Player(){
		cash = 300;
		name = "";
		location = 2;
	}
	public Player(String name){}
	public void payOwner(Player payer, int rent){
		this.cash +=rent;
		payer.cash -= rent;
	}
	public void buyFunction(int rent){
		this.cash -=rent;
		
	}
	public String getName(){
		return name;
	}
	public int getLocation(){
		return location;
	}
	public int getCash(){
		return 0;
	}
	public void roll(){
		
	}
}
