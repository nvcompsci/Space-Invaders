/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;
/**
 *
 * @author jword
 */
public class Missile extends Character {
    
    //Constructor
    public Missile(Player player) {
        super(player.getX(),player.getY(), "/images/missile.gif");
        super.setDy(-10);
    }
}
