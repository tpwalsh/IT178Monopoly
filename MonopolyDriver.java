import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

public class MonopolyDriver {
	JFrame f;
	Property[] properties ;
	private void run() {
		properties = new Property[40];
		populateProperty();
		 f = new JFrame();
		
		f.setSize(800, 600);
		f.setLayout(null);
		f.add(new MyCanvas());
		f.setVisible(true);
		
		JButton b = new JButton("Roll");
		b.setBounds(130, 100, 100, 40);

	
	}
	
	private void populateProperty(){
		//properties[1].setname = "baltic Ave.";
		
	}

	public static void main(String[] args) {
		MonopolyDriver play = new MonopolyDriver();

		play.run();

	}
	
	private class MyCanvas extends Canvas{
		  public MyCanvas () {
		         setBackground (Color.GRAY);
		         setSize(800, 600);
		      }
		public void paint(Graphics g) 
		{
			//g.drawString("Hello",40,40);
			setBackground(Color.WHITE);
			for(int x=0;x<11;x++){
				g.drawRect(100+(50*x), 100, 50, 40);
				g.drawRect(100+(50*x), 450, 50, 40);
			}
			for(int x=0;x<9;x++){
				g.drawRect(100, 100+(40*x), 50, 40);
				g.drawRect(600, 100+(40*x), 50, 40);
			}
			
			

		}

	}
}