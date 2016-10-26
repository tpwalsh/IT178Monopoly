
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;;

//TODO  Create initial screen to load player names. destorying and recreating the jframe doesn't work. 

public class MonopolyDriver implements ActionListener {
	JFrame f;
	Property[] properties;
	int score1, playersTurn;
	MyCanvas board;
	JButton b;
	ArrayList<Player> players = new ArrayList<Player>();

	private static JLabel[] comments = new JLabel[5];
	private static JTextArea[] playerNames = new JTextArea[4];
	Font labelFont;

	/**
	 * 
	 */
	private MonopolyDriver() {

		f = new JFrame();
		f.setSize(800, 600);
		f.setLayout(null);
		getPlayers();
		score1 = 0;
		properties = new Property[40];
		populateProperty();

		// drawBoard();
	}

	private void run() {
		/*
		 * Main run program. In an event driven program like this,is it needed?
		 */

	}

	/**
	 * Draws the board initially. All other updates should be done from
	 * ActionListener.
	 */
	private void drawBoard() {

		board = new MyCanvas();
		f.add(board);
		b = new JButton("Roll");
		b.setBounds(650, 100, 100, 40);
		b.addActionListener(this);
		f.add(b);
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
		// TODO Figure out how to keep track of each property.
		System.out.println(properties.length);
		properties[0] = new Property("Go", 60);
		properties[1] = new Property("Mediteranitan Ave.", 60);
		properties[2] = new Property("Community Chest", 0);
		properties[3] = new Property("Baltic Ave.", 200);
		properties[4] = new Property("Income Tax", 0);
		properties[5] = new Property("Reading Railroad", 100);
		properties[6] = new Property("Oriental Ave.", 100);
		properties[7] = new Property("Chance", 0);
		properties[8] = new Property("Vermont Ave.", 100);
		properties[9] = new Property("Connecticut Ave.", 120);
		properties[10] = new Property("Jail", 0);
		properties[11] = new Property("St. Charles Place", 140);
		properties[12] = new Property("Electric Company", 150);
		properties[13] = new Property("States Ave.", 140);
		properties[14] = new Property("Virginia Ave.", 160);
		properties[15] = new Property("Pennsylvania Railroad", 200);
		properties[16] = new Property("St. James Place", 180);
		properties[17] = new Property("Community Chest", 0);
		properties[18] = new Property("Tennessee Ave.", 180);
		properties[19] = new Property("New York Ave.", 200);
		properties[20] = new Property("Free Parking", 0);
		properties[21] = new Property("Kentucky Ave.", 220);
		properties[22] = new Property("Chance", 0);
		properties[23] = new Property("Indiana Ave.", 220);
		properties[24] = new Property("Illinois Ave.", 240);
		properties[25] = new Property("B & O Railroad", 200);
		properties[26] = new Property("Atlantic Ave.", 260);
		properties[27] = new Property("Ventnor Ave.", 260);
		properties[28] = new Property("Water Works", 150);
		properties[29] = new Property("Marvin Gardens", 280);
		properties[30] = new Property("Go To Jail", 0);
		properties[31] = new Property("Pacific Ave.", 300);
		properties[32] = new Property("North Carolina Ave.", 300);
		properties[33] = new Property("Community Chest", 0);
		properties[34] = new Property("Pennsylvania Ave.", 320);
		properties[35] = new Property("Short Line", 200);
		properties[36] = new Property("Chance", 0);
		properties[37] = new Property("Park Place", 350);
		properties[38] = new Property("Luxury Tax", 100);
		properties[39] = new Property("Boardwalk", 400);
	}

	/**
	 * Button listener e is object that was accessed, cast it to whatever it
	 * needs to be (JButton)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO This needs fleshing out.+

		JButton objectPressed = (JButton) e.getSource();
		// If in the intro screen
		if (objectPressed.getText() == "Done") {

			f.remove(b);
			for (int x = 0; x < playerNames.length; x++) {
				if (playerNames[x].getText() != null) {
					System.out.println(playerNames[x].getText());
					// TODO create players
					// players.add(new Player(playerNames[x].getText()));
				}
				f.remove(playerNames[x]);
			}
			for (int x = 0; x < comments.length; x++) {
				f.remove(comments[x]);
			}
			board = new MyCanvas();
			f.add(board);
			drawBoard();
		}
		// if in the main screen
		if (objectPressed.getText() == "Roll") {
			int roll = ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1);
			// players.get(playersTurn).roll(roll);
			// players.get(playersTurn).moveSpaces(roll);
//			properties[players.get(playersTurn).getLocation()].landedOn(players.get(playersTurn));

			if (playersTurn == 3) {
				playersTurn = 0;
			} else {
				playersTurn++;
			}
			System.out.println(roll);
		}
		f.repaint();

	}

	public static void main(String[] args) {
		MonopolyDriver play = new MonopolyDriver();
		play.run();

	}

	private class MyCanvas extends Canvas {
		static final long serialVersionUID = 999;

		public MyCanvas() {
			setBackground(Color.GRAY);
			setSize(600, 600);
		}

		public void paint(Graphics g) {

			setBackground(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			for (int x = 0; x < 11; x++) {
				g.drawRect(10 + (50 * x), 100, 50, 40);
				g.drawRect(10 + (50 * x), 460, 50, 40);
			g.drawString("test", 20+(x*50),135);
			g.drawString("test", 20+(x*50),495);
			}
			for (int x = 0; x < 8; x++) {
				
				g.drawRect(0, 140 + (40 * x), 50, 40);
				g.drawRect(510, 140 + (40 * x), 50, 40);
				g.drawString("test"+x, 10, 180+(x*40));
				g.drawString("test"+x, 510,180+(x*40));
			}
			// TODO This font statement is REALLY laggy
			
			// TODO Change these to access the player objects.
			for (int x = 0; x < players.size(); x++) {
				g.drawString(players.get(x).getName() + " $" + players.get(x).getCash(), 20, 35 + (x * 15));
			}
		}
	}
}