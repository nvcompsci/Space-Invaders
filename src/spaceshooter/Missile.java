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
    public Missile(int x, int y) {
        super(x, y, "missile.gif");
        super.setDy(-10);
    }
}
