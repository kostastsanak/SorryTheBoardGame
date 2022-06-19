package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import Controller.Game;


public class Info {
	JTextArea  infobox = new JTextArea();
	
	/**
	 * Graphics of the Info Box
	 */
	public void render(){
	    infobox.setBounds(800, 550, 200, 150);
	    infobox.setBackground(Color.white);
	    infobox.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
	    infobox.setOpaque(true);
	    infobox.setFont(new Font(""+Game.deck,Font.PLAIN,13));
	    if (Controller.Move.TheEnd == true) {
		    infobox.setFont(new Font(""+Game.deck,Font.PLAIN,16));
		    if(Game.PlayersTurn == 2) {
			    infobox.setText("\n\n                Player "+Game.PlayersTurn +"\nHAS WON THE GAME ");
		    	infobox.setBackground(Color.YELLOW);
		    }else {
			    infobox.setText("\n\n                Player "+Game.PlayersTurn +"\nHAS WON THE GAME ");
		    	infobox.setBackground(Color.RED);
		    	}
	    }else {
		    infobox.setText("INFO BOX:\n \n Turn: Player "+Game.PlayersTurn +"\nCards Left: "+Game.deck);
	    }
	    infobox.setEditable(false);
		Window.basic_panel.add(infobox);
	}

}
