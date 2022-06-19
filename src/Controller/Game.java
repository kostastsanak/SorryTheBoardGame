package Controller;
import View.*;

import java.util.Random;

import Model.*;

/**
 * @author kosta
 * The Class Game of the Project Controller gets all the information from the View and Model packages.
 */
public class Game {
	Random r = new Random();
	public static int PlayersTurn=0;
	public static int deck=44;
	public static int moved=0;
	public static String lastID="";
	public static boolean Card2= false;
	public static boolean played =true;
	Handler handler = new Handler();
	Deck d = new Deck();
	/**
	 * 
	 * <Postcondition> : Sets the players and the cards for the game to start.
	 * 
	 */
	public  Game(){
		
		//red players
		int n=0;
		do {
			n = r.nextInt(3); 
		}while(n==0);
		d.ShuffleDeck();
		d.Card();
		PlayersTurn = n;
		PawnRed1 redp1= new PawnRed1(ID.PlayerRed1,handler);
		handler.addObject(redp1);
		PawnRed2 redp2= new PawnRed2(ID.PlayerRed2,handler);
		handler.addObject(redp2);
        //yellow players
		PawnYel1 yelp1 = new PawnYel1(ID.PlayerYel1,handler);
		handler.addObject(yelp1);
		PawnYel2 yelp2 = new PawnYel2(ID.PlayerYel2,handler);
		handler.addObject(yelp2);
		render();
		
		
		
		
		
		
	}
	

	
	/**
	 * Starts the game, by calling the constructor Game()
	 */
	public static void main(String[] args) {
		new Game();
	}
	
	
	/**
	 * <Postcondition> : Brings up all the Graphic parts.
	 */
	public void render() {
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {

	            public void run() {

	                Window view = new Window();
	                view.setVisible(true);
	                view.initComponents();
	                handler.render();
	    			Info i= new Info();
	    			i.render();
	    			new Fold(handler);
	    			ShuffleButton s = new ShuffleButton();
	    			s.render();
	    			
	                new Window();
	            }
	        });
	}


}
