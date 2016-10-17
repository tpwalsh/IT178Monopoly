
import javax.swing.JButton; 
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

//TODO  Create initial screen to load player names. destorying and recreating the jframe doesn't work. 

public class MonopolyDriver implements ActionListener  {
	JFrame f;
	Property[] properties ;
	int score1;
	MyCanvas board;
	/**
	 * 
	 */
	private MonopolyDriver(){
		f = new JFrame();
		
		score1 =0;
		properties = new Property[40];
		populateProperty();
		drawBoard();
	}
	
	private void run() {
		/*
		 * Main run program. In an event driven program like this,is it needed?
		 */

	}
	/**
	 * Draws the board initially. All other updates should be done from ActionListener.
	 */
	private void drawBoard(){
		f.setSize(800, 600);
		f.setLayout(null);
		board =new MyCanvas();
		f.add(board);
		JButton b = new JButton("Roll");
		b.setBounds(650, 100, 100, 40);
		b.addActionListener(this);
		f.add(b);
		f.setVisible(true);
		f.repaint();
	}
	
	private void populateProperty(){
		//TODO Figure out how to keep track of each property. 
		System.out.println(properties.length);
		for(int x=0; x<properties.length;x++){
			properties[x] = new Property();
			properties[x].setName("Property");  
		}
	}
/**
 * Button listener e is object that was accessed, cast it to whatever it needs to be (JButton)
 */
	public void actionPerformed(ActionEvent e) {
		//TODO This needs fleshing out.
		int roll = ((int)(Math.random()*6) + 1) + ((int)(Math.random()*6) + 1);
		System.out.println(roll);
		
		f.repaint();
	
		board.repaint();		
	}

	public static void main(String[] args) {
		MonopolyDriver play = new MonopolyDriver();
		play.run();
	}
	
	private class MyCanvas extends Canvas{
		static final long serialVersionUID = 999;
		  public MyCanvas () {
		         setBackground (Color.GRAY);
		         setSize(600, 600);
		      }
		public void paint(Graphics g) 
		{
			
			setBackground(Color.WHITE);
			for(int x=0;x<11;x++){
				g.drawRect(10+(50*x), 100, 50, 40);
				g.drawRect(10+(50*x), 460, 50, 40);
			}
			for(int x=0;x<9;x++){
				g.drawRect(10, 100+(40*x), 50, 40);
				g.drawRect(510, 100+(40*x), 50, 40);
			}
			//TODO This font statement is REALLY laggy
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			//TODO Change these to access the player objects.
			g.drawString("Player1 $"+score1, 20, 35);
			g.drawString("Player2 $"+score1, 20, 50);
			g.drawString("Player3 $"+score1, 20, 65);
			g.drawString("Player4 $"+score1, 20, 80);
			
		}
	}
}