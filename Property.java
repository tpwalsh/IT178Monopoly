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
		if (owner == null) {
			owner = p.buyFunction(price);
			this.owner = p;
		} else {
			this.owner.payOwner(p, rent);
		}
		if (this.name.equals("Chance") || this.name.equals("Community Chest")) {
			System.out.println("C or CC: "+ this.name);
			return"OK"; //chance(p);
		} else {
			return "OK";
		}
		// TODO The left and right sides don't work 100%. 
	}

	public String ownedBy() {
		return "test";
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
			p.buyFunction(15);
			return "pay poor tax of $15";

		}
		case 4: {
			if (p.getLocation() < 5) {
				p.move((5 - p.getLocation()));
			} else
				p.move((45 - p.getLocation()));
			return "Take a ride on the Reading Railroad!";
		}
		case 5: {
			if (p.getLocation() < 5) {
				p.move((5 - p.getLocation()));
			} else
				p.move((45 - p.getLocation()));
			return "Take a ride on the Reading Railroad!";
		}
		case 6: {
			if (p.getLocation() < 5) {
				p.move((5 - p.getLocation()));
			} else
				p.move((45 - p.getLocation()));
			return "Take a ride on the Reading Railroad!";
		}
		default:
			return "Error!";
		}
	}
}
