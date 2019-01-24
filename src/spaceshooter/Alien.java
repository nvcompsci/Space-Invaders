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
public class Alien extends Character {
    //Fields
    private ImageIcon ii;
    private Image img;
    
    //Constructor
    public Alien(int x, int y) {
        super(x, y);
        ii = new ImageIcon("alien.png");
        img = ii.getImage();
    }
    
    //Methods
    public void draw(Graphics g) {
        g.drawImage(img, super.getX(), super.getY(), super.getSize(), super.getSize(), null);
    }
}
