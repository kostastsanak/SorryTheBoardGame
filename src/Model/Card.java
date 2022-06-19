package Model;

public class Card {
	public static int num;
	
	
	public Card(int CardNum) {
		num = CardNum;
	}
	
	/**
	 * <Accessor> : returns the number of the card 
	 * <Postcondition> : 
	 * @return int num the number of the card
	 * <Precondition> : 
	 * Returns the Card num when clicked
	 */
	public static int GetCard() {
		return num;
	}
	
}
