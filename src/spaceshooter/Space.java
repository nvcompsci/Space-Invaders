/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
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
    private Missile[] missiles;
    private Timer timer;
        
    public Space() {
        super();
        jeff = new Player(1200 / 2, 960 - 100);
        aliens = new Alien[20];
        missiles = new Missile[5];
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/20);
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
        this.setBackground(Color.BLACK);           
        jeff.draw(g);
        
        for (Alien alien : aliens) {
            alien.draw(g);
        }
        for (Missile missile : missiles) {
            if (missile != null)
                missile.draw(g);
        }
        
    }
    
    private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            jeff.update();
            repaint();
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
            missiles[0] = new Missile(jeff.getX(), jeff.getY());
    }   
    
    
    
    
    
}