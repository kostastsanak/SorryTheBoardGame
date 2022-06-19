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

public class PawnYel2  extends GameObject {


	public static JButton Pyel2B;
	Handler handler;
	public PawnYel2(ID id,Handler handler){
    	super(id);
    	this.handler = handler;
    }
	public void render() {
		Pyel2B = new JButton();
		Pyel2B.setBounds(550, 673,Window.PlayerWidth, Window.PlayerHeight); //thesi X, thesi Y, megethos X, megethos Y
    	Window.imageURL = Window.cldr.getResource("resources//Players//yelPawn2.png");
    	Window.image = new ImageIcon(Window.imageURL).getImage();
    	Window.image = Window.image.getScaledInstance(35, 40, java.awt.Image.SCALE_SMOOTH);
    	Pyel2B.setIcon(new ImageIcon(Window.image));
    	Window.basic_panel.add(Pyel2B);
    	ButtonPushed pawn4 = new ButtonPushed();
    	Pyel2B.addActionListener(pawn4);
    	
    	Pyel2B.setVisible(true);
    	setX(0);
    	setY(0);
    }
	
	/**
	 *Moves the specific pawn when its clicked
	 */
	private class ButtonPushed implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Square.YelXArray[0] = 550;
			Square.YelYArray[0] = 673;
			Square.YelXArray[73] = 652;
			Square.YelYArray[73] = 437;
			
			if (Game.PlayersTurn == 2 && Game.lastID != "PawnYel2") 
			{
				new Controller.Move(getX(),getY(),ID.PlayerYel2,handler);
			}
			Game.lastID = "PawnYel2";
		}
	}
	
	
}
