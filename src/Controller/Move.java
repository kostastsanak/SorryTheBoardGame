package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import Model.Card;
import Model.GameObject;
import Model.Handler;
import Model.ID;
import Model.Square;
import View.PawnRed1;
import View.PawnRed2;
import View.PawnYel1;
import View.PawnYel2;
import View.Window;

public class Move {
	JButton Move = new JButton();
	JButton Move1 = new JButton();
	JButton Move2 = new JButton();
	JButton Move3 = new JButton();
	JButton Move4 = new JButton();
	JButton Move5 = new JButton();
	JButton Move6 = new JButton();
	JButton Card11Teleport1 = new JButton();
	JButton Card11Teleport2 = new JButton();
	JButton Move_1 = new JButton();
	private int x,y;
	private int MoveBlocks, Card7PawnDistanceBigger,Card7PawnDistanceSmaller,Card7CantClick=-1, Card7Max=7,Card7Min=0;
	private boolean Card7CantMoveAll=false;
	private boolean FlagRed= false , FlagRed2=false;
	private boolean FlagYel= false , FlagYel2=false;
	public static boolean TheEnd= false, ladder=false,ladder2 = false;
	ID id;
	Handler handler;
	String winner = "";
	public Move(int x, int y,ID id, Handler handler) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.handler = handler;
		render();
	}
	/**
	 * <Postcondition> : Returns a clickable image of where the pawn can move on
	 * <Precondition> : When Called makes the necessary checks and if possible creates a button on where the pawn can move.
	 * @param x our pawn's X position
	 */
	public void render() {
		Game.played =false;
		if (TheEnd == false) 
		{
			GameObject PawnRed1temp = handler.object.get(0);
			GameObject PawnRed2temp = handler.object.get(1);
			GameObject PawnYel1temp = handler.object.get(2);
			GameObject PawnYel2temp = handler.object.get(3);
			
			
			if (id == ID.PlayerRed1) {
				Square.RedXArray[0] = 170;
				Square.RedYArray[0] = 55;
				Square.RedXArray[73] = 80;
				Square.RedYArray[73] = 287;
			}
			if (id == ID.PlayerRed2) {
				Square.RedXArray[0] = 210;
				Square.RedYArray[0] = 55;
				Square.RedXArray[73] = 123;
				Square.RedYArray[73] = 287;
			}
			if (id == ID.PlayerYel1) {
				Square.YelXArray[0] = 510;
				Square.YelYArray[0] = 673;
				Square.YelXArray[73] = 604;
				Square.YelYArray[73] = 437;
			}
			if (id == ID.PlayerYel2) {
				Square.YelXArray[0] = 550;
				Square.YelYArray[0] = 673;
				Square.YelXArray[73] = 652;
				Square.YelYArray[73] = 437;
			}
			
			

			//Αρχικοποιεί τις κινήσεις βάση καρτών
			if (x!=0 && y !=0 ) {
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
					MoveBlocks =0;
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
			}else {
				if (Card.num == 0) {
					MoveBlocks =0;
				}else if (Card.num == 1)
				{
					MoveBlocks =9;
				}else if (Card.num == 2)
				{
					MoveBlocks =9;
				}else if (Card.num == 3)
				{
					MoveBlocks =0;
				}else if (Card.num == 4)
				{
					MoveBlocks =0;
				}else if (Card.num == 5)
				{
					MoveBlocks =0;
				}else if (Card.num == 6)
				{
					MoveBlocks =0;
				}else if (Card.num == 7)
				{
					MoveBlocks =0;
				}else if (Card.num == 8)
				{
					MoveBlocks =0;
				}else if (Card.num == 0)
				{
					MoveBlocks =0;
				}else if (Card.num == 10)
				{
					MoveBlocks =0;
				}else if (Card.num == -1)
				{
					MoveBlocks =0;
				}
			}
			if  (x+MoveBlocks>=0 && x+MoveBlocks<74 && x != 73 && Card.num != 6) {//κάνει τους απαραίτητους ελέγχους
				if (id == ID.PlayerRed1) {
					if (Square.RedXArray[x + MoveBlocks]!= Square.RedXArray[PawnRed2temp.getX()] ||  Square.RedYArray[y +MoveBlocks]!= Square.RedYArray[PawnRed2temp.getY()] || x+ MoveBlocks == 73 || x + MoveBlocks ==0) {
						FlagRed = true;
					}
				}else if (id == ID.PlayerRed2) {
					if (Square.RedXArray[x + MoveBlocks]!= Square.RedXArray[PawnRed1temp.getX()] ||  Square.RedYArray[y +MoveBlocks]!= Square.RedYArray[PawnRed1temp.getY()]|| x+ MoveBlocks == 73 || x + MoveBlocks==0) {
						FlagRed2 = true;
					}
				}else if (id == ID.PlayerYel1) {
					if (Square.YelXArray[x + MoveBlocks]!= Square.YelXArray[PawnYel2temp.getX()] ||  Square.YelYArray[y +MoveBlocks]!= Square.YelYArray[PawnYel2temp.getY()]|| x+ MoveBlocks == 73 || x + MoveBlocks==0) {
						FlagYel = true;
					}
				}else if (id == ID.PlayerYel2) {
					if (Square.YelXArray[x + MoveBlocks]!= Square.YelXArray[PawnYel1temp.getX()] ||  Square.YelYArray[y +MoveBlocks]!= Square.YelYArray[PawnYel1temp.getY()]|| x+ MoveBlocks == 73 || x + MoveBlocks==0) {
						FlagYel2 = true;
					}
				}
				
				
			}else if (x+MoveBlocks>=0 && x != 73 && Card.num == 6) {//διαφορετικοί ελέγχοι για αν η κάρτα είναι η 7
				
				if (id == ID.PlayerRed1) {
					if (PawnRed2temp.getX()!=0 && PawnRed2temp.getX() != 73) {
						if (PawnRed1temp.getX() > PawnRed2temp.getX()) {
							Card7Max = 73 - PawnRed1temp.getX();
							if (Card7Max > 7) {Card7Max = 7;}
							
							Card7PawnDistanceBigger = PawnRed1temp.getX() - PawnRed2temp.getX();
							if(Card7PawnDistanceBigger % 2 == 1) {
								if(Card7PawnDistanceBigger == 1) {
									if(PawnRed1temp.getX() + 3 != 73)
										Card7CantClick = 3;
								}else if(Card7PawnDistanceBigger == 3) {
									if(PawnRed1temp.getX() + 2 != 73)
										Card7CantClick = 2;
								}else if(Card7PawnDistanceBigger == 5) {
									if(PawnRed1temp.getX() + 1 != 73)
										Card7CantClick = 1;
								}else {Card7CantClick = -1;}
							}else {Card7PawnDistanceBigger  =0;}
							
						}else if(PawnRed1temp.getX() < PawnRed2temp.getX()) {
							
							Card7Min = 7-(73 - PawnRed2temp.getX());
							if (Card7Min <0) {Card7Min = 0;}
						
							Card7PawnDistanceSmaller = PawnRed2temp.getX() - PawnRed1temp.getX();
							if(Card7PawnDistanceSmaller % 2 == 1) {
								if(Card7PawnDistanceSmaller == 1) {
									if(PawnRed1temp.getX() + 4 != 73)
										Card7CantClick = 4;
								}else if(Card7PawnDistanceSmaller == 3) {
									if(PawnRed1temp.getX() + 5 != 73)
										Card7CantClick = 5;
								}else if(Card7PawnDistanceSmaller == 5) {
									if(PawnRed1temp.getX() + 6 != 73)
										Card7CantClick = 6;
								}else {Card7CantClick = -1;}
							}else {Card7PawnDistanceSmaller  =0;}
						}
						
						
						
					}else {
						Card7CantMoveAll=true;
					}
					if (x + MoveBlocks != 73&&(x + MoveBlocks== PawnRed2temp.getX() &&  y +MoveBlocks== PawnRed2temp.getY()|| x + MoveBlocks >=74)) {
						Card7CantClick =0;
					}
					FlagRed = true;
					FlagRed2 = true;
				}else if (id == ID.PlayerRed2) {
					if (PawnRed1temp.getX()!=0 && PawnRed1temp.getX() != 73) {
						if (PawnRed2temp.getX() > PawnRed1temp.getX()) {
							Card7Max = 73 - PawnRed2temp.getX();
							if (Card7Max > 7) {Card7Max = 7;}
							
							Card7PawnDistanceBigger = PawnRed2temp.getX() - PawnRed1temp.getX();
							if(Card7PawnDistanceBigger % 2 == 1) {
								if(Card7PawnDistanceBigger == 1) {
									if(PawnRed2temp.getX() + 3 != 73)
										Card7CantClick = 3;
								}else if(Card7PawnDistanceBigger == 3) {
									if(PawnRed2temp.getX() + 2 != 73)
										Card7CantClick = 2;
								}else if(Card7PawnDistanceBigger == 5) {
									if(PawnRed2temp.getX() + 1 != 73)
										Card7CantClick = 1;
								}else {Card7CantClick = -1;}
							}else {Card7PawnDistanceBigger  =0;}
							
						}else if(PawnRed2temp.getX() < PawnRed1temp.getX()) {
							
							Card7Min = 7-(73 - PawnRed1temp.getX());
							if (Card7Min <0) {Card7Min = 0;}
							Card7PawnDistanceSmaller = PawnRed1temp.getX() - PawnRed2temp.getX();//3
							
							if(Card7PawnDistanceSmaller % 2 == 1) {
								if(Card7PawnDistanceSmaller == 1) {
									if(PawnRed2temp.getX() + 4 != 73)
										Card7CantClick = 4;
								}else if(Card7PawnDistanceSmaller == 3) {
									if(PawnRed2temp.getX() + 5 != 73)
										Card7CantClick = 5;
								}else if(Card7PawnDistanceSmaller == 5) {
									if(PawnRed2temp.getX() + 6 != 73)
										Card7CantClick = 6;
								}else {Card7CantClick = -1;}
							}else {Card7PawnDistanceSmaller  =0;}
						}
						
						
						
					}else {
						Card7CantMoveAll=true;
					}
					if (x + MoveBlocks != 73&&(x + MoveBlocks== PawnRed1temp.getX() &&  y +MoveBlocks== PawnRed1temp.getY()|| x + MoveBlocks >=74)) {
						Card7CantClick =0;
					}
					FlagRed2 = true;
					FlagRed = true;
				}else if (id == ID.PlayerYel1) {
					if (PawnYel2temp.getX()!=0 && PawnYel2temp.getX() != 73) {
						if (PawnYel1temp.getX() > PawnYel2temp.getX()) {
							Card7Max = 73 - PawnYel1temp.getX();//2
							if (Card7Max > 7) {Card7Max = 7;}
							
							Card7PawnDistanceBigger = PawnYel1temp.getX() - PawnYel2temp.getX();//7
							
							if(Card7PawnDistanceBigger % 2 == 1) {
								if(Card7PawnDistanceBigger == 1) {
									if(PawnYel1temp.getX() + 3 != 73)
										Card7CantClick = 3;
								}else if(Card7PawnDistanceBigger == 3) {
									if(PawnYel1temp.getX() + 2 != 73)
										Card7CantClick = 2;
								}else if(Card7PawnDistanceBigger == 5) {
									if(PawnYel1temp.getX() + 1 != 73)
										Card7CantClick = 1;
								}else {Card7CantClick = -1;}
							}else {Card7PawnDistanceBigger  =0;}
							
						}else if(PawnYel1temp.getX() < PawnYel2temp.getX()) {
							
							Card7Min = 7-(73 - PawnYel2temp.getX());
							if (Card7Min <0) {Card7Min = 0;}
							Card7PawnDistanceSmaller = PawnYel2temp.getX() - PawnYel1temp.getX();
							
							if(Card7PawnDistanceSmaller % 2 == 1) {
								if(Card7PawnDistanceSmaller == 1) {
									if(PawnYel1temp.getX() + 4 != 73)
										Card7CantClick = 4;
								}else if(Card7PawnDistanceSmaller == 3) {
									if(PawnYel1temp.getX() + 5 != 73)
										Card7CantClick = 5;
								}else if(Card7PawnDistanceSmaller == 5) {
									if(PawnYel1temp.getX() + 6 != 73)
										Card7CantClick = 6;
								}else {Card7CantClick = -1;}
							}else {Card7PawnDistanceSmaller  =0;}
						}
						
						
						
					}else {
						Card7CantMoveAll=true;
					}
					if (x + MoveBlocks != 73&&(x + MoveBlocks== PawnYel2temp.getX() &&  y +MoveBlocks== PawnYel2temp.getY()|| x + MoveBlocks >=74)) {
						Card7CantClick =0;
					}
					FlagYel = true;
					FlagYel2 = true;
				}else if (id == ID.PlayerYel2) {
					if (PawnYel1temp.getX()!=0 && PawnYel1temp.getX() != 73) {
						if (PawnYel2temp.getX() > PawnYel1temp.getX()) {
							Card7Max = 73 - PawnYel2temp.getX();
							if (Card7Max > 7) {Card7Max = 7;}
							Card7PawnDistanceBigger = PawnYel2temp.getX() - PawnYel1temp.getX();
							
							if(Card7PawnDistanceBigger % 2 == 1) {
								if(Card7PawnDistanceBigger == 1) {
									if(PawnYel2temp.getX() + 3 != 73)
										Card7CantClick = 3;
								}else if(Card7PawnDistanceBigger == 3) {
									if(PawnYel2temp.getX() + 2 != 73)
										Card7CantClick =2;
								}else if(Card7PawnDistanceBigger == 5) {
									if(PawnYel2temp.getX() + 1 != 73)
										Card7CantClick = 1;
								}else {Card7CantClick = -1;}
							}else {Card7PawnDistanceBigger  =0;}
						}else if(PawnYel2temp.getX() < PawnYel1temp.getX()) {
							
							Card7Min = 7-(73 - PawnYel1temp.getX());
							if (Card7Min <0) {Card7Min = 0;}
							Card7PawnDistanceSmaller = PawnYel1temp.getX() - PawnYel2temp.getX();
							if(Card7PawnDistanceSmaller % 2 == 1) {
								if(Card7PawnDistanceSmaller == 1) {
									if(PawnYel2temp.getX() + 4 != 73)
										Card7CantClick = 4;
								}else if(Card7PawnDistanceSmaller == 3) {
									if(PawnYel2temp.getX() + 5 != 73)
										Card7CantClick = 5;
								}else if(Card7PawnDistanceSmaller == 5) {
									if(PawnYel2temp.getX() + 6 != 73)
										Card7CantClick = 6;
								}else {Card7CantClick = -1;}
							}else {Card7PawnDistanceSmaller  =0;}
						}
						

						
					}else {
						Card7CantMoveAll=true;
					}
					System.out.println(Card7CantClick);
					if (x + MoveBlocks != 73&&(x + MoveBlocks== PawnYel1temp.getX() &&  y +MoveBlocks== PawnYel1temp.getY()|| x + MoveBlocks >=74)) {
						Card7CantClick =0;
					}
					System.out.print(Card7CantClick);
					FlagYel = true;
					FlagYel2 = true;
				}
				
			}
			




				if((id == ID.PlayerRed1 && FlagRed == true) || (id == ID.PlayerRed2 && FlagRed2 == true)) //εμφανίζει το κουμπί κίνησεις για τα κόκκινα Pawns κάνοντας επιπλέον ελέγχους
				{
					
					
					if (Card.num == 0) { // 3anakoita3e
						if (x == 0 && y == 0) {
							if(PawnYel1temp.getX()!= 0 &&PawnYel1temp.getX() <68) {
								Card11Teleport1.setBounds(Square.YelXArray[PawnYel1temp.getX()]-7,Square.YelYArray[PawnYel1temp.getY()]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y						
							}
							if(PawnYel2temp.getX()!= 0 &&PawnYel2temp.getX() <68) {
								Card11Teleport2.setBounds(Square.YelXArray[PawnYel2temp.getX()]-7,Square.YelYArray[PawnYel2temp.getY()]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
						}
					}else if (Card.num == 1)
					{
						
						Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					}else if (Card.num == 2)
					{
						
						Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					}else if (Card.num == 3)
					{
						if (MoveBlocks !=0)
							Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					}else if (Card.num == 4)
					{
						if (MoveBlocks !=0 && x !=68 && x !=70&& x !=69&& x !=71)
							Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					}else if (Card.num == 5)
					{
						if (MoveBlocks !=0)
							Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					}else if (Card.num == 6 && x!=0)
					{
						if (Card7CantMoveAll == false) {
							if (Card7CantClick != 1 &&Card7Max>= 1 &&Card7Min<=1) {
								Move1.setBounds(Square.RedXArray[x +1]-7,Square.RedYArray[y+1]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y}
							}
							if (Card7CantClick != 2&&Card7Max>= 2 &&Card7Min<=2) {
								Move2.setBounds(Square.RedXArray[x +2]-7,Square.RedYArray[y+2]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
							if (Card7CantClick != 3&&Card7Max>= 3 &&Card7Min<=3) {
								Move3.setBounds(Square.RedXArray[x +3]-7,Square.RedYArray[y+3]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
							if (Card7CantClick != 4&&Card7Max>= 4 &&Card7Min<=4) {
								Move4.setBounds(Square.RedXArray[x +4]-7,Square.RedYArray[y+4]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
							if (Card7CantClick != 5&&Card7Max>= 5 &&Card7Min<=5) {
								Move5.setBounds(Square.RedXArray[x +5]-7,Square.RedYArray[y+5]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
							if (Card7CantClick != 6&&Card7Max>= 6 &&Card7Min<=6) {
								Move6.setBounds(Square.RedXArray[x +6]-7,Square.RedYArray[y+6]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
						}
						if (MoveBlocks !=0 && Card7CantClick != 0 )
							Move.setBounds(Square.RedXArray[x +7]-7,Square.RedYArray[y+7]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					}else if (Card.num == 7)
					{
						if (MoveBlocks !=0)
							Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					}else if (Card.num == 8)
					{
						if ((x-1 !=PawnRed1temp.getX() || y-1 != PawnRed1temp.getY()) && (x-1 !=PawnRed2temp.getX() || y-1 != PawnRed2temp.getY()) && x!=0 && x!=68) {
							Move_1.setBounds(Square.RedXArray[x -1]-7,Square.RedYArray[y-1]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}
						if (id == ID.PlayerRed1) {
							if (x + 10!= PawnRed2temp.getX() && x !=0 && x+10<=73&&PawnRed1temp.getX()!=73) {
								MoveBlocks =10;
								Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
						}else if (id == ID.PlayerRed2) {
							if (x +10!= PawnRed1temp.getX() && x !=0 && x+10<=73 &&PawnRed2temp.getX() != 73) {
								MoveBlocks =10;
								Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
						}
					}else if (Card.num == 9)
					{
						if (MoveBlocks !=0)
							Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						if(PawnYel1temp.getX()!= 0 &&PawnYel1temp.getX() <68 && x + MoveBlocks !=0) {
							Card11Teleport1.setBounds(Square.YelXArray[PawnYel1temp.getX()]-7,Square.YelYArray[PawnYel1temp.getY()]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y						
						}
						if(PawnYel2temp.getX()!= 0 &&PawnYel2temp.getX() <68 && x + MoveBlocks !=0) {
							Card11Teleport2.setBounds(Square.YelXArray[PawnYel2temp.getX()]-7,Square.YelYArray[PawnYel2temp.getY()]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}
					}else if (Card.num == 10)
					{
						if (MoveBlocks !=0)
							Move.setBounds(Square.RedXArray[x +MoveBlocks]-7,Square.RedYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					}
					
					
					
					
					
					


				}else if((id == ID.PlayerYel1 && FlagYel == true) || (id == ID.PlayerYel2 && FlagYel2 == true)) 	//εμφανίζει το κουμπί κίνησεις για τα κιτρινα Pawns κάνοντας επιπλέον ελέγχους
				{
					
						if (Card.num == 0) {
							if (x==0 && y==0) {
								if(PawnRed1temp.getX()!= 0 &&PawnRed1temp.getX() <68) {
									Card11Teleport1.setBounds(Square.RedXArray[PawnRed1temp.getX()]-7,Square.RedYArray[PawnRed1temp.getY()]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y						
								}
								if(PawnRed2temp.getX()!= 0 &&PawnRed2temp.getX() <68) {
									Card11Teleport2.setBounds(Square.RedXArray[PawnRed2temp.getX()]-7,Square.RedYArray[PawnRed2temp.getY()]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
								}
							}
						}else if (Card.num == 1)
						{
							Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}else if (Card.num == 2)
						{
							Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}else if (Card.num == 3)
						{
							if (MoveBlocks !=0)
								Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}else if (Card.num == 4)
						{
							if (MoveBlocks !=0&& x !=68 && x !=70&& x !=69&& x !=71)
								Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}else if (Card.num == 5)
						{
							if (MoveBlocks !=0)
								Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}else if (Card.num == 6 && x!=0)
						{
							if (Card7CantMoveAll == false) {
								if (Card7CantClick != 1 &&Card7Max>= 1 &&Card7Min<=1) {
									Move1.setBounds(Square.YelXArray[x +1]-7,Square.YelYArray[y+1]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
									}
								if (Card7CantClick != 2&&Card7Max>= 2 &&Card7Min<=2) {
									Move2.setBounds(Square.YelXArray[x +2]-7,Square.YelYArray[y+2]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y									
								}
								if (Card7CantClick != 3&&Card7Max>= 3 &&Card7Min<=3) {
									Move3.setBounds(Square.YelXArray[x +3]-7,Square.YelYArray[y+3]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
								}
								if (Card7CantClick != 4&&Card7Max>= 4 &&Card7Min<=4) {
									Move4.setBounds(Square.YelXArray[x +4]-7,Square.YelYArray[y+4]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
								}
								if (Card7CantClick != 5&&Card7Max>= 5 &&Card7Min<=5) {
									Move5.setBounds(Square.YelXArray[x +5]-7,Square.YelYArray[y+5]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
								}
								if (Card7CantClick != 6&&Card7Max>= 6 &&Card7Min<=6) {
									Move6.setBounds(Square.YelXArray[x +6]-7,Square.YelYArray[y+6]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y	
								}
							}
							
							
							if (MoveBlocks !=0&& Card7CantClick != 0)
								Move.setBounds(Square.YelXArray[x +7]-7,Square.YelYArray[y+7]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}else if (Card.num == 7)
						{
							if (MoveBlocks !=0)
								Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}else if (Card.num == 8)
						{
							if ((x-1 !=PawnYel1temp.getX() || y-1 != PawnYel1temp.getY()) && (x-1 !=PawnYel2temp.getX() || y-1 != PawnYel2temp.getY()) && x!=0&& x!=68) {
								Move_1.setBounds(Square.YelXArray[x -1]-7,Square.YelYArray[y-1]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
							
							
							if (id == ID.PlayerYel1) {
								if (x +10!= PawnYel2temp.getX() && x !=0 && x+10<=73&&PawnYel1temp.getX()!=73) {
									MoveBlocks =10;
									Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
								}
							}else if (id == ID.PlayerYel2) {
								if (x + 10!= PawnYel1temp.getX() && x !=0 && x+10<=73 &&PawnYel2temp.getX() != 73) {
									MoveBlocks =10;
									Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
								}
							}
							
						}else if (Card.num == 9)
						{
							if (MoveBlocks !=0)
								Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							if(PawnRed1temp.getX()!= 0 &&PawnRed1temp.getX() <68&& x + MoveBlocks !=0) {
								Card11Teleport1.setBounds(Square.RedXArray[PawnRed1temp.getX()]-7,Square.RedYArray[PawnRed1temp.getY()]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y						
							}
							if(PawnRed2temp.getX()!= 0 &&PawnRed2temp.getX() <68&& x + MoveBlocks !=0) {
								Card11Teleport2.setBounds(Square.RedXArray[PawnRed2temp.getX()]-7,Square.RedYArray[PawnRed2temp.getY()]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							}
						}else if (Card.num == 10)
						{
							if (MoveBlocks !=0)
								Move.setBounds(Square.YelXArray[x +MoveBlocks]-7,Square.YelYArray[y+MoveBlocks]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
						}
							
						
					}else {System.out.print("OOPS");}
				
				
				
				//Φτιάχνει το κάθε button
			Move.setBackground(Color.yellow);
			Move.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
	    	Window.basic_panel.add(Move);
	    	Move.addActionListener(new ButtonPushed());
	    	Move.setVisible(true);
	    	//Button Move1-Move6 einai gia thn karta 7
	    	Move1.setBackground(Color.yellow);
			Move1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
	    	Window.basic_panel.add(Move1);
	    	Move1.addActionListener(new ButtonPushed());
	    	Move1.setVisible(true);
	    	
	    	Move2.setBackground(Color.yellow);
			Move2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
	    	Window.basic_panel.add(Move2);
	    	Move2.addActionListener(new ButtonPushed());
	    	Move2.setVisible(true);
	    	
	    	Move3.setBackground(Color.yellow);
			Move3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
	    	Window.basic_panel.add(Move3);
	    	Move3.addActionListener(new ButtonPushed());
	    	Move3.setVisible(true);
	    	
	    	Move4.setBackground(Color.yellow);
			Move4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
	    	Window.basic_panel.add(Move4);
	    	Move4.addActionListener(new ButtonPushed());
	    	Move4.setVisible(true);
	    	
	    	Move5.setBackground(Color.yellow);
			Move5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
	    	Window.basic_panel.add(Move5);
	    	Move5.addActionListener(new ButtonPushed());
	    	Move5.setVisible(true);
	    	
	    	Move6.setBackground(Color.yellow);
			Move6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
	    	Window.basic_panel.add(Move6);
	    	Move6.addActionListener(new ButtonPushed());
	    	Move6.setVisible(true);
	    	
	    	
	    	Move_1.setBackground(Color.BLUE);
			Move_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
	    	Window.basic_panel.add(Move_1);
	    	Move_1.addActionListener(new ButtonPushed());
	    	Move_1.setVisible(true);
	    	
	    	Card11Teleport1.setBackground(Color.RED);
	    	Card11Teleport1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
	    	Window.basic_panel.add(Card11Teleport1);
	    	Card11Teleport1.addActionListener(new ButtonPushed());
	    	Card11Teleport1.setVisible(true);
	    	
	    	Card11Teleport2.setBackground(Color.RED);
	    	Card11Teleport2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
	    	Window.basic_panel.add(Card11Teleport2);
	    	Card11Teleport2.addActionListener(new ButtonPushed());
	    	Card11Teleport2.setVisible(true);
		}

	}
	
	
	private class ButtonPushed implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			if (id == ID.PlayerRed1) {
				Square.RedXArray[0] = 170;
				Square.RedYArray[0] = 55;
				Square.RedXArray[73] = 80;
				Square.RedYArray[73] = 287;
			}
			if (id == ID.PlayerRed2) {
				Square.RedXArray[0] = 210;
				Square.RedYArray[0] = 55;
				Square.RedXArray[73] = 123;
				Square.RedYArray[73] = 287;
			}
			if (id == ID.PlayerYel1) {
				Square.YelXArray[0] = 510;
				Square.YelYArray[0] = 673;
				Square.YelXArray[73] = 604;
				Square.YelYArray[73] = 437;
			}
			if (id == ID.PlayerYel2) {
				Square.YelXArray[0] = 550;
				Square.YelYArray[0] = 673;
				Square.YelXArray[73] = 652;
				Square.YelYArray[73] = 437;
			}
			
			Game.lastID = "";
			
			GameObject PawnRed1temp = handler.object.get(0);
			GameObject PawnRed2temp = handler.object.get(1);
			GameObject PawnYel1temp = handler.object.get(2);
			GameObject PawnYel2temp = handler.object.get(3);
			
			
			if(event.getSource() == Move) {
			}else if (event.getSource() == Move_1) {
				MoveBlocks -= (MoveBlocks + 1) ;
				
			}else if (event.getSource() == Move1) {
				MoveBlocks =1;
			}else if (event.getSource() == Move2) {
				MoveBlocks =2;
			}else if (event.getSource() == Move3) {
				MoveBlocks =3;
			}else if (event.getSource() == Move4) {
				MoveBlocks =4;
			}else if (event.getSource() == Move5) {
				MoveBlocks =5;
			}else if (event.getSource() == Move6) {
				MoveBlocks =6;
			}else if (event.getSource() == Card11Teleport1) {
				MoveBlocks =0;
			}else if (event.getSource() == Card11Teleport2) {
				MoveBlocks =0;
			}
			

			
			if (Game.moved !=0 && Card.num ==-1 )
				MoveBlocks = 0 ;
			//κινεί έπειτα απο εναν έλεγχο το συγκεκριμένο πιόνι
			if (id == ID.PlayerRed1) {	
				PawnRed1temp.setX(PawnRed1temp.getX()+MoveBlocks);
				PawnRed1temp.setY(PawnRed1temp.getY()+MoveBlocks);
				if (FlagRed == true || (Card.num ==-1)) {
					PawnRed1.Pred1B.setBounds(Square.RedXArray[PawnRed1temp.getX()],Square.RedYArray[PawnRed1temp.getY()],Window.PlayerWidth, Window.PlayerHeight);
				}else {
					System.out.println("YOU CANT CLICK THAT PAWN");
					PawnRed1temp.setX(PawnRed1temp.getX()-MoveBlocks);
					PawnRed1temp.setY(PawnRed1temp.getY()-MoveBlocks);
				}
			}
			if (id == ID.PlayerRed2) {
				PawnRed2temp.setX(PawnRed2temp.getX()+MoveBlocks);
				PawnRed2temp.setY(PawnRed2temp.getY()+MoveBlocks);
				if ( FlagRed2 == true || (Card.num ==-1)) {
					PawnRed2.Pred2B.setBounds(Square.RedXArray[PawnRed2temp.getX()],Square.RedYArray[PawnRed2temp.getY()],Window.PlayerWidth, Window.PlayerHeight);
				}else {
					System.out.println("YOU CANT CLICK THAT PAWN");
					PawnRed2temp.setX(PawnRed2temp.getX()-MoveBlocks);
					PawnRed2temp.setY(PawnRed2temp.getY()-MoveBlocks);
				}
			}
			
			
			if (id == ID.PlayerYel1) {	
				PawnYel1temp.setX(PawnYel1temp.getX()+MoveBlocks);
				PawnYel1temp.setY(PawnYel1temp.getY()+MoveBlocks);
				if (FlagYel == true|| (Card.num ==-1)) {
					PawnYel1.Pyel1B.setBounds(Square.YelXArray[PawnYel1temp.getX()],Square.YelYArray[PawnYel1temp.getY()],Window.PlayerWidth, Window.PlayerHeight);
				}else {
					System.out.println("YOU CANT CLICK THAT PAWN");
					PawnYel1temp.setX(PawnYel1temp.getX()-MoveBlocks);
					PawnYel1temp.setY(PawnYel1temp.getY()-MoveBlocks);
				}
			}
			
			if (id == ID.PlayerYel2) {
				PawnYel2temp.setX(PawnYel2temp.getX()+MoveBlocks);
				PawnYel2temp.setY(PawnYel2temp.getY()+MoveBlocks);
				if (FlagYel2 == true|| (Card.num ==-1)) {
					PawnYel2.Pyel2B.setBounds(Square.YelXArray[PawnYel2temp.getX()],Square.YelYArray[PawnYel2temp.getY()],Window.PlayerWidth, Window.PlayerHeight);
				}else {
					System.out.println("YOU CANT CLICK THAT PAWN");
					PawnYel2temp.setX(PawnYel2temp.getX()-MoveBlocks);
					PawnYel2temp.setY(PawnYel2temp.getY()-MoveBlocks);
				}
			}
			//αφαιρεί τα buttons μετά απο το τέλος της κίνησης
			Window.basic_panel.remove(Move_1);
			Window.basic_panel.remove(Move);
			Window.basic_panel.remove(Move1);
			Window.basic_panel.remove(Move2);
			Window.basic_panel.remove(Move3);
			Window.basic_panel.remove(Move4);
			Window.basic_panel.remove(Move5);
			Window.basic_panel.remove(Move6);
			Window.basic_panel.remove(Card11Teleport1);
			Window.basic_panel.remove(Card11Teleport2);
			Window.basic_panel.repaint();
			
			
			
			
			

			if (event.getSource() != Move) {//επιπλέον κίνηση για αν η καρτα είναι η sorry ή 11
				if (Card.num == 9 || Card.num == 0) {
					int X=8;
					int Y=8;
					if (id == ID.PlayerRed1 || id == ID.PlayerRed2) {
						
						
						if (event.getSource() == Card11Teleport1) {
							while ((Square.RedXArray[X] != Square.YelXArray[PawnYel1temp.getX()]) || (Square.RedYArray[Y] != Square.YelYArray[PawnYel1temp.getY()])  ) {
								X++;
								Y++;
							}
						}else if (event.getSource() == Card11Teleport2) {
							while ((Square.RedXArray[X] != Square.YelXArray[PawnYel2temp.getX()]) || (Square.RedYArray[Y] != Square.YelYArray[PawnYel2temp.getY()])  ) {
								X++;
								Y++;
							}
						}
						
						
						if (id == ID.PlayerRed1) {
							PawnRed1temp.setX(X);
							PawnRed1temp.setY(Y);
							PawnRed1.Pred1B.setBounds(Square.RedXArray[PawnRed1temp.getX()],Square.RedYArray[PawnRed1temp.getY()],Window.PlayerWidth, Window.PlayerHeight);
						}else if(id == ID.PlayerRed2) {
							PawnRed2temp.setX(X);
							PawnRed2temp.setY(Y);
							PawnRed2.Pred2B.setBounds(Square.RedXArray[PawnRed2temp.getX()],Square.RedYArray[PawnRed2temp.getY()],Window.PlayerWidth, Window.PlayerHeight);
						}
					}else if (id == ID.PlayerYel1 || id == ID.PlayerYel2) {
						
						
						if (event.getSource() == Card11Teleport1) {
							while ((Square.YelXArray[X] != Square.RedXArray[PawnRed1temp.getX()]) || (Square.YelYArray[Y] != Square.RedYArray[PawnRed1temp.getY()])  ) {
								X++;
								Y++;
							}
						}else if (event.getSource() == Card11Teleport2) {
							while ((Square.YelXArray[X] != Square.RedXArray[PawnRed2temp.getX()]) || (Square.YelYArray[Y] != Square.RedYArray[PawnRed2temp.getY()])  )  {
								X++;
								Y++;
							}
						}
						if(id == ID.PlayerYel1) {
							PawnYel1temp.setX(X);
							PawnYel1temp.setY(Y);
							PawnYel1.Pyel1B.setBounds(Square.YelXArray[PawnYel1temp.getX()],Square.YelYArray[PawnYel1temp.getY()],Window.PlayerWidth, Window.PlayerHeight);
						}else if(id == ID.PlayerYel2) {
							PawnYel2temp.setX(X);
							PawnYel2temp.setY(Y);
							PawnYel2.Pyel2B.setBounds(Square.YelXArray[PawnYel2temp.getX()],Square.YelYArray[PawnYel2temp.getY()],Window.PlayerWidth, Window.PlayerHeight);
						}
					}
					
					
					
					x= X;
					y = Y;
				}
			}
			
			
			
			if (id == ID.PlayerRed1) {
				if ( (Square.RedXArray[PawnRed1temp.getX()] == Square.YelXArray[PawnYel1temp.getX()])  && (Square.RedYArray[PawnRed1temp.getY()] == Square.YelYArray[PawnYel1temp.getY()]) ) {
					Square.YelXArray[0] = 510;
					Square.YelYArray[0] = 673;
					PawnYel1temp.setX(0);
					PawnYel1temp.setY(0);
					PawnYel1.Pyel1B.setBounds(Square.YelXArray[0],Square.YelYArray[0],Window.PlayerWidth, Window.PlayerHeight);
				}
				if ( (Square.RedXArray[PawnRed1temp.getX()] == Square.YelXArray[PawnYel2temp.getX()])  && (Square.RedYArray[PawnRed1temp.getY()] == Square.YelYArray[PawnYel2temp.getY()]) ) {
					Square.YelXArray[0] = 550;
					Square.YelYArray[0] = 673;
					PawnYel2temp.setX(0);
					PawnYel2temp.setY(0);
					PawnYel2.Pyel2B.setBounds(Square.YelXArray[0],Square.YelYArray[0],Window.PlayerWidth, Window.PlayerHeight);
				}
			}else if (id == ID.PlayerRed2) {
				if ( (Square.RedXArray[PawnRed2temp.getX()] == Square.YelXArray[PawnYel1temp.getX()])  && (Square.RedYArray[PawnRed2temp.getY()] == Square.YelYArray[PawnYel1temp.getY()]) ) {
					Square.YelXArray[0] = 510;
					Square.YelYArray[0] = 673;
					PawnYel1temp.setX(0);
					PawnYel1temp.setY(0);
					PawnYel1.Pyel1B.setBounds(Square.YelXArray[0],Square.YelYArray[0],Window.PlayerWidth, Window.PlayerHeight);
				}
				if ( (Square.RedXArray[PawnRed2temp.getX()] == Square.YelXArray[PawnYel2temp.getX()])  && (Square.RedYArray[PawnRed2temp.getY()] == Square.YelYArray[PawnYel2temp.getY()]) ) {
					Square.YelXArray[0] = 550;
					Square.YelYArray[0] = 673;
					PawnYel2temp.setX(0);
					PawnYel2temp.setY(0);
					PawnYel2.Pyel2B.setBounds(Square.YelXArray[0],Square.YelYArray[0],Window.PlayerWidth, Window.PlayerHeight);
				}
			}else if (id == ID.PlayerYel1) {
				if ( (Square.YelXArray[PawnYel1temp.getX()] == Square.RedXArray[PawnRed1temp.getX()])  && (Square.YelYArray[PawnYel1temp.getY()] == Square.RedYArray[PawnRed1temp.getY()]) ) {
					Square.RedXArray[0] = 170;
					Square.RedYArray[0] = 55;
					PawnRed1temp.setX(0);
					PawnRed1temp.setY(0);
					PawnRed1.Pred1B.setBounds(Square.RedXArray[0],Square.RedYArray[0],Window.PlayerWidth, Window.PlayerHeight);
				}
				if ( (Square.YelXArray[PawnYel1temp.getX()] == Square.RedXArray[PawnRed2temp.getX()])  && (Square.YelYArray[PawnYel1temp.getY()] == Square.RedYArray[PawnRed2temp.getY()]) ) {
					Square.RedXArray[0] = 210;
					Square.RedYArray[0] = 55;
					PawnRed2temp.setX(0);
					PawnRed2temp.setY(0);
					PawnRed2.Pred2B.setBounds(Square.RedXArray[0],Square.RedYArray[0],Window.PlayerWidth, Window.PlayerHeight);
				}
			}else if (id == ID.PlayerYel2) {
				if ( (Square.YelXArray[PawnYel2temp.getX()] == Square.RedXArray[PawnRed1temp.getX()])  && (Square.YelYArray[PawnYel2temp.getY()] == Square.RedYArray[PawnRed1temp.getY()]) ) {
					Square.RedXArray[0] = 170;
					Square.RedYArray[0] = 55;
					PawnRed1temp.setX(0);
					PawnRed1temp.setY(0);
					PawnRed1.Pred1B.setBounds(Square.RedXArray[0],Square.RedYArray[0],Window.PlayerWidth, Window.PlayerHeight);
				}
				if ( (Square.YelXArray[PawnYel2temp.getX()] == Square.RedXArray[PawnRed2temp.getX()])  && (Square.YelYArray[PawnYel2temp.getY()] == Square.RedYArray[PawnRed2temp.getY()]) ) {
					Square.RedXArray[0] = 210;
					Square.RedYArray[0] = 55;
					PawnRed2temp.setX(0);
					PawnRed2temp.setY(0);
					PawnRed2.Pred2B.setBounds(Square.RedXArray[0],Square.RedYArray[0],Window.PlayerWidth, Window.PlayerHeight);
				}
			}  
			
			
		
			if (id == ID.PlayerRed1 || id == ID.PlayerRed2) {//επιπλέον έλεγχος για αν το αντίθετο χρώμα πιονιού είναι πάνω σε ladder

				if ((x + MoveBlocks>=36&&x + MoveBlocks<=39 )&& (y + MoveBlocks>=36&&y + MoveBlocks<=39 )) {
					x=39;
					y=39;
					ladder = true;
					
				}else if((x + MoveBlocks>=44&&x + MoveBlocks<=48 )&& (y + MoveBlocks>=44&&y + MoveBlocks<=48 )) {
					ladder2 = true;
					x=48;
					y=48;
				}
				if (ladder == true) {
					if (PawnYel1temp.getX()>=6 && PawnYel1temp.getX()<=9) {
						PawnYel1.Pyel1B.setBounds(Square.YelXArray[0],Square.YelYArray[0],Window.PlayerWidth, Window.PlayerHeight);
						PawnYel1temp.setX(0);
						PawnYel1temp.setY(0);
					}else if (PawnYel2temp.getX()>=6 && PawnYel2temp.getX()<=9) {
						PawnYel2.Pyel2B.setBounds(Square.YelXArray[0],Square.YelYArray[0],Window.PlayerWidth, Window.PlayerHeight);
						PawnYel2temp.setX(0);
						PawnYel2temp.setY(0);
					}
					
				}
					
				
				if (ladder2 == true) {
					if (PawnYel1temp.getX()>=14 && PawnYel1temp.getX()<=18) {
						PawnYel1.Pyel1B.setBounds(Square.YelXArray[0],Square.YelYArray[0],Window.PlayerWidth, Window.PlayerHeight);
						PawnYel1temp.setX(0);
						PawnYel1temp.setY(0);
					}else if (PawnYel2temp.getX()>=14 && PawnYel2temp.getX()<=18) {
						PawnYel2.Pyel2B.setBounds(Square.YelXArray[0],Square.YelYArray[0],Window.PlayerWidth, Window.PlayerHeight);
						PawnYel2temp.setX(0);
						PawnYel2temp.setY(0);
					}
				}
					
				if (ladder== true || ladder2== true) {
					if (id == ID.PlayerRed1) {
						PawnRed1temp.setX(x);
						PawnRed1temp.setY(y);
						PawnRed1.Pred1B.setBounds(Square.RedXArray[PawnRed1temp.getX()],Square.RedYArray[PawnRed1temp.getX()],Window.PlayerWidth, Window.PlayerHeight);
					}
					if (id == ID.PlayerRed2) {
						PawnRed2temp.setX(x);
						PawnRed2temp.setY(y);
						PawnRed2.Pred2B.setBounds(Square.RedXArray[PawnRed2temp.getX()],Square.RedYArray[PawnRed2temp.getX()],Window.PlayerWidth, Window.PlayerHeight);
					}
				}	
				
					
				
			}else if (id == ID.PlayerYel1 || id == ID.PlayerYel2) {


				if ((x + MoveBlocks>=36 && x + MoveBlocks<=39 )&& (y + MoveBlocks>=36 && y + MoveBlocks<=39 )) {
					ladder = true;
					x=39;
					y=39;
				}else if((x + MoveBlocks>=44 && x + MoveBlocks<=48 )&& (y + MoveBlocks>=44 && y + MoveBlocks<=48 )) {
					ladder2 = true;
					x=48;
					y=48;
				}
				
				if (ladder == true ) {
					if (PawnRed1temp.getX()>=6 && PawnRed1temp.getX()<=9) {
						PawnRed1.Pred1B.setBounds(Square.RedXArray[0],Square.RedYArray[0],Window.PlayerWidth, Window.PlayerHeight);
						PawnRed1temp.setX(0);
						PawnRed1temp.setY(0);
					}else if (PawnRed2temp.getX()>=6 && PawnRed2temp.getX()<=9) {
						PawnRed2.Pred2B.setBounds(Square.RedXArray[0],Square.RedYArray[0],Window.PlayerWidth, Window.PlayerHeight);
						PawnRed2temp.setX(0);
						PawnYel2temp.setY(0);
					}
				}
				
				if (ladder2 == true) {
					if (PawnRed1temp.getX()>=14 && PawnRed1temp.getX()<=18) {
						PawnRed1.Pred1B.setBounds(Square.RedXArray[0],Square.RedYArray[0],Window.PlayerWidth, Window.PlayerHeight);
						PawnRed1temp.setX(0);
						PawnRed1temp.setY(0);
					}else if (PawnRed2temp.getX()>=14 && PawnRed2temp.getX()<=18) {
						PawnRed2.Pred2B.setBounds(Square.RedXArray[0],Square.RedYArray[0],Window.PlayerWidth, Window.PlayerHeight);
						PawnRed2temp.setX(0);
						PawnYel2temp.setY(0);
					}
				}
					
				
				if (ladder == true || ladder2 == true) {
					if (id == ID.PlayerYel1) {
						PawnYel1temp.setX(x);
						PawnYel1temp.setY(y);
						PawnYel1.Pyel1B.setBounds(Square.YelXArray[PawnYel1temp.getX()],Square.YelYArray[PawnYel1temp.getX()],Window.PlayerWidth, Window.PlayerHeight);
					}
					if (id == ID.PlayerYel2) {
						PawnYel2temp.setX(x);
						PawnYel2temp.setY(y);
						PawnYel2.Pyel2B.setBounds(Square.YelXArray[PawnYel2temp.getX()],Square.YelYArray[PawnYel2temp.getX()],Window.PlayerWidth, Window.PlayerHeight);
					}
				}
					
					
				
				
			}
			ladder2 = false;
			ladder = false;
			
			Game.played = true;

			
			if (Card.num == 6 && x!=0) {//επιπλέον κίνηση για αν η καρτα είναι η 7
				
				Game.moved = MoveBlocks;
				if (id == ID.PlayerRed1) {
					if (PawnRed2temp.getX() !=0 && PawnRed2temp.getY() !=0) {
						id = ID.PlayerRed2;
						x=PawnRed2temp.getX();
						y=PawnRed2temp.getY();
						if (7 - MoveBlocks == 0) {
						}else if (7 - MoveBlocks == 1) {
							Move1.setBounds(Square.RedXArray[PawnRed2temp.getX()+1]-7,Square.RedYArray[PawnRed2temp.getY()+1]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							Window.basic_panel.add(Move1);
					    	Move1.addActionListener(new ButtonPushed());
					    	Move1.setVisible(true);
						}else if (7 - MoveBlocks == 2) {
							Move2.setBounds(Square.RedXArray[PawnRed2temp.getX()+2]-7,Square.RedYArray[PawnRed2temp.getY()+2]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move2);
					    	Move2.addActionListener(new ButtonPushed());
					    	Move2.setVisible(true);
						}else if (7 - MoveBlocks == 3) {
							Move3.setBounds(Square.RedXArray[PawnRed2temp.getX()+3]-7,Square.RedYArray[PawnRed2temp.getY()+3]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move3);
					    	Move3.addActionListener(new ButtonPushed());
					    	Move3.setVisible(true);
						}else if (7 - MoveBlocks == 4) {
							Move4.setBounds(Square.RedXArray[PawnRed2temp.getX() +4]-7,Square.RedYArray[PawnRed2temp.getY()+4]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move4);
					    	Move4.addActionListener(new ButtonPushed());
					    	Move4.setVisible(true);
						}else if (7 - MoveBlocks == 5) {
							Move5.setBounds(Square.RedXArray[PawnRed2temp.getX() +5]-7,Square.RedYArray[PawnRed2temp.getY()+5]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move5);
					    	Move5.addActionListener(new ButtonPushed());
					    	Move5.setVisible(true);
						}else if (7 - MoveBlocks == 6) {
							Move6.setBounds(Square.RedXArray[PawnRed2temp.getX()+6 ]-7,Square.RedYArray[PawnRed2temp.getY()+6]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							Window.basic_panel.add(Move6);
					    	Move6.addActionListener(new ButtonPushed());
					    	Move6.setVisible(true);
						}
					}
				}else if (id == ID.PlayerRed2) {
					if (PawnRed1temp.getX() !=0 && PawnRed1temp.getY() !=0) {
						id = ID.PlayerRed1;
						x=PawnRed1temp.getX();
						y=PawnRed1temp.getY();
						if (7 - MoveBlocks == 0) {
						}else if (7 - MoveBlocks == 1) {
							Move1.setBounds(Square.RedXArray[PawnRed1temp.getX()+1 ]-7,Square.RedYArray[PawnRed1temp.getY()+1]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							Window.basic_panel.add(Move1);
					    	Move1.addActionListener(new ButtonPushed());
					    	Move1.setVisible(true);
						}else if (7 - MoveBlocks == 2) {
							Move2.setBounds(Square.RedXArray[PawnRed1temp.getX() +2]-7,Square.RedYArray[PawnRed1temp.getY()+2]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move2);
					    	Move2.addActionListener(new ButtonPushed());
					    	Move2.setVisible(true);
						}else if (7 - MoveBlocks == 3) {
							Move3.setBounds(Square.RedXArray[PawnRed1temp.getX() +3]-7,Square.RedYArray[PawnRed1temp.getY()+3]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move3);
					    	Move3.addActionListener(new ButtonPushed());
					    	Move3.setVisible(true);
						}else if (7 - MoveBlocks == 4) {
							Move4.setBounds(Square.RedXArray[PawnRed1temp.getX() +4]-7,Square.RedYArray[PawnRed1temp.getY()+4]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move4);
					    	Move4.addActionListener(new ButtonPushed());
					    	Move4.setVisible(true);
						}else if (7 - MoveBlocks == 5) {
							Move5.setBounds(Square.RedXArray[PawnRed1temp.getX() +5]-7,Square.RedYArray[PawnRed1temp.getY()+5]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move5);
					    	Move5.addActionListener(new ButtonPushed());
					    	Move5.setVisible(true);
						}else if (7 - MoveBlocks == 6) {
							Move6.setBounds(Square.RedXArray[PawnRed1temp.getX()+6]-7,Square.RedYArray[PawnRed1temp.getY()+6]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
							Window.basic_panel.add(Move6);
					    	Move6.addActionListener(new ButtonPushed());
					    	Move6.setVisible(true);
						}
					}
				}else if (id == ID.PlayerYel1) {
					if (PawnYel2temp.getX() !=0 && PawnYel2temp.getY() !=0) {
						id = ID.PlayerYel2;
						x=PawnYel2temp.getX();
						y=PawnYel2temp.getY();
						if (7 - MoveBlocks == 0) {
						}else if (7 - MoveBlocks == 1) {
							Move1.setBounds(Square.YelXArray[PawnYel2temp.getX() +1]-7,Square.YelYArray[PawnYel2temp.getY()+1]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move1);
					    	Move1.addActionListener(new ButtonPushed());
					    	Move1.setVisible(true);
						}else if (7 - MoveBlocks == 2) {
							Move2.setBounds(Square.YelXArray[PawnYel2temp.getX() +2]-7,Square.YelYArray[PawnYel2temp.getY()+2]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move2);
					    	Move2.addActionListener(new ButtonPushed());
					    	Move2.setVisible(true);
						}else if (7 - MoveBlocks == 3) {
							Move3.setBounds(Square.YelXArray[PawnYel2temp.getX()+3]-7,Square.YelYArray[PawnYel2temp.getY()+3]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move3);
					    	Move3.addActionListener(new ButtonPushed());
					    	Move3.setVisible(true);
						}else if (7 - MoveBlocks == 4) {
							Move4.setBounds(Square.YelXArray[PawnYel2temp.getX()+4 ]-7,Square.YelYArray[PawnYel2temp.getY()+4]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move4);
					    	Move4.addActionListener(new ButtonPushed());
					    	Move4.setVisible(true);
						}else if (7 - MoveBlocks == 5) {
							Move5.setBounds(Square.YelXArray[PawnYel2temp.getX() +5]-7,Square.YelYArray[PawnYel2temp.getY()+5]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move5);
					    	Move5.addActionListener(new ButtonPushed());
					    	Move5.setVisible(true);
						}else if (7 - MoveBlocks == 6) {
							Move6.setBounds(Square.YelXArray[PawnYel2temp.getX()+6 ]-7,Square.YelYArray[PawnYel2temp.getY()+6]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move6);
					    	Move6.addActionListener(new ButtonPushed());
					    	Move6.setVisible(true);
						}
					}
					
				}else if (id == ID.PlayerYel2) {
					if (PawnYel1temp.getX() !=0 && PawnYel1temp.getY() !=0) {
						id = ID.PlayerYel1;
						x=PawnYel1temp.getX();
						y=PawnYel1temp.getY();
						if (7 - MoveBlocks == 0) {
						}else if (7 - MoveBlocks == 1) {
							Move1.setBounds(Square.YelXArray[PawnYel1temp.getX()+1 ]-7,Square.YelYArray[PawnYel1temp.getY()+1]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move1);
					    	Move1.addActionListener(new ButtonPushed());
					    	Move1.setVisible(true);
						}else if (7 - MoveBlocks == 2) {
							Move2.setBounds(Square.YelXArray[PawnYel1temp.getX()+2]-7,Square.YelYArray[PawnYel1temp.getY()+2]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move2);
					    	Move2.addActionListener(new ButtonPushed());
					    	Move2.setVisible(true);
						}else if (7 - MoveBlocks == 3) {
							Move3.setBounds(Square.YelXArray[PawnYel1temp.getX()+3]-7,Square.YelYArray[PawnYel1temp.getY()+3]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move3);
					    	Move3.addActionListener(new ButtonPushed());
					    	Move3.setVisible(true);
						}else if (7 - MoveBlocks == 4) {
							Move4.setBounds(Square.YelXArray[PawnYel1temp.getX()+3]-7,Square.YelYArray[PawnYel1temp.getY()+3]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move4);
					    	Move4.addActionListener(new ButtonPushed());
					    	Move4.setVisible(true);
						}else if (7 - MoveBlocks == 5) {
							Move5.setBounds(Square.YelXArray[PawnYel1temp.getX()+4]-7,Square.YelYArray[PawnYel1temp.getY()]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move5);
					    	Move5.addActionListener(new ButtonPushed());
					    	Move5.setVisible(true);
						}else if (7 - MoveBlocks == 6) {
							Move6.setBounds(Square.YelXArray[PawnYel1temp.getX()+4]-7,Square.YelYArray[PawnYel1temp.getY()+4]-5,48, 48); //thesi X, thesi Y, megethos X, megethos Y
					    	Window.basic_panel.add(Move6);
					    	Move6.addActionListener(new ButtonPushed());
					    	Move6.setVisible(true);
						}
					}
				}
				
			}else {
				Game.moved = 0;
			}
			
			Card.num = -1;
			//Έλεγχος για αν τελείωσε το παιχνίδι
			if ((PawnRed1temp.getX() == 73 && PawnRed1temp.getY() == 73) && (PawnRed2temp.getX() == 73 && PawnRed2temp.getY() == 73) ) {
				winner = "Red WON";
				TheEnd = true;
			}
			if ((PawnYel1temp.getX() == 73 && PawnYel1temp.getY() == 73) && (PawnYel2temp.getX() == 73 && PawnYel2temp.getY() == 73)) {
				winner = "Yellow WON";
				TheEnd = true;
				
			}
			
			
			System.out.print(winner);
			
			
			
		}
	}
	
}
