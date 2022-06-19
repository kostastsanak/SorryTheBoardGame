package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Controller.Game;
import Model.GameObject;
import Model.Handler;
import Model.ID;
import Model.Square;


public class PawnRed2 extends GameObject {

	public static JButton Pred2B;
	Handler handler;
	public PawnRed2(ID id,Handler handler){
    	super(id);
    	this.handler = handler;
    }
	/**
	 *Shows the Graphic part of the that specific Pawn
	 */
	public void render() {
		Pred2B = new JButton();
		Pred2B.setBounds(Square.Red2StartX, Square.Red2StartY,Window.PlayerWidth, Window.PlayerHeight); //thesi X, thesi Y, megethos X, megethos Y
    	Window.imageURL = Window.cldr.getResource("resources//Players//redPawn2.png");
    	Window.image = new ImageIcon(Window.imageURL).getImage();
    	Window.image = Window.image.getScaledInstance(35, 40, java.awt.Image.SCALE_SMOOTH);
    	Pred2B.setIcon(new ImageIcon(Window.image));
    	Window.basic_panel.add(Pred2B);
    	ButtonPushed pawn2 = new ButtonPushed();
    	Pred2B.addActionListener(pawn2);
    	Pred2B.setVisible(true);
    	setX(0);
    	setY(0);
    }
	/**
	 *Moves the specific pawn when its clicked
	 */
	private class ButtonPushed implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Square.RedXArray[0] = 210;
			Square.RedYArray[0] = 55;
			Square.RedXArray[73] = 123;
			Square.RedYArray[73] = 287;
			if (Game.PlayersTurn == 1 && Game.lastID != "PawnRed2") 
			{
				new Controller.Move(getX(),getY(),ID.PlayerRed2,handler);
			}
			Game.lastID = "PawnRed2";
		}
	}
	
}
