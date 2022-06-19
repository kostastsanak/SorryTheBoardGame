package Model;

import Controller.Game;
import java.util.Random;

public class Deck {
	public int FullDeck = 44;
	Random r = new Random();
	public static int [] Deck = new int [44];
	/**
	 * <Accessor> : returns the cards our deck currently has.
	 * <Postcondition> : Cards being returned.
	 * @return int Game.deck
	 */
	public int GetCardsLeft() {
		return Game.deck;
	}
	
	/**
	 * <Transformer>: Riffiles the deck
	 * <Postcondition>: Sets the number of our Deck back to full
	 * <Precondition>: If the Deck gets to 0 or the Button shuffle is pressed then ShuffleDeck() shuffles the deck
	 */
	public void ShuffleDeck() {
		System.out.println();
		int [] Deck = {0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10};
		for (int i=0; i<44; i++) {
			int temp = r.nextInt(44);
			int temp1 = 0;
			temp1=Deck[i];
			Deck[i] = Deck[temp];
			Deck[temp] = temp1;
		}
		for (int i=0; i<44; i++) {
			Model.Deck.Deck[i] = Deck[i];
		}
	}
	public int Card() {
		return Deck[Game.deck - 1];
	}
	
}
