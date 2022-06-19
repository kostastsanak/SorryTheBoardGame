package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.Game;
import Model.Card;
import Model.Deck;
import Model.Handler;





public class Fold {
	Window w = new Window();
	Deck d = new Deck();
	Handler handler ;
	boolean clickable = false;
	/**
	 * Graphics of the Fold button
	 */
	public Fold (Handler handler) {
		this.handler = handler;
		render();
	}
	public void render(){
        JLabel FoldLabel = new JLabel("Fold Button");
        
        
        JButton FoldB = new JButton();
		FoldB.setBounds(800, 393, 200, 75); 
		FoldB.setBackground(Color.RED);
		FoldB.add(FoldLabel);
    	Window.basic_panel.add(FoldB);
    	
    	ButtonPushed pushed = new ButtonPushed();
    	FoldB.addActionListener(pushed);
    	
    	
    	FoldB.setVisible(true);
	}
	
    /**
     * What happens when the Fold button is pushed
     *
     */
    private class ButtonPushed implements ActionListener{
    	/**
         * If the Button is pushed it changes to the next Player playing and draws the next Card of the Deck
         *
         */
		public void actionPerformed(ActionEvent event) {
			boolean Movable = new Controller.Movable(handler).isMovable();
			if (Controller.Move.TheEnd == false  && Movable == false){			
				if (Game.Card2 == true) {
					if(Game.PlayersTurn == 1) {Game.PlayersTurn =2; 
					}else {Game.PlayersTurn = 1;}
				}
				if (Controller.Move.TheEnd == false)
					new Card(d.Card());
				Game.deck --;
				if (Game.deck == 0) {
					d.ShuffleDeck();
					Game.deck = 44;
				}
				if(Game.PlayersTurn == 1) {Game.PlayersTurn =2; 
				}else {Game.PlayersTurn = 1;}
				Info i= new Info();
				i.render();
				w.DrawCard();
				if (Card.num == 2) {
					Game.Card2 = true;
				}else {
					Game.Card2 = false;
				}
			
			
			}
			
			
		}
	}
    
}
