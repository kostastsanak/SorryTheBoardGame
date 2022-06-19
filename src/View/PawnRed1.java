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


public class PawnRed1 extends GameObject {


	public static JButton Pred1B;
	Handler handler;
	public PawnRed1(ID id,Handler handler){
    	super(id);
    	this.handler = handler;
    }
    
    
	/**
	 *Shows the Graphic part of the that specific Pawn
	 */
	public void render() {
		Pred1B = new JButton();
		Pred1B.setBounds(Square.Red1StartX, Square.Red1StartY,Window.PlayerWidth, Window.PlayerHeight); //thesi X, thesi Y, megethos X, megethos Y
    	Window.imageURL = Window.cldr.getResource("resources//Players//redPawn1.png");
    	Window.image = new ImageIcon(Window.imageURL).getImage();
    	Window.image = Window.image.getScaledInstance(35, 40, java.awt.Image.SCALE_SMOOTH);
    	Pred1B.setIcon(new ImageIcon(Window.image));
    	Window.basic_panel.add(Pred1B);
    	ButtonPushed pawn1 = new ButtonPushed();
    	Pred1B.addActionListener(pawn1);
    	Pred1B.setVisible(true);
    	setX(0);
    	setY(0);
    	
    }
	
	
	/**
	 *Moves the specific pawn when its clicked
	 */
	private class ButtonPushed implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Square.RedXArray[0] = 170;
			Square.RedYArray[0] = 55;
			Square.RedXArray[73] = 80;
			Square.RedYArray[73] = 287;

			if (Game.PlayersTurn == 1 && Game.lastID != "PawnRed1") 
			{
				new Controller.Move(getX(),getY(),ID.PlayerRed1,handler);
			}
			Game.lastID = "PawnRed1";
		}
	}
	
	
	
}
