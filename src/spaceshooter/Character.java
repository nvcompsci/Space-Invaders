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
        dx = -3;
        dy = -3;
    }
    
    //Methods
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
    
    public void update() {
        x += dx;
        y += dy;
    }
    
    public void moveTo() {
        
    }
    
    public void shoot() {
        
    }
    
    public void die() {
        
    }
    
    public void kill() {
        
    }
    
    public void respawn() {
        
    }
    
    //Getters and Setters

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
    
}
