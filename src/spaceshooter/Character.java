/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jword
 */
public class Character {
    //Fields
    private int size;
    private Color color;
    private int x;
    private int y;
    private int dx;
    private int dy;
    
    //Constructor
    public Character() {
        size = 50;
        color = Color.RED;
        x = 300;
        y = 500;
        dx = 3;
        dy = 3;
    }
    
    public Character(int x, int y) {
        size = 50;
        color = Color.RED;
        this.x = x;
        this.y = y;
        dx = 3;
        dy = 3;
    }
    
    //Methods
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
    
    //Getters and Setters
}
