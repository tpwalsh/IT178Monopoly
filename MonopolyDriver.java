package IT178Monopoly;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class MonopolyDriver implements ActionListener {
	Graphics g;
	JFrame f;
	Property[] properties;
	int score1, playersTurn;
	MyCanvas board;
	JButton b, c1, b1, b2, b3, b4, b5, b6;
	Property prop = new Property();
	ArrayList<Player> players = new ArrayList<Player>();
	JButton[] buttons = new JButton[6];
	String result;
	private static JLabel[] comments = new JLabel[5];
	private static JTextArea[] playerNames = new JTextArea[4];
	Font labelFont;

	private MonopolyDriver() {

		f = new JFrame();
		f.setSize(1024, 900);
		f.setLayout(null);
		getPlayers();
		score1 = 0;
		result = " ";
		properties = new Property[40];
		populateProperty();
		board = new MyCanvas();
	}

	/**
	 * Draws the board initially. All other updates should be done from
	 * ActionListener.
	 */
	private void drawBoard() {

		f.add(board);
		b = new JButton("Roll");
//		c1 = new JButton("Roll");
		b1 = new JButton("Chance #1 ?");
		b2 = new JButton("Chance #2 ?");
		b3 = new JButton("Chance #3 ?");
		b4 = new JButton("Community Chest");

		b.setBounds(900, 100, 100, 40);
		b1.setBounds(900, 150, 100, 40);
		b2.setBounds(900, 200, 100, 40);
		b3.setBounds(900, 250, 100, 40);
		b4.setBounds(900, 300, 200, 40);

		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		f.add(b);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);

		f.validate();
		f.setVisible(true);
		f.repaint();

	}
	

	private void getPlayers() {
		for (int x = 0; x < playerNames.length; x++) {
			playerNames[x] = new JTextArea();
			f.add(playerNames[x]);
		}

		playerNames[0].setBounds(150, 100, 100, 20);
		playerNames[1].setBounds(150, 200, 100, 20);
		playerNames[2].setBounds(150, 300, 100, 20);
		playerNames[3].setBounds(150, 400, 100, 20);
		comments[0] = new JLabel("Welcome to Monopoly!");
		comments[1] = new JLabel("Name of Player 1");
		comments[2] = new JLabel("Name of Player 2");
		comments[3] = new JLabel("Name of Player 3");
		comments[4] = new JLabel("Name of Player 4");
		labelFont = comments[0].getFont();
		comments[0].setFont(new Font(labelFont.getName(), Font.PLAIN, 22));
		comments[0].setBounds(50, 50, 300, 30);
		comments[1].setBounds(60, 80, 150, 30);
		comments[2].setBounds(60, 150, 150, 30);
		comments[3].setBounds(60, 250, 150, 30);
		comments[4].setBounds(60, 380, 150, 30);
		f.add(comments[0]);
		f.add(comments[1]);
		f.add(comments[2]);
		f.add(comments[3]);
		f.add(comments[4]);

		b = new JButton("Done");
		b.setBounds(650, 100, 100, 40);
		b.addActionListener(this);
		f.add(b);
		f.validate();
		f.setVisible(true);
		f.repaint();

	}

	private void populateProperty() {

		properties[0] = new Property("Go", 60, 2,false);
		properties[1] = new Property("Mediteranitan Ave.", 60, 4,true);
		properties[2] = new Property("Community Chest", 0, 0,false);
		properties[3] = new Property("Baltic Ave.", 200, 6,true);
		properties[4] = new Property("Income Tax", 0, 30,false);
		properties[5] = new Property("Reading Railroad", 100, 50,true);
		properties[6] = new Property("Oriental Ave.", 100, 6,true);
		properties[7] = new Property("Chance 1", 0, 0,false);
		properties[8] = new Property("Vermont Ave.", 100, 6,true);
		properties[9] = new Property("Connecticut Ave.", 120, 8,true);
		properties[10] = new Property("Jail", 0, 0,false);
		properties[11] = new Property("St. Charles Place", 140, 10,true);
		properties[12] = new Property("Electric Company", 150, 20,true);
		properties[13] = new Property("States Ave.", 140, 10,true);
		properties[14] = new Property("Virginia Ave.", 160, 12,true);
		properties[15] = new Property("Pennsylvania Railroad", 200, 50,true);
		properties[16] = new Property("St. James Place", 180, 14,true);
		properties[17] = new Property("Community Chest", 0, 0,false);
		properties[18] = new Property("Tennessee Ave.", 180, 14,true);
		properties[19] = new Property("New York Ave.", 200, 16,true);
		properties[20] = new Property("Free Parking", 0, 0,false);
		properties[21] = new Property("Kentucky Ave.", 220, 18,true);
		properties[22] = new Property("Chance 2", 0, 0,false);
		properties[23] = new Property("Indiana Ave.", 220, 18,true);
		properties[24] = new Property("Illinois Ave.", 240, 20,true);
		properties[25] = new Property("B & O Railroad", 200, 50,true);
		properties[26] = new Property("Atlantic Ave.", 260, 22,true);
		properties[27] = new Property("Ventnor Ave.", 260, 22,true);
		properties[28] = new Property("Water Works", 150, 30,true);
		properties[29] = new Property("Marvin Gardens", 280, 24,true);
		properties[30] = new Property("Go To Jail", 0, 0,false);
		properties[31] = new Property("Pacific Ave.", 300, 26,true);
		properties[32] = new Property("North Carolina Ave.", 300, 26,true);
		properties[33] = new Property("Community Chest", 0, 0,false);
		properties[34] = new Property("Pennsylvania Ave.", 320, 28,true);
		properties[35] = new Property("Short Line", 200, 50,true);
		properties[36] = new Property("Chance 3", 0, 0,false);
		properties[37] = new Property("Park Place", 350, 35,true);
		properties[38] = new Property("Luxury Tax", 0, 75,false);
		properties[39] = new Property("Boardwalk", 400, 50,true);

	}

	/**
	 * Button listener e is object that was accessed, cast it to whatever it
	 * needs to be (JButton)
	 */
	public void actionPerformed(ActionEvent e) {

		JButton objectPressed = (JButton) e.getSource();
		// If in the intro screen
		if (objectPressed.getText() == "Done") {

			f.remove(b);
			for (int x = 0; x < playerNames.length; x++) {
				if (!playerNames[x].getText().equals("")) {
					players.add(new Player(playerNames[x].getText()));
				}
				System.out.println("location:" + players.get(0).getName());
				f.remove(playerNames[x]);
			}
			for (int x = 0; x < comments.length; x++) {
				f.remove(comments[x]);
			}
			drawBoard();
		}
		// if in the main screen
		if (objectPressed.getText() == "Roll") {
			int roll = ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1);

			players.get(playersTurn).move(roll);
			result = properties[players.get(playersTurn).getLocation()].landedOn(players.get(playersTurn));
			if (players.get(playersTurn).getCash() < 0) { // remove player if
															// broke
				result += "   " + players.get(playersTurn).getName() + " has gone broke!";
				for (Property property : properties) { //remove ownership of all properties owned by broke player
					if (property.ownedBy() == players.get(playersTurn).getName()) {
						property.removeOwner();
					}
				}
				players.remove(players.get(playersTurn));
			}
			if (playersTurn >= players.size() - 1) { // on last player's turn
														// revert back to player
														// 1
				playersTurn = 0;
			} else {
				playersTurn++;
			}

		}
		// Calls chance method when buttons are pressed.
		if (objectPressed.getText() == "Chance #1 ?"|| objectPressed.getText() == "Chance #2 ?"|| objectPressed.getText() == "Chance #3 ?"||
				objectPressed.getText() == "Community Chests") {
			prop.chance(players.get(playersTurn));
		}
		f.revalidate();
		board.revalidate();
		board.repaint();
	}
	
	private void run() {
		/*
		 * Main run program. In an event driven program like this, it's not necessarily needed.
		 */

	}

	public static void main(String[] args) {
		MonopolyDriver play = new MonopolyDriver();
		play.run();

	}

	// board class.
	private class MyCanvas extends Canvas {
		static final long serialVersionUID = 999;

		public MyCanvas() {
			setBackground(Color.GRAY);
			setSize(900, 900);
		}

		public void paint(Graphics g) {
			
			Color newGreen = new Color(204,255,229);
			setBackground(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
			for (int x = 0; x < 11; x++) {
				g.setColor(newGreen);
				g.fillRect(10 + (80 * x), 20, 80, 75);
				g.fillRect(10 + (80 * x), 725, 80, 75);
				g.setColor(Color.BLACK);
				g.drawRect(10 + (80 * x), 20, 80, 75); // left side			
				g.drawRect(10 + (80 * x), 725, 80, 75); // right side
				// Draw spaces 20-30
				if (properties[x + 20].getName().length() < 10) {
					g.drawString(properties[x + 20].getName(), 11 + (x * 80), 45);
				} else {
					g.drawString(
							properties[x + 20].getName().substring(0, properties[x + 20].getName().lastIndexOf(" ")),
							11 + (x * 80), 45);
					g.drawString(
							properties[x + 20].getName().substring(properties[x + 20].getName().lastIndexOf(" ") + 1),
							11 + (x * 80), 57);
				}
				if (properties[x+20].ownedBy() != "unowned")
				g.drawString(properties[x + 20].ownedBy(), 11 + (x * 80), 93);
				// Draw first 10 spaces
				if (properties[10 - x].getName().length() < 10) {
					g.drawString(properties[10 - x].getName(), 11 + (x * 80), 747);
				} else {
					g.drawString(
							properties[10 - x].getName().substring(0, properties[10 - x].getName().lastIndexOf(" ")),
							11 + (x * 80), 747);
					g.drawString(
							properties[10 - x].getName().substring(properties[10 - x].getName().lastIndexOf(" ") + 1),
							11 + (x * 80), 767);
				}
				if (properties[10 - x].ownedBy() != "unowned")
					g.drawString(properties[10 - x].ownedBy(), 11 + (x * 80), 798);

			}
			for (int x = 0; x < 9; x++) {
				g.setColor(newGreen);
				g.fillRect(10, 95 + (70 * x), 80, 70);
				g.fillRect(810, 95 + (70 * x), 80, 70);
				g.setColor(Color.BLACK);
				g.drawRect(10, 95 + (70 * x), 80, 70); // top row
				g.drawRect(810, 95 + (70 * x), 80, 70); // bottom row
				// Draw spaces 11-19
				if (properties[19 - x].getName().length() < 10)
					g.drawString(properties[19 - x].getName(), 10, 120 + (x * 70));
				else {
					g.drawString(
							properties[19 - x].getName().substring(0, properties[19 - x].getName().lastIndexOf(' ')),
							10, 120 + (x * 70));
					g.drawString(
							properties[19 - x].getName().substring(properties[19 - x].getName().lastIndexOf(' ') + 1),
							10, 132 + (x * 70));
				}
				if (properties[19 - x].ownedBy() != "unowned")
					g.drawString(properties[19 - x].ownedBy(), 10, 163 + (x * 70));

				// Draw spaces 31-38
				if (properties[31 + x].getName().length() < 10)
					g.drawString(properties[31 + x].getName(), 810, 120 + (x * 70));

				else {
					g.drawString(
							properties[31 + x].getName().substring(0, properties[31 + x].getName().lastIndexOf(' ')),
							810, 120 + (x * 70));
					g.drawString(
							properties[31 + x].getName().substring(properties[31 + x].getName().lastIndexOf(' ') + 1),
							810, 132 + (x * 70));
				}
				if (properties[31 + x].ownedBy() != "unowned")
					g.drawString(properties[31 + x].ownedBy(), 810, 163 + (x * 70));

			}
			
			// Display the location of the players
			g.setColor(Color.RED);
			for (int x = 0; x < players.size(); x++) {
				g.drawString((x + 1) + ": " + players.get(x).getName() + " $" + players.get(x).getCash(), 200,
						350 + (x * 15));
				if (players.get(x).getLocation() < 11)
					g.drawString("" + (x + 1), 810 - (players.get(x).getLocation() * 80) + (15 * x), 780); // bottom
																											// row
				else if (players.get(x).getLocation() < 20)
					g.drawString("" + (x + 1), 10 + (15 * x), 780 - ((players.get(x).getLocation() - 10) * 70)); // left
																													// side
				else if (players.get(x).getLocation() < 30)
					g.drawString("" + (x + 1), ((players.get(x).getLocation() - 20) * 80) + 10 + (15 * x), 80);// top
																												// row
				else
					g.drawString("" + (x + 1), 820 + (15 * x), ((players.get(x).getLocation() - 30) * 70) + 80);
			}

			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			if (!result.equals("OK")) {
				g.drawString(result, 100, 200);
			}
			System.out
					.println(players.get(playersTurn).getName() + "location" + players.get(playersTurn).getLocation());
			g.setColor(Color.BLACK);

		}
	}
}