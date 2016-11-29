package IT178Monopoly;

public class Property {
	private String name;
	private Player owner;
	private int price;
	private int rent;

	public Property() {
		owner = null;
		price = 0;
		name = "";
	}

	public Property(String name, int price, int rent) {
		owner = null;
		this.price = price;
		this.rent = rent;
		this.name = name;
	}

	public String landedOn(Player p) {
		System.out.println(this.name + " CP:" + p.getName() + "COH:" + p.getCash() + " OB" + this.ownedBy());
		if (!this.name.equals("Chance") && !this.name.equals("Community Chest") && !this.name.equals("Jail")
				&& !this.name.equals("Free Parking") && !this.name.equals("Go") && !this.name.equals("Income Tax")
				&& !this.name.equals("Luxury Tax") && !this.name.equals("Go To Jail")) {

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
			if (this.name.equals("Chance") || this.name.equals("Community Chest")) {

				return p.getName() + " " + this.chance(p); // chance(p);
			} else {
				if (this.name.equals("Luxury Tax") || this.name.equals("Income Tax")) {
					Player temp = new Player();
					temp.payOwner(p, this.rent);
					return " paid a Luxury Tax of $" + this.rent;
				} else {
					return "OK";
				}
			}
		}
		// TODO The left and right sides don't work 100%.
	}

	public String ownedBy() {
		if (owner != null) {
			return this.owner.getName();
		} else {
			return "unowned";
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private String chance(Player p) {
		int card = ((int) (Math.random() * 6) + 1);
		switch (card) {
		case 1: {
			p.move(40 - p.getLocation());
			return "Move directly to Go";
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
}
