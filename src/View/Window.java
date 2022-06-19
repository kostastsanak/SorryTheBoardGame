package View;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import Controller.Game;
import Model.Card;
import Model.Deck;

/**
 * Contains Every Graphic aspect of The game
 *
 */
public class Window extends JFrame {
	
	Deck d = new Deck();
	final int CardWidth =102 , CardHeight =156;
    public  final int WIDTH=1046,HEIGHT = 809;
	public static final int PlayerWidth =35,PlayerHeight =37;
	private String pos = "";
	Random r = new Random();
	private static final long serialVersionUID = 6526867452531219962L;
	static JButton tempCard;
	public static Image image;
	public static URL imageURL;
    public static JLayeredPaneExtension basic_panel;
    public static ClassLoader cldr;
    public String CardText="";
    
    JTextArea CardNumText ;
    
	JTextArea infobox;
    /**
     * Creates new form NewJFrame
     */
    public Window() {
        cldr = this.getClass().getClassLoader();
        this.setResizable(false);
        this.setTitle("Sorry BoardGame");
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        tempCard = new JButton(); //init Buttons
        //Background
        URL imageURL = cldr.getResource("resources//Map.png"); //image
        Image image = new ImageIcon(imageURL).getImage();
        basic_panel = new JLayeredPaneExtension(image);
               
      //Receive Card Text
        JLabel ReceiveCardText = new JLabel("Receive Card");
        ReceiveCardText.setBounds(800, 340, 100, 15);
        basic_panel.add(ReceiveCardText);
    	//Current Card Text
        JLabel CurrentCardText = new JLabel("Current Card");
        CurrentCardText.setBounds(938, 340, 100, 15);
        basic_panel.add(CurrentCardText);
    	
        
        //Deck
        JButton CardDisp = new JButton();
		CardDisp.setBounds(788, 176,102, 156); //thesi X, thesi Y, megethos X, megethos Y
    	Window.imageURL = Window.cldr.getResource("resources//CardNum//backCard.png");
    	Window.image = new ImageIcon(Window.imageURL).getImage();
    	CardDisp.setIcon(new ImageIcon(Window.image));
    	basic_panel.add(CardDisp);
    	
    	ButtonPushed ReceiveCard = new ButtonPushed();
    	CardDisp.addActionListener(ReceiveCard);
        
    	
    	
    	
    	
    	
    	
    	
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(basic_panel, GroupLayout.PREFERRED_SIZE, WIDTH, GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(basic_panel, GroupLayout.PREFERRED_SIZE, HEIGHT, GroupLayout.PREFERRED_SIZE));
        pack();
        
        
        
        
        
        basic_panel.repaint();
    }
    /**
	 * <Postcondition> : When Called draws a card
	 * <Precondition> : If its Called it gets the number of the Card and sets an the image for it
	 * @param x our pawn's X position
	 */
    public void DrawCard() {
     	JButton CardNum = new JButton();
		CardNum.setBounds(928, 176,CardWidth, CardHeight); //thesi X, thesi Y, megethos X, megethos Y
		int CardNumber = Card.GetCard();
		if (CardNumber ==0) {
			pos = "resources//CardNum//SorryCard.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Sorry Card Text
			CardText = "Sorry Card\n  If at least one of the enemy pawns \nisnt at a safe place\n  and at least one of your pawns is\nat the starting point\nChange place with the enemy pawn.";
		}else if (CardNumber == 1) {
			pos = "resources//CardNum//card1.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card1 Text
			CardText = "Card Number 1\n  Set your pawn to the Start\n Or\n  Move your Pawn 1 step forward.";
			}else if (CardNumber == 2) {
			pos = "resources//CardNum//card2.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card2 Text
			CardText = "Card Number 2\n  Set your pawn to the Start\n Or\n  Move your Pawn 2 step forward.\n And then re-draw";
		}else if (CardNumber == 3) {
			pos = "resources//CardNum//card3.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card3 Text
			CardText = "Card Number 3\n  Move your pawn 3 steps forward.";
		}else if (CardNumber == 4) {
			pos = "resources//CardNum//card4.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card4 Text
			CardText = "Card Number 4\n  Move your pawn 4 steps backwards.";
		}else if (CardNumber == 5) {
			pos = "resources//CardNum//card5.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card5 Text
			CardText = "Card Number 5\n  Move your pawn 5 steps forward.";
		}else if (CardNumber == 6) {
			pos = "resources//CardNum//card7.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card7 Text
			CardText = "Card Number 7\n   Move 7 steps forward\n OR \n  Split those 7 steps to 2 pawns. ";
		}else if (CardNumber == 7) {
			pos = "resources//CardNum//card8.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card8 Text
			CardText = "Card Number 8\n  Move your pawn 8 steps forward.";
		}else if (CardNumber == 8) {
			pos = "resources//CardNum//card10.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card10 Text
			CardText = "Card Number 10\n  Move your pawn 10 steps forward \nOR\n  Move your pawn 1 step backwards\n If 10 steps forwards cant be played\nYou must move 1 step backwards.";
		}else if (CardNumber == 9) {
			pos = "resources//CardNum//card11.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card11 Text
			CardText = "Card Number 11 \nMove your pawn 11 steps forward\n  OR change spots with an enemy pawn\nYou cant change spots if\nthe enemy pawn is at a safe spot. ";
		}else if (CardNumber == 10) {
			pos = "resources//CardNum//card12.png";
			Window.imageURL = Window.cldr.getResource(pos);
			//Card12 Text
			CardText = "Card Number 12\n  Move your pawn 12 steps forward.";
		}
		CardNumText = new JTextArea();
		CardNumText.setBounds(785, 37, 245, 120);
		CardNumText.setForeground(Color.red);
		CardNumText.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.ORANGE));
		CardNumText.setFont(new Font("Dialog", Font.PLAIN, 13));
		CardNumText.setOpaque(true);
		CardNumText.setText(CardText);
		CardNumText.setEditable(false);
		basic_panel.add(CardNumText);
    	Window.image = new ImageIcon(Window.imageURL).getImage();
    	CardNum.setIcon(new ImageIcon(Window.image));
    	basic_panel.add(CardNum);
    }
    private class ButtonPushed implements ActionListener{
    	
		public void actionPerformed(ActionEvent event) {
			if (Controller.Move.TheEnd == false) {
				if (Game.played == true) {
					if (Game.Card2 == true) {
						if(Game.PlayersTurn == 1) {Game.PlayersTurn =2; //Έδω ειναι το ζωντανό κομμάτι των γραφικών 
						}else {Game.PlayersTurn = 1;}					//Όλες οι αλλαγές όπως :Σειρά παίχτη ,τράβηγμα κάρτας,ανανέωση γραφικών γινεται εδώ
					}
					new Card(d.Card());
					Game.deck --;
					if (Game.deck == 0) {
						d.ShuffleDeck();
						Game.deck = 44;
					}
					if(Game.PlayersTurn == 1) {Game.PlayersTurn =2; 
					}else {Game.PlayersTurn = 1;}
					Info i= new Info();
					i.render();
					DrawCard();
					Game.lastID= "";
					if (Card.num == 2) {
						Game.Card2 = true;
					}else {
						Game.Card2 = false;
					}
				}
			}else {
				Info i = new Info();
				i.render();
			}
			Game.played = false;
		}
	}
    

    
}
