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
	public Player buyFunction(int price){
		if(this.cash> price){
			this.cash -=price;
			return this;
		}else
			return null;
		}
	public String getName(){
		return name;
	}
	public int getLocation(){
		return location;
	}
	public void move(int spaces){
		
		this.location += spaces;
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
