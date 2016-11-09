package IT178Monopoly;

import java.awt.Label;



public class MonopolyPlayer {
	private String Name;
	private int playerNum;
	private int Money = 1500;
	private int Position = 0;
	private boolean inJail = false;
	private int turns = 0;
	private Label player, bal;
	private boolean[] properties= new boolean[20]; 
	public static int activePlayer = 1;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	public int getPosition() {
		return Position;
	}
	public void setPosition(int position) {
		Position = position;
	}
	public boolean isInJail() {
		return inJail;
	}
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}
	public int getTurns() {
		return turns;
	}
	public void setTurns(int turns) {
		this.turns = turns;
	}
	public Label getPlayer() {
		return player;
	}
	public void setPlayer(Label player) {
		this.player = player;
	}
	public Label getBal() {
		return bal;
	}
	public void setBal(Label bal) {
		this.bal = bal;
	}
	public boolean[] getProperties() {
		return properties;
	}
	public void setProperties(boolean[] properties) {
		this.properties = properties;
	}
	public int getMoney() {
		return Money;
	}
	public static void setActivePlayer(int activePlayer) {
		MonopolyPlayer.activePlayer = activePlayer;
	}
	
	
	public MonopolyPlayer( String name, int num ) {
		this.Name = name;
		this.playerNum = num;
		for(int i = 0;i < properties.length; i++ )
		{
			this.properties[i] = false;
		}
	}
	//Make the move
	public void Move( int numSpaces, boolean doubles ) {
		if( (inJail && doubles) || !inJail ){
			inJail = false;
			Position += numSpaces;
			if( Position > 39 || Position == 0 )
				Money += 200;
		}
		else if( inJail )
			turns++;
		if( !inJail )
			turns = 0;
		if( turns == 2 ) {
			inJail = false;
			turns = 0;
			Money -= 50;
			
		}
		Position %= 40;
	}
	public static int getActivePlayer()
	{
		
		return activePlayer;
	}
	public void setMoney(int i)
	{
		Money = Money + i;
		
	}
	public boolean isOwned(int i) {
		
		return properties[i];
	}
}