package View;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLayeredPane;

/**
 *
 * @author Michalis
 */
public class JLayeredPaneExtension extends JLayeredPane {


	private static final long serialVersionUID = -3823098211618242382L;
	Image image;

        public JLayeredPaneExtension(Image img) {
            image=img;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);       	
        }
    }