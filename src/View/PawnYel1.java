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

public class PawnYel1  extends GameObject {

	public static JButton Pyel1B;
	Handler handler;
	public PawnYel1(ID id,Handler handler){
    	super(id);
    	this.handler = handler;
    }
	/**
	 *Shows the Graphic part of the that specific Pawn
	 */
	public void render() {
		Pyel1B = new JButton();
		Pyel1B.setBounds(510, 673,Window.PlayerWidth, Window.PlayerHeight); //thesi X, thesi Y, megethos X, megethos Y
    	Window.imageURL = Window.cldr.getResource("resources//Players//yelPawn1.png");
    	Window.image = new ImageIcon(Window.imageURL).getImage();
    	Window.image = Window.image.getScaledInstance(35, 40, java.awt.Image.SCALE_SMOOTH);
    	Pyel1B.setIcon(new ImageIcon(Window.image));
    	Window.basic_panel.add(Pyel1B);
    	
    	ButtonPushed pawn3 = new ButtonPushed();
    	Pyel1B.addActionListener(pawn3);
    	
    	Pyel1B.setVisible(true);
    	setX(0);
    	setY(0);
    }
	
	private class ButtonPushed implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Square.YelXArray[0] = 510;
			Square.YelYArray[0] = 673;
			Square.YelXArray[73] = 604;
			Square.YelYArray[73] = 437;
			
			if (Game.PlayersTurn == 2 && Game.lastID != "PawnYel1") 
			{
				new Controller.Move(getX(),getY(),ID.PlayerYel1,handler);
			}
			Game.lastID = "PawnYel1";
		}
	}
	
	
}
