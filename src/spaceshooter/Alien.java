/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Color;
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
        super(x, y, "/images/alien.png");
        super.setDy(1);
        super.setDx(5);
    }    
}
