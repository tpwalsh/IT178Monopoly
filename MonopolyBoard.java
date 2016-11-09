package IT178Monopoly;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
	
public class MonopolyBoard implements ActionListener, WindowListener {

		private static MonopolyPlayer p1 = new MonopolyPlayer("", 1);
		private static MonopolyPlayer p2 = new MonopolyPlayer("", 2);
		private static JFrame  a = new JFrame("Monopoly");
		private static JButton b1 = new JButton("Go ");
		private static JButton b2 = new JButton("Mediterranian Ave");
		private static JButton b3 = new JButton("Baltic Ave");
		private static JButton b4 = new JButton("Community Chest");
		private static JButton b5 = new JButton("Reading Railroad ");
		private static JButton b6 = new JButton("Oriental Ave");
		private static JButton b7 = new JButton("Vermont Ave");
		private static JButton b8 = new JButton("Connecticut Ave");
		private static JButton b9 = new JButton("Get out of Jail!" );
		private static JButton b10 = new JButton("St.Charles Place");
		private static JButton b11 = new JButton("States Ave");
		private static JButton b12 = new JButton("Virginia Ave");
		private static JButton b13 = new JButton("Chance");
		private static JButton b14 = new JButton ("St.James Ave");
		private static JButton b15 = new JButton ("Tennessee Ave");
		private static JButton b16 = new JButton ("New York Ave");
		private static JButton b17 = new JButton ("Chance");
		private static JButton b18 = new JButton ("Park Place");
		private static JButton b19 = new JButton ("Chance");
		private static JButton b20 = new JButton ("Boardwalk");
		private static JTextArea tf1 = new JTextArea("Player 1", 1, 13);
		private static JTextArea tf2 = new JTextArea("Player 2", 1, 13);
		
		private static JLabel comments = new JLabel ("Welcome to Monopoly!         " );
		private static JLabel comments1 = new JLabel ("This game is created by       " );
		private static JLabel comments2 = new JLabel ("Dr. Tonya Pierce    " ); 
		private static JLabel comments3 = new JLabel ("Please enter your names for player 1 and player 2 .");
		private static JLabel comments4 = new JLabel (" This is a two player game only!     ");
		private static JLabel comments5 = new JLabel ("");
	
	public static void main(String[] args){
		
		a.getContentPane().setBackground(Color.BLUE);
		
		a.setSize( 1000, 800);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LayoutManager GridLayout = null;
		a.setLayout(new GridLayout(8, 8));
		a.setResizable(false);
		JPanel buttons1 = new JPanel();
		b1.setPreferredSize(new Dimension(100, 60));
		buttons1.add(b1);
		b1.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		        	a.toFront();
		        	if(MonopolyPlayer.getActivePlayer()==1)
						p1.setMoney(200); 		
					else
						p2.setMoney(200); 
		        }
		    });
		
		b2.setPreferredSize(new Dimension(100,60));
		buttons1.add(b2);
		/*b2.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            a.toFront();

					if(MonopolyPlayer.getActivePlayer() == 1){
						if(p2.isOwned(2)){
							p2.setMoney(-100);
							p1.setMoney(100);
						}
						else if(!p1.isOwned(2)){
							System.out.println("Buying property for $200");
							p1.setMoney(-200);
						}
					}}
		        });*/
		b3.setPreferredSize(new Dimension(100,60));
		buttons1.add(b3);
		b3.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            a.toFront();
		        }
		    });
		b4.setPreferredSize(new Dimension(100,60));
		buttons1.add(b4);
		/*b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
	            a.toFront();
	        	}
	    	});*/
		
		
		b5.setPreferredSize(new Dimension(100,60));
		buttons1.add(b5);
			//b5.addActionListener((ActionListener) b5);
		b6.setPreferredSize(new Dimension(100,60));
		buttons1.add(b6);
			//b6.addActionListener((ActionListener) b1);
		b7.setPreferredSize(new Dimension(100,60));
		buttons1.add(b7);
			//b7.addActionListener((ActionListener) b1);
		b8.setPreferredSize(new Dimension(100,60));
		buttons1.add(b8);
			//b8.addActionListener((ActionListener) b1);
			
		a.add(buttons1);
		b9.setPreferredSize(new Dimension(100,60));
		
		b10.setPreferredSize(new Dimension(100,60));
		
		b11.setPreferredSize(new Dimension(100,60));
		
		b12.setPreferredSize(new Dimension(100,60));
		
			//b8.addActionListener((ActionListener) b1);	
		JPanel mainstuff = new JPanel();
		mainstuff.setPreferredSize(new Dimension(50,30));
		mainstuff.add(b9);	
		mainstuff.add(comments);
		mainstuff.add(comments1);
		mainstuff.add(comments2);
		mainstuff.add(comments4);
		mainstuff.add(comments5);
		mainstuff.add(b10);
		a.add(mainstuff);
		JPanel mainstuff2 = new JPanel();
		mainstuff2.add(b11);
		mainstuff2.add(comments3);
		mainstuff2.add(new Label ("  "));
		mainstuff2.add(tf1);
		mainstuff2.add(tf2);
		mainstuff2.add(new Label ("  "));
		mainstuff2.add(b12);
		a.add(mainstuff2);
			
		a.addWindowListener(null);
		
		a.setVisible(true);		
	}
		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub		
		}
		@Override
		public void windowClosing(WindowEvent arg0) {
			System.exit(0);	
		}
		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub		
		}
		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub		
		}
		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub		
		}
		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub		
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub	
		}

		
}