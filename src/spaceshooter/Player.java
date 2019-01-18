/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jword
 */
public class Player extends Character {
    
    //Fields
    Image img;
    //Constructor
    public Player(int x, int y) {
        super(x, y);
        ImageIcon ii = new ImageIcon("spaceship.png");
        img = ii.getImage();
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, super.getX(), super.getY(), super.getSize(), super.getSize(), null);
    }
    
}
