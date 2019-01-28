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
public class Missile extends Character {
    //Fields
    private ImageIcon ii;
    private Image img;
    
    //Constructor
    public Missile(int x, int y) {
        super(x, y);
        ii = new ImageIcon("missile.gif");
        img = ii.getImage();
    }
    
    //Methods
    public void draw(Graphics g) {
        g.drawImage(img, super.getX(), super.getY(), super.getSize(), super.getSize(), null);
    }
}
