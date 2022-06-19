package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.Game;
import Model.Deck;



public class ShuffleButton {
	Window w = new Window();
	Deck d = new Deck();
	/**
	 * Graphics of the Shuffle button
	 */
	public void render(){
        JLabel FoldLabel = new JLabel("Shuffle the Cards");
        
        
        JButton Shuffle = new JButton();
        Shuffle.setBounds(800, 472, 200, 70); 
        Shuffle.setBackground(Color.yellow);
        Shuffle.add(FoldLabel);
    	Window.basic_panel.add(Shuffle);
    	
    	ButtonPushed pushed = new ButtonPushed();
    	Shuffle.addActionListener(pushed);
    	
    	
    	Shuffle.setVisible(true);
	}
	
    /**
     * What happens when the Shuffle button is pushed
     *
     */
    private class ButtonPushed implements ActionListener{
    	 /**
         * If the Button is pushed it shuffles the Deck
         *
         */
		public void actionPerformed(ActionEvent event) {
			if (Controller.Move.TheEnd == false){
				d.ShuffleDeck();
				Game.deck = 44;
				Info i= new Info();
				i.render();	
			}
		}
	}
	
}
