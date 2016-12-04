package IT178Monopoly;

import java.awt.Color;

public class Property {
	private String name;
	private Player owner;
	private int price;
	private int rent;
	private Color color;
	private boolean ownable;

	public Property() {
		owner = null;
		price = 0;
		name = "";
	}

	/**
	 * 
	 * @param name
	 *            Name of the property
	 * @param price
	 *            purchase price of the property
	 * @param rent
	 *            rent to be chaged when another player lands on it.
	 */

	public Property(String name, int price, int rent, boolean ownable) {
		owner = null;
		this.price = price;
		this.rent = rent;
		this.name = name;
		this.ownable = ownable;

	}

	/**
	 * Logic for landing on a property
	 * @param p
	 *            Player that landed on the property
	 * @return returns the string to display that is the result of landing on
	 *         that property. (all actual actions are handled internally)
	 */
	public String landedOn(Player p) {
		System.out.println(this.name + " CP:" + p.getName() + "COH:" + p.getCash() + " OB" + this.ownedBy());
		if (this.isOwnable()) {

			if (owner != null) {
				if (p.getName().equals(this.owner.getName())) {
					return p.getName() + " already owns " + this.getName();
				} else {
					this.owner.payOwner(p, rent);
					return p.getName() + " paid " + this.owner.getName() + " $" + this.rent + " in rent for "
							+ this.getName();
				}
			} else {
				System.out.println("potential Purchase:" + this.price);
				this.owner = p.buyFunction(this.price);

				if (owner == null) {
					return p.getName() + " was unable to purchase " + this.getName();
				} else {
					return p.getName() + " purchased " + this.getName();
				}
			}

		} else {
			if (this.name.equals("Chance") || this.name.equals("Community Chest"))
				return p.getName() + " " + this.chance(p); // chance(p);
			else if (this.name.equals("Luxury Tax") || this.name.equals("Income Tax")) {
				Player temp = new Player();
				temp.payOwner(p, this.rent);
				return p.getName() + " paid a Luxury Tax of $" + this.rent;
			} else if (this.name.equals("Go"))
				return p.getName() +" landed on Go, and collected $200";
			else if (this.name.contains("Jail"))
				return p.getName()+ " is just visiting Jail.";
			else if( this.name.equals("Free Parking"))
				return p.getName()+ " found free parking!";
			else
				return "OK";
		}

	}

	/**
	 * 
	 * @return getter for owner.
	 */
	public String ownedBy() {
		if (owner != null) {
			return this.owner.getName();
		} else {
			return "unowned";
		}
	}

	/**
	 * setter for the name of the property. probably not needed.
	 * 
	 * @param name
	 *            name of the property.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for the property name
	 * 
	 * @return name of the property.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param p
	 *            Player Object of who landed on the property.
	 * @return display string of what happened.
	 */
	private String chance(Player p) {
		int card = ((int) (Math.random() * 6) + 1);
		switch (card) {
		case 1: {
			p.move(40 - p.getLocation());
			return "moved directly to Go";
		}
		case 2: {
			p.buyFunction(-100);
			return "bank error in your favor. Collect $100";

		}
		case 3: {
			Player temp = new Player();
			temp.payOwner(p, this.rent);
			return "paid a poor tax of $15";

		}
		case 4: {
			if (p.getLocation() < 5) {
				p.move((5 - p.getLocation()));
			} else
				p.move((45 - p.getLocation()));
			return "Took a ride on the Reading Railroad!";
		}
		case 5: {
			p.move((40 - p.getLocation()));
			return "Advanced to GO! ";
		}
		case 6: {
			if (p.getLocation() < 2) {
				p.move((37 + p.getLocation()));
			} else
				p.move(-3);
			return "Go back 3 spaces!";
		}
		default:
			return "Error!";
		}
	}
/**
 * changes the owner to null for when a player is removed from the game. 
 */
	public void removeOwner() {
		this.owner = null;
	}
/**
 * 
 * @return true if the property can be owned by a player. 
 */
	public boolean isOwnable() {
		return this.ownable;
	}
}
