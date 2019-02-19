/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jword
 */
public class Space extends JPanel {

    private Player jeff;
    private Alien[] aliens;
    private ArrayList<Missile> missiles;
    private Timer timer;
    private boolean gameover;
    private long lastTime;
        
    public Space() {
        super();
        jeff = new Player(1200 / 2, 960 - 100);
        aliens = new Alien[20];
        missiles = new ArrayList<>();
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/24);
        lastTime = System.currentTimeMillis();
        spawnAliens();
    }
    
    private void spawnAliens() {
        for(int i = 0; i <20; i++){
        aliens[i] = new Alien(25 + i * 50, 50);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        long dT = System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        g.setColor(Color.red);
        g.drawString(String.format("Num aliens %d", aliens.length), 50, 50);
        this.setBackground(Color.BLACK);           
        jeff.draw(g);
        
        for (Alien alien : aliens) {
            if (alien != null)
            alien.draw(g);
        }
        for (Missile missile : missiles) {
            if (missile != null) {
                missile.draw(g);
            }
        }
        if(gameover == true) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.white);
            g.drawString("Game over", 325, 400);
}

    }
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            jeff.update();
            for (Missile missile : missiles) {
                    missile.update();
            } 
            
            for (Alien alien : aliens) {
                if (alien == null)
                    continue;
                wallCollisions(alien);
                alien.update();
                if (alien.getY() >= 700)
                    gameover = true;
                for (Missile missile : missiles) {
                    collisionDetection(alien, missile);
                }                      
            }
            repaint();
        }
    }
    private void collisionDetection(Character obj1, Character obj2) {
        if (obj1.getBound().intersects(obj2.getBound())) {
            obj1.die();
            obj2.die();
        }
    }
    private void wallCollisions(Character c) {
       
        if (c.getX() <= 0 || c.getX() + 30 >= this.getWidth()){
            c.setDx(-c.getDx());
        }
    }

    
    public void keyPressed(KeyEvent e) {
        final int SPEED = 9;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jeff.setDx(SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jeff.setDx(-SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            jeff.setDy(-SPEED);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jeff.setDy(SPEED);
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            jeff.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            jeff.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_UP)
            jeff.setDy(0);
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            jeff.setDy(0);
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            missiles.add( new Missile(jeff) );
            //missiles[0] = new Missile(jeff.getX(), jeff.getY());
    }   
    
    
    
    
    
}