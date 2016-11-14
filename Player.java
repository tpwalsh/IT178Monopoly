package IT178Monopoly;
public class Player {
	private String name;
	private int location;
	private int cash;
	
	public Player(){
		cash = 300;
		name = "";
		location = 0;
	}
	public Player(String name){
		cash = 300;
		this.name = name;
		location = 0;
	}
	public void payOwner(Player payer, int rent){
		this.cash +=rent;
		payer.cash -= rent;
	}
	public Player buyFunction(int rent){
		if(this.cash> rent)this.cash -=rent;
		return this;
		
	}
	public String getName(){
		return name;
	}
	public int getLocation(){
		return location;
	}
	public void move(int spaces){
		this.location +=1;
		//this.location += spaces;
		if (location > 39){
			location-=40;
			cash += 200;
		}
	}
	public int getCash(){
		return cash;
	}
	public void roll(){
		
	}
}
