package Controller;

import Model.Card;
import Model.GameObject;
import Model.Handler;

public class Movable {
	
	boolean flag = false;
	
	Handler handler;
	int MoveBlocks;
	public Movable(Handler handler) {
		this.handler = handler;
	}
	
	/**
	 * <Postcondition> : Returns a boolean flag which intigates if there is any move for the Player's turn with the Card number given
	 * <Precondition> : When Calles checks if the Player can move any pawn with the card number given
	 * @param x our pawn's X position
	 */
	public boolean isMovable(){
		GameObject PawnRed1temp = handler.object.get(0);
		GameObject PawnRed2temp = handler.object.get(1);
		GameObject PawnYel1temp = handler.object.get(2);
		GameObject PawnYel2temp = handler.object.get(3);

		//Αρχικοποιει την κίνηση ανάλογα με την κάρτα
		if (Card.num == 0) {
			MoveBlocks =0;
		}else if (Card.num == 1)
		{
			MoveBlocks =1;
		}else if (Card.num == 2)
		{
			MoveBlocks =2;
		}else if (Card.num == 3)
		{
			MoveBlocks =3;
		}else if (Card.num == 4)
		{
			MoveBlocks =-4;
		}else if (Card.num == 5)
		{
			MoveBlocks =5;
		}else if (Card.num == 6)
		{
			MoveBlocks =7; 
		}else if (Card.num == 7)
		{
			MoveBlocks =8;
		}else if (Card.num == 8)
		{
			MoveBlocks =10;
		}else if (Card.num == 9)
		{
			MoveBlocks =11;
		}else if (Card.num == 10)
		{
			MoveBlocks =12;
		}else if (Card.num == -1)
		{
			MoveBlocks =0;
		}

		
		
		
		
		
		
		
		
		//Κάνει τον έλεγχο για τα κόκκινα Pawns
		if (Controller.Game.PlayersTurn == 1) {
			if(PawnRed1temp.getX() ==0 || PawnRed2temp.getX() == 0) {
				if(Card.num == 1 || Card.num ==2) {
					flag = true;
				}else if (Card.num == 0) {
					if ((PawnYel1temp.getX() !=0 && PawnYel1temp.getX() <68 ) ||(PawnYel2temp.getX() != 0&& PawnYel2temp.getX() < 68)) {
						flag  = true;
					}
				}
				
				
			}
			if (PawnRed1temp.getX() !=0 && PawnRed1temp.getX() + MoveBlocks != PawnRed2temp.getX() &&  PawnRed1temp.getX() + MoveBlocks>0 && PawnRed1temp.getX() + MoveBlocks < 74 ) {
				if (Card.num !=0)
					flag = true;
				if (Card.num == 4) {
					if (PawnRed1temp.getX() == 68 ||PawnRed1temp.getX() == 69 ||PawnRed1temp.getX() == 70 ||PawnRed1temp.getX() == 71||PawnRed1temp.getX() == 71) {
						flag = false;
					}
				}
				
				

				
				
				
			}
			
			if (Card.num == 8) {
				if (PawnRed1temp.getX()- 1 != PawnRed2temp.getX()&& PawnRed1temp.getX() != 68&& PawnRed1temp.getX() != 0&& PawnRed2temp.getX() != 73&& PawnRed1temp.getX() != 73) {
					flag = true;
				}
			}
			if (PawnRed2temp.getX() != 0 && PawnRed2temp.getX()+ MoveBlocks != PawnRed1temp.getX() &&  PawnRed2temp.getX() + MoveBlocks>0 && PawnRed2temp.getX() + MoveBlocks < 74 ) {
				if (Card.num !=0)
					flag = true;
				if (Card.num == 4) {
					if (PawnRed2temp.getX() == 68 ||PawnRed2temp.getX() == 69 ||PawnRed2temp.getX() == 70 ||PawnRed2temp.getX() == 71||PawnRed2temp.getX() == 73) {
						flag = false;
					}
				}
				
				
			}
			
			if (Card.num == 8) {
				if (PawnRed2temp.getX()- 1 != PawnRed1temp.getX()&& PawnRed2temp.getX() != 68&& PawnRed2temp.getX() != 0&& PawnRed2temp.getX() != 73&& PawnRed1temp.getX() != 73) {
					flag = true;
				}
			}
			if (Card.num == 9&& PawnRed2temp.getX() != 0 &&PawnRed1temp.getX() != 0&& PawnRed2temp.getX() <68 &&PawnRed1temp.getX() <68 ) {
				if ((PawnYel1temp.getX() !=0 || PawnYel2temp.getX() != 0)&&(PawnYel1temp.getX() <68 || PawnYel2temp.getX() <68)) {
					flag  = true;
				}
			}
			if (Card.num == -1) {
				flag = false;
			}
			
		}else if (Controller.Game.PlayersTurn == 2) {//Κάνει τον έλεγχο για τα κίτρινα Pawns
			if(PawnYel1temp.getX() ==0 || PawnYel2temp.getX() == 0) {
				if(Card.num == 1 || Card.num ==2) {
					flag = true;
				}else if (Card.num == 0) {
					if ((PawnRed1temp.getX() !=0 && PawnRed1temp.getX() <68) || (PawnRed2temp.getX() != 0 && PawnRed2temp.getX() <= 68)) {
						flag  = true;
					}
				}
				
				
			}
			if (PawnYel1temp.getX() !=0 && PawnYel1temp.getX() + MoveBlocks != PawnYel2temp.getX() && Card.num !=0 && PawnYel1temp.getX()+ MoveBlocks> 0 && PawnYel1temp.getX()+ MoveBlocks <74) {
				flag = true;
				
				if (Card.num == 4) {
					if (PawnYel1temp.getX() == 68 ||PawnYel1temp.getX() == 69 ||PawnYel1temp.getX() == 70 ||PawnYel1temp.getX() == 71||PawnYel1temp.getX() == 73) {
						flag = false;
					}
				}
				
				

				
				
			}
			
			if (Card.num == 8) {
				if (PawnYel1temp.getX()- 1 != PawnYel2temp.getX()&& PawnYel1temp.getX() != 68&& PawnYel1temp.getX() != 0&& PawnYel1temp.getX() != 73&& PawnYel2temp.getX() != 73) {
					flag = true;
				}
			}
			if (PawnYel2temp.getX() != 0 && PawnYel2temp.getX()+ MoveBlocks != PawnYel1temp.getX() && Card.num !=0 && PawnYel2temp.getX()+ MoveBlocks> 0 && PawnYel2temp.getX()+ MoveBlocks <74 ) {
				flag = true;
				if (Card.num == 4) {
					if (PawnYel2temp.getX() == 68 ||PawnYel2temp.getX() == 69 ||PawnYel2temp.getX() == 70 ||PawnYel2temp.getX() == 71||PawnYel2temp.getX() == 73) {
						flag = false;
					}
				}
				
				
				
			}
			if (Card.num == -1) {
				flag = false;
			}
			
			if (Card.num == 8) {
				if (PawnYel2temp.getX()- 1 != PawnYel1temp.getX() && PawnYel2temp.getX() != 68 && PawnYel2temp.getX() !=0&& PawnYel2temp.getX() != 73&& PawnYel1temp.getX() != 73) {
					flag = true;
				}
			}
			if (Card.num == 9&&PawnYel2temp.getX() != 0 &&PawnYel1temp.getX() != 0 &&PawnYel2temp.getX() <68 &&PawnYel1temp.getX() <68 ) {
				if ((PawnRed1temp.getX() !=0 || PawnRed2temp.getX() != 0)&&(PawnRed1temp.getX() <68 || PawnRed2temp.getX() <68)) {
					flag  = true;
				}
			}
			
			
			
			
			
			
		}
		
		
		
		
		
		
		return flag;//Επιστρέφει true αν μπόρει να γίνει η οποιαδήποτε κίνηση και false αν όχι
	}
	
	
	
	
	
	
	
	
	
	
}
