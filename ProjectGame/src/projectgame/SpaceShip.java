/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectgame;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

public class SpaceShip {
    public ImageIcon spaceship = new ImageIcon(this.getClass().getResource("spaceship.png"));
    public int x;
    public int y;
    public int w = 83;
    public int h = 110;
    public int count = 0;
    
    SpaceShip(){
        this.x = x;
        this.y = y;
    }
    
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,110,83));
    }
}
