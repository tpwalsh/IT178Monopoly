
public class Property {
	private String name;
	private Player owner;
	private int price;
	private int rent;
	public Property(){
		owner = null;
		price = 0;
		name = "";
	}
	public void landedOn(Player p){
		if(owner ==  null){
			p.buyFunction();
			this.owner = p;
		}else{
			this.owner.payOwner(p, rent);
		} 
		//TODO Stuff
	}
	public String ownedBy(){
		return "test";
	}
	public void setName(String name){
		this.name = name;
	}
 
}
